package service;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;

import com.sun.tools.javac.Main;

public class chatGptService {
	private static HttpURLConnection connection;

	public static void main(String[] args) throws IOException {
		// BufferedReader reader;
		// String line;
		// StringBuffer responseContent = new StringBuffer();
		//
		// URL url = new URL("https://jsonplaceholder.typicode.com/posts");
		// connection = (HttpURLConnection) url.openConnection();
		// connection.setRequestMethod("GET");
		// connection.setConnectTimeout(5000);
		// connection.setReadTimeout(5000);
		// int status = connection.getResponseCode();
		// System.out.println(status);
		//
		// reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		// while((line = reader.readLine())!=null){
		// 	responseContent.append(line);
		// }
		// reader.close();
		// System.out.println(responseContent.toString());
		// connection.disconnect();

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts")).build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
			.thenApply(chatGptService::parse)
			.join();

	}
	public static String parse(String responseBody){
		JSONArray posts = new JSONArray(responseBody);
		System.out.println(posts.get(0).toString());
		return posts.get(0).toString();
	}
}
