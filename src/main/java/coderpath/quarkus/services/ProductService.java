package coderpath.quarkus.services;


import coderpath.quarkus.entites.Product;
import coderpath.quarkus.repositories.ProductRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import jakarta.inject.Inject;
import org.bson.Document;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProductService {

    @Inject
    MongoClient mongoClient;

    @Inject
    ProductRepository productRepository;


    public List<Product> list(){
        List<Product> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Product product = new Product();
                product.setName(""+document.getString("name"));
                product.setDescription(""+document.getString("description"));
                list.add(product);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Product product){
        Document document = new Document()
                .append("name", product.getName())
                .append("description", product.getDescription());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("product").getCollection("product");
    }



    public Product findByName(String name){
        return productRepository.find("name", name).firstResult();
    }

    public List<Product> findDisposable(){
        return productRepository.list("status", ObjectInputFilter.Status.ALLOWED);
    }

    public void deleteLoics(){
        productRepository.delete("name", "Loïc");
    }

}
