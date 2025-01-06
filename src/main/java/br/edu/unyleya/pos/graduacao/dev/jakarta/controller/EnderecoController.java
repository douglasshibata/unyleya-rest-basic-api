package br.edu.unyleya.pos.graduacao.dev.jakarta.controller;

import java.util.List;

import br.edu.unyleya.pos.graduacao.dev.jakarta.model.Endereco;
import br.edu.unyleya.pos.graduacao.dev.jakarta.repository.EnderecoRepository;
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


@Path("endereco")
@Tag(name = "Endereco REST", description = "CRUD da endereco")
public class EnderecoController {

    @Inject
    private EnderecoRepository repository;

    @GET
    @Path("{id}")
    @Produces("application/json")
    @Operation(summary = "Get endereco by id", description = "Get endereco by id")
    // @ApiResponses(value = {
    // @ApiResponse(responseCode = "200", description = "Successfully retrieved
    // list"
    // // content = @Content(mediaType = "application/json",
    // // schema = @Schema(implementation = Customer.class))
    // ),
    // @ApiResponse(responseCode = "500", description = "Internal server error")
    public Endereco findById(@PathParam("id") Long id) {
        return repository.find(id);
    }

    @GET
    @Produces("application/json")
    @Operation(summary = "Get all endereco", description = "Get all endereco")
    public List<Endereco> findAll() {

        return repository.findAll(Endereco.class);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Operation(summary = "Post endereco", description = "Post endereco")
    public Endereco create(Endereco endereco) {

        try {
            return repository.save(endereco);
        } catch (PersistenceException ex) {

            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete endereco", description = "Delete endereco")
    public void delete(@PathParam("id") Long id) {

        try {
            repository.delete(repository.find(id));
        } catch (IllegalArgumentException e) {

            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Operation(summary = "Atualiza endereco", description = "Atualiza endereco")
    public Endereco update(Endereco endereco) {

        try {
            return repository.update(endereco);
        } catch (PersistenceException ex) {

            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
