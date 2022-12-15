package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import util.reqEnv;

public class chatGptService {
	public static String getApiData(String question) throws IOException {
		String requestRaw = "{\"action\":\"next\",\"messages\":[{\"id\":\"2eb819cc-ca26-4fd2-9baa-efae65f23dd7\",\"role\":\"user\",\"content\":{\"content_type\":\"text\",\"parts\":[\"눈이오는이유\"]}}],\"parent_message_id\":\"1634cc39-cb54-40d8-9fb2-6653585aa755\",\"model\":\"text-davinci-002-render\"}";
		JSONObject requestBody = new JSONObject(requestRaw);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(reqEnv.uri))
			.POST(HttpRequest.BodyPublishers.ofString(requestRaw))
			.header("authority", reqEnv.authority)
			.header("accept", "text/event-stream")
			.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
			.header("authorization", reqEnv.authorization)
			.header("content-type", "application/json")
			.header("cookie", reqEnv.cookie)
			.header("origin", "https://chat.openai.com")
			.header("referer", "https://chat.openai.com/chat")
			.header("sec-ch-ua", "\"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108\"")
			.header("sec-ch-ua-mobile", "?0")
			.header("sec-ch-ua-platform", "\"Linux\"")
			.header("sec-fetch-mode", "cors")
			.header("sec-fetch-site", "same-origin")
			.header("user-agent",
				"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
			.header("x-openai-assistant-app-id", "")
			.build();

		String result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenApply(chatGptService::parse)
			.join();
		return result;

	}

	public static String parse(String responseBody) {
		JSONArray posts = new JSONArray(responseBody);
		JSONObject post = new JSONObject(posts.get(0).toString());
		return post.getString("data");
	}
}
