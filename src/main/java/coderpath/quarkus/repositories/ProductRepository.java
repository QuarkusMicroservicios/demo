package coderpath.quarkus.repositories;



import coderpath.quarkus.entites.Product;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class ProductRepository implements PanacheMongoRepository<Product> {

}
