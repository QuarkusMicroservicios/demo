package coderpath.quarkus.resteasyjackson;


import java.net.URI;
import java.util.List;
import coderpath.quarkus.services.ProductService;
import jakarta.ws.rs.*;
import org.bson.types.ObjectId;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import coderpath.quarkus.entites.Product;
import jakarta.inject.Inject;


@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductApi {
 @Inject
 ProductService service;

    @GET
    public List<Product> list() {
        return service.findDisposable();
    }

    @POST
    public Response add(Product p) {
        service.add(p);
        return Response.ok().build();
    }
    @PUT
    @Path("/id/{id}")
    public Response update(@PathParam("id")  String id, Product p) {
         p = Product.findById(new ObjectId(id));
          service.add(p);
        return Response.ok().build();
    }


    @DELETE
    public Response delete(Product p) {
        service.deleteLoics();
        return Response.ok().build();
    }


 /*   @GET
    public List<Product> allProducts() {
        return Product.listAll();
    }*/

    @GET
    @Path("/id/{id}")
    public Response getProduct(@PathParam("id") String id) {
        var product = Product.findById(new ObjectId(id));
        return product != null
                ? Response.ok(product).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

   /* @POST
    public Response addProduct(Product product  ) {
        product.persist();
        return Response.created(URI.create("/add/product"+ product.getId())).entity(product).build();
    }*/
}
