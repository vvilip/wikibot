package de.vilip.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import de.vilip.utils.ObjectMapperUtils;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResponseJSONProcessor
{
	private static final Logger log = LoggerFactory.getLogger(ResponseJSONProcessor.class);
	private static final String TODAY_FEATURED_ARTICLE = "tfa";
	private static final String API_CHANGE = "Perhaps a change in the wikimedia api caused this failing";

	public String getFeaturedArticle(String article)
	{
		try
		{
			JsonNode rootNode = ObjectMapperUtils.objectMapper.readTree(article);
			JsonNode element = rootNode.path(TODAY_FEATURED_ARTICLE);
			return element.toString();
		}
		catch (JsonProcessingException e)
		{
			log.info(API_CHANGE);
			throw new RuntimeException(e);
		}
	}
}
