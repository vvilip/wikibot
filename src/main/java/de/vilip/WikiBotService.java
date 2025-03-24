package de.vilip;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.vilip.ai.WikiBot;
import de.vilip.matrix.MatrixService;
import de.vilip.restclient.ResponseJSONProcessor;
import de.vilip.restclient.WikimediaRestService;
import de.vilip.utils.DateUtils;
import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.Tokens;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class WikiBotService
{
	private static final String ENGLISH = "en";
	private static final Logger log = LoggerFactory.getLogger(WikiBotService.class);

	@Inject
	OidcClient oidcClient;

	@RestClient
	WikimediaRestService wikimediaRestService;

	@Inject
	MatrixService matrixService;

	@Inject
	WikiBot wikiBot;

	@Inject
	ResponseJSONProcessor responseJSONProcessor;

	@Scheduled(cron = "{cron.expr}")
	void sendMessage()
	{
		log.info("Start fetching article...");
		matrixService.sendMessage(summarizeArticle(getArticle()));
	}

	private String summarizeArticle(String article)
	{
		log.info("Start summarizing...");
		return wikiBot.summarize(responseJSONProcessor.getFeaturedArticle(article));
	}

	private String getArticle()
	{
		Tokens tokens = oidcClient.getTokens().await().indefinitely();
		return wikimediaRestService.getFeaturedPage(ENGLISH,
			DateUtils.getCurrentYear(), DateUtils.getCurrentMonth(),
			DateUtils.getCurrentDay(), tokens.getAccessToken());
	}
}
