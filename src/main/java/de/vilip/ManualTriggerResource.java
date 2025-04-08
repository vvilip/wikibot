package de.vilip;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("/trigger")
public class ManualTriggerResource
{
	@Inject
	WikiBotService wikiBotService;

	@POST
	public void triggerSummarization()
	{
		wikiBotService.sendMessage();
	}
}
