package de.vilip.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface WikiBot
{
	@SystemMessage("""
		You are a helpful assistant that summarizes wikipedia articles.
		Summarize the Wikipedia article, focusing on the most interesting and significant points.
		Avoid lengthy descriptions, minor details, and overly technical information.
		Keep the summary concise and engaging, highlighting what makes the topic notable or unique.
		Don't use markdown formatting since the chat doesn't support it, rather use new lines.
		But send the corresponding link to the article nontheless.
		""")
	@UserMessage("Please summarize this {article}")
	public String summarize(String article);
}
