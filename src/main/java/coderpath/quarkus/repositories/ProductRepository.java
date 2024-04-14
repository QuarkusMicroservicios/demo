package coderpath.quarkus.repositories;



import coderpath.quarkus.entites.Product;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;
import java.io.ObjectInputFilter;


@ApplicationScoped
public class ProductRepository implements PanacheMongoRepository<Product> {

}
