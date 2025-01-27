package br.edu.unyleya.pos.graduacao.dev.jakarta.controller;

import java.util.List;

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
        return repository.find(id);
    }

    @GET
    @Produces("application/json")
    @Operation(summary = "Get all empresa", description = "Get all empresa")
    public List<Empresa> findAll() {

        return repository.findAll(Empresa.class);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Operation(summary = "Post empresa", description = "Post empresa")
    public Empresa create(Empresa empresa) {

        try {
            return repository.save(empresa);
        } catch (PersistenceException ex) {

            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete empresa", description = "Delete empresa")
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
    @Operation(summary = "Atualiza empresa", description = "Atualiza empresa")
    public Empresa update(Empresa empresa) {

        try {
            return repository.update(empresa);
        } catch (PersistenceException ex) {

            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
