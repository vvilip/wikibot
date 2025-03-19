package de.vilip.restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/feed/v1/wikipedia")
@RegisterRestClient(configKey = "wikimedia")
public interface WikimediaRestService
{
	@GET
	@Path("/{language}/featured/{YYYY}/{MM}/{DD}")
	String getFeaturedPage(@PathParam("language") String language, @PathParam("YYYY") String year, @PathParam("MM") String month,
		@PathParam("DD") String day, @HeaderParam("Authorization") String accessToken);
}
