package webservices;

import metiers.LogementBusiness;
import entities.Logement;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logement")
public class LogementRessources {

    LogementBusiness help = new LogementBusiness();


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLogements() {
        List<Logement> logements = help.getLogements();
        return Response
                .status(200)
                .entity(logements.isEmpty() ? null : logements)
                .build();
    }

    @GET
    @Path("/helloLogement")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response
                .status(200)
                .entity("Welcome to Logement !")
                .build();
    }

    @GET
    @Path("/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementDetails(@PathParam(value = "id") int id) {
        Logement logement = help.getLogementsByReference(id);
        if (logement != null) {
            return Response
                    .status(200)
                    .entity(logement)
                    .build();
        }
        return Response
                .status(200)
                .build();
    }

    @GET
    @Path("/list/{deleguation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementsByDeleguation(@PathParam(value = "deleguation") String deleguation) {
        List<Logement> logements = help.getLogementsByDeleguation(deleguation);
        return Response
                .status(200)
                .entity(logements.isEmpty() ? null : logements)
                .build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addLogement(Logement logement) {
        boolean added = help.addLogement(logement);
        return Response
                .status(200)
                .entity(added ? "Logement added successfully" : "Failed to add logement")
                .build();
    }

    @PUT
    @Path("/update/{reference}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateLogement(@PathParam(value = "reference") int reference, Logement logement) {
        boolean updated = help.updateLogement(reference, logement);
        return Response
                .status(200)
                .entity(updated ? "Logement updated successfully" : "Logement not found for update")
                .build();
    }

    @DELETE
    @Path("/delete/{reference}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteLogement(@PathParam(value = "reference") int reference) {
        boolean deleted = help.deleteLogement(reference);
        return Response
                .status(200)
                .entity(deleted ? "Logement deleted successfully" : "Logement not found for deletion")
                .build();
    }
}
