package coderpath.quarkus.entites;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
/*@Entity*/
import java.lang.annotation.Documented;
import java.util.Objects;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.hibernate.engine.spi.Status;

@Data
@MongoEntity(collection = "producto")
//@Entity(name = "producto")
public class Product extends PanacheMongoEntity {

   @BsonProperty("productname")
    public String name;
    public String description;
    public Status status;
    private String id;
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

