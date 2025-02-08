package webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/hello")
public class HelloRessources {

    @GET
    @Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello(){
        return Response.
                status(200).
                entity( "Hello Word!").
                build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHelloT(@PathParam(value="name") String name){
        return Response.
                status(200).
                entity( "Hello Word " +name+"!").
                build();
    }
}
