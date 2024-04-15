package coderpath.quarkus.entites;


import java.util.Objects;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.hibernate.engine.spi.Status;

@Data
@MongoEntity(collection = "producto")
public class Product extends PanacheMongoEntity {

   @BsonProperty("productname")
    public String name;
    public String description;
    public Status status;
    public String id;

    public Product() {
    }
  
    public Product(String name, String description) {
      this.name = name;
      this.description = description;
    }
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public String getDescription() {
      return description;
    }
  
    public void setDescription(String description) {
      this.description = description;
    }
  
    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Product)) {
        return false;
      }
  
      Product other = (Product) obj;
  
      return Objects.equals(other.name, this.name);
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.name);
    }
  
    public void setId(String id) {
      this.id = id;
    }
  
    public String getId() {
      return id;
    }
  }
  
  