package main;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Product;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyApi {

    @GET
    public List<Product> getProducts() throws SQLException {
    	return ProductDao.getProducts();
    }
    
    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") long id) throws SQLException {        
    	return ProductDao.getProduct(id);
    }
    
    @POST
    public void addProduct(Product product) throws SQLException{    	
    	ProductDao.addProduct(product);
    }
   
    @PUT
    public void updateProduct(Product product) throws SQLException {
    	ProductDao.updateProduct(product);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") long id) throws SQLException{    	
    	ProductDao.deleteProduct(id);
    }
}
