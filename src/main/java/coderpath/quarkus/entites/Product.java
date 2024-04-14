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
    public String id;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}

