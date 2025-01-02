package br.edu.unyleya.pos.graduacao.dev.jakarta.resources.hello;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("hello")
@Tag(name = "Hello World", description = "Hello World")
public class HelloWorldResource {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	 @Operation(summary = "Hello World", description = "Returns a hello world")
    // @ApiResponses(value = {
    //         @ApiResponse(responseCode = "200", description = "Successfully retrieved list"
    //                 // content = @Content(mediaType = "application/json",
    //                 //         schema = @Schema(implementation = Customer.class))
	// 				),
    //         @ApiResponse(responseCode = "500", description = "Internal server error")
	public Hello hello(@QueryParam("name") String name) {
		if ((name == null) || name.trim().isEmpty())  {
			name = "world";
		}

		return new Hello(name);
	}
}