package br.edu.unyleya.pos.graduacao.dev.jakarta.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

import br.edu.unyleya.pos.graduacao.dev.jakarta.model.Empresa;
import br.edu.unyleya.pos.graduacao.dev.jakarta.repository.EmpresaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("empresa")
@Tag(name = "Empresa REST", description = "CRUD da empresa")
public class EmpresaController {
    private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    private EmpresaRepository repository;

    @GET
    @Path("{id}")
    @Produces("application/json")
    @Operation(summary = "Get empresa by id", description = "Get empresa by id")
    // @ApiResponses(value = {
    // @ApiResponse(responseCode = "200", description = "Successfully retrieved
    // list"
    // // content = @Content(mediaType = "application/json",
    // // schema = @Schema(implementation = Customer.class))
    // ),
    // @ApiResponse(responseCode = "500", description = "Internal server error")
    public Empresa findById(@PathParam("id") Long id) {
        logger.info("Getting empresa by id " + id);
        return repository.findById(id)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces("application/json")
    @Operation(summary = "Get all empresa", description = "Get all empresa")
    public List<Empresa> findAll() {
        logger.info("Getting all empresa");
        return repository.findAll();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Operation(summary = "Post empresa", description = "Post empresa")
    public Empresa create(Empresa empresa) {
        logger.info("Creating empresa " + empresa.getNome());
        try {
            return repository.create(empresa);
        } catch (PersistenceException ex) {
            logger.info("Error creating empresa " + empresa.getNome());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete empresa", description = "Delete empresa")    
    public void delete(@PathParam("id") Long id) {
        logger.info("Deleting empresa by id " + id);
        try {
            repository.delete(id);
        } catch (IllegalArgumentException e) {
            logger.info("Error deleting empresa by id " + id);
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Operation(summary = "Atualiza empresa", description = "Atualiza empresa")    
    public Empresa update(Empresa empresa) {
        logger.info("Updating empresa " + empresa.getNome());
        try {
            return repository.update(empresa);
        } catch (PersistenceException ex) {
            logger.info("Error updating empresa " + empresa.getNome());
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
