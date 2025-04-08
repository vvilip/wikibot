# Wikibot

A simple Matrix bot that summarizes the daily featured Wikipedia article in a concise and engaging manner.

<b> Features: </b>

- Summarization: Automatically generates a short, engaging summary of a Wikipedia article.

- Focus on Essentials: Keeps the most important and unique aspects of the topic, while omitting technical jargon,
  lengthy descriptions, and minor facts.

- Customizable Output: You can tweak the prompt to fine-tune the summarization process.

<b>How It Works: </b>

1. The tool fetches the daily featured Wikipedia article

2. The fetched article gets summarized by an LLM

3. The summarization gets sent via Matrix to any chatroom

<b>  Get the image </b>:

```
docker pull ghcr.io/vvilip/wikibot:latest
```

<b>Run it locally: </b>

1. Create an account at [Wikimedia](https://api.wikimedia.org/wiki/Main_Page)
2. For authentication create a client secret & id
3. Create an account at [OpenAI](https://platform.openai.com/docs/overview)
4. Get yourself an API Key
5. Set all the env variables correctly:

| Name            | Description                                                                  | Example Value                    |
|-----------------|------------------------------------------------------------------------------|----------------------------------|
| CLIENT_ID       | The client id from wikimedia                                                 | -                                |
| CLIENT_SECRET   | The client secret from wikimedia                                             | -                                |
| MATRIX_HOSTNAME | The hostname of your matrix server                                           | matrix.yourserver.com            |
| MATRIX_USERNAME | The username of your matrix bot account                                      | cool bot                         |
| MATRIX_PASSWORD | The password of your matrix bot account                                      | some password                    |
| MATRIX_ROOM_ID  | The room id in which the bot should write                                    | -                                |
| OPENAI_API_KEY  | The API key from OpenAI                                                      | sk-...                           |
| CRON_EXPR       | An unix cron expression for when the bot<br/>is supposed to send the message | 0 10 * * * (for 10 am every day) |
