package service;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.tools.javac.Main;

public class chatGptService {
	public static String getApiData(String question) throws IOException {
		String requestRaw = "{\"action\":\"next\",\"messages\":[{\"id\":\"2eb819cc-ca26-4fd2-9baa-efae65f23dd7\",\"role\":\"user\",\"content\":{\"content_type\":\"text\",\"parts\":[\"눈이오는이유\"]}}],\"parent_message_id\":\"1634cc39-cb54-40d8-9fb2-6653585aa755\",\"model\":\"text-davinci-002-render\"}";
		JSONObject requestBody = new JSONObject(requestRaw);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://chat.openai.com/backend-api/conversation"))
			.POST(HttpRequest.BodyPublishers.ofString(requestRaw))
			.header("authority","chat.openai.com")
			.header("accept","text/event-stream")
			.header("accept-language","ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
			.header("authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik1UaEVOVUpHTkVNMVFURTRNMEZCTWpkQ05UZzVNRFUxUlRVd1FVSkRNRU13UmtGRVFrRXpSZyJ9.eyJodHRwczovL2FwaS5vcGVuYWkuY29tL3Byb2ZpbGUiOnsiZW1haWwiOiJtYXNjb2Vza2ltQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJnZW9pcF9jb3VudHJ5IjoiS1IifSwiaHR0cHM6Ly9hcGkub3BlbmFpLmNvbS9hdXRoIjp7InVzZXJfaWQiOiJ1c2VyLVdSbHZmbERaenE0ODhoNkJxd0doQlN5WSJ9LCJpc3MiOiJodHRwczovL2F1dGgwLm9wZW5haS5jb20vIiwic3ViIjoiZ29vZ2xlLW9hdXRoMnwxMDY3MTI1NjcyMjU5OTE5ODgzMzYiLCJhdWQiOlsiaHR0cHM6Ly9hcGkub3BlbmFpLmNvbS92MSIsImh0dHBzOi8vb3BlbmFpLmF1dGgwLmNvbS91c2VyaW5mbyJdLCJpYXQiOjE2NzEwNjUzNzksImV4cCI6MTY3MTEwODU3OSwiYXpwIjoiVGRKSWNiZTE2V29USHROOTVueXl3aDVFNHlPbzZJdEciLCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIG1vZGVsLnJlYWQgbW9kZWwucmVxdWVzdCBvcmdhbml6YXRpb24ucmVhZCBvZmZsaW5lX2FjY2VzcyJ9.yNJPANaplv-tJC-pOzOHCuq3xaqvYQ0fOYbR9JvAQRGPwhKgdsW4v_mGsNe2zrCEqqfl4riupALNxv6w2IoftmUJ4onhhize9QhbPC6l1oeloTuTsoXW1DfstuPKaIZJ3jiwX8iXo4sNzkBVnIAq247_LNvneAJjtQQrFZIKN4sNeZQh9h-K1KxubxxxjRCs9uoCzQ4NRxCgfP1TziMMsGFRT38BdGrLFwh9fXy2oOTqBRc587XEJYxOS0K_4HyUYUpxXAsvl_JyAZ6vWxmpCThASP2LJp10hN-4KEaFGx1VT2NAfXYpDr0p7f_qCp1o2lJ3epr-haaprKyT5sve3g")
			.header("content-type", "application/json")
			.header("cookie","_ga=GA1.2.213019781.1670570474; intercom-device-id-dgkjq2bp=448438ad-b13e-4a9d-868b-008ec225b569; intercom-session-dgkjq2bp=bnhYZDdHKzVJc2ltVTl2SVFSdWtMZjJzRWhWeStFTDBxb1IyZUZmQkQ0eFlaUGtEMytFYWJoZ3hWRmZFMGJTKy0tUVY0SE9jMUdLemZ1UXllNjEzM3YxQT09--2dabe439de54788fb6bc84ae02e6a6b74d73b2d2; _gid=GA1.2.2029602753.1671064429; __Host-next-auth.csrf-token=be6ed96e2606a0e8581fe5c2164d702f880798835fd6c57bd7312742d98cc9a5|b60c061dd14acc5fec6f57da073c82d06d78316746e3f6b9c0888e2b05ab8fbf; __Secure-next-auth.callback-url=https://chat.openai.com/; cf_clearance=jvUSfFwbKmPJJ1X1lPua116XIDB8lkoAj1SNC5aWPbg-1671075741-0-1-ace7b46.84bbe5d5.f3b69d3a-160; __cf_bm=hXBTEhibzisH3.YzuY0Tcic2c89Wh2V8nbZzzF_M4r0-1671075742-0-AVG3UWfX+cclrxDv+qNWvlJLkOVP4UTlsl4eXWmkx+najQmesy+PXX9sUBsIcsAhjeFZrRiqJe7FuGXpQVNnrerdKofF0L25ojAPy0wHWXvduf36IHAxizLpWOKPbCGYsBGwyx8pN0LdTHVw7TeJkYnt+y3yOmCDy4byl0FpwNz38zr0i/YAPVokIbxohwserQ==; __Secure-next-auth.session-token=eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..Y5NOTXuAC8P654JC.yUyvUg850ybK3hv03k2Y96QZQzQCh9F1eA2FLRBYPZi39-mvp09_RpIjmd4cTAN-CuHjVCH2OfVkfYWtAdzs9hdgyzRsw_Am4INhErDTHM4w8ALX_yWIl1IuV3w4DmFIhAytHNMxn5LgqGgP1KN0ENJdA-A1DfSGA7J7s2LjRaQrjYL81m4dJhjroYTty3XNIt_KDPhP4hNispOfPQBe8ZLCVyekdr2Qc5TG7JaJ7lz1eJXnltqELY3aewZ5-sGblURUeJWa9VF6Ibc9MrkWlHYfiL1o76-bt-v7BZNG3HvZab4vqPdwYEffHunp19hPuEpr2QxKrrKwPYBhegHqEeqtSreQ9WWX5ms-FIDbIB9D9MR9u3TnPQcorpm3NgUSYumz5xGYG9lfjC-YPzK7FboZRIdWPCa1Bq4ICWKD_WcFljVo31353VeLvXmgMA7-oA-NtMjrecNA1To1-ROsASY_gxTefpeCQRXY97iAYGkNqOn0cHp3hS88KnX11V-lZ9ce3BVC-n78hTs-90D_iVQfr-AZbbnWbtwbOaTXtmw8sRtOFvU0V5_ysEmN_YovxBXfTkwDQCmbqgQ9N8rDrxfXcSVGbgU7fuK1waHwvtMFywimBkJy92XdiEEyvC7vBH8tQJx8ESqaCEmR3rPNxQMUtNGkBXHRSYTyoSJx8zDVZmWHH5c2qT5RIJ5PUujxq1W4fS-MosypgGPYQ1D-dV84KbXh5Xx6QAJsFZjFniMCXERcuzz7FlFwO-uQzZ0IIa6uvPRhxZY9FwHqu-WSq5h8oJ81tod5N8Plzjc6BJNvisi97PPjE-aIWafSdriOJWPT8LKKbJkwp3ESlC639E8fV5U8mgJ_6avz9CREVr24KTjg64UFVy0Brod9kV4JT9FLj5kD8W4HbQhS5jUaDOdlF7wF3KPqDydj2n8Wwmjv2LrsyFVAk_aFd4lbxhHpdM4pmqDD6I6P5rSuL8iPxiHN8LYQ04ryeEWBKxbAMvvory1AT13nSNm9TNQQWozKkTEzFk-ahOzSK6Bg5o3vjlF9-n1f6gqFR2gcFK7o1qMUzuuts2mBADLz_gjYzlfswgwmJ8jYskpv_et0dW84-ARCmhTniubc6U7FWo7ga2okVDjMFE4kQ5pT7cxFAFK5-SpSkwRzDaBHmHWq4CYX4LtwmKw0cHArzK5QCqeA-iPNp4xAho0HYRABxPhoNjBr0UG40ahyStNybw6Ro_iaB5ZyFOMchjzowrlVtnTTczD11RUTRqg3SewwpQObfPHekCU5G-284XtRSagnpc890pAQ2M8YSKQj76YX4JXfwkfxMc-ugeexSlRsSAIufbFZgILx1u7Y0gQ2IM9et2bqvR7-ntH8fXiOq9tTJmX29GR_18pJ6Tvcaxh64RfarBCn8y3gQhbD8CV0LYsDP39pwfd3SlRnEE07JviCGEeZ8aGPGfi5T2i5t9y-3XPpm3tPNwKNjn8zfnur1QMb_KZGi7iCMTRyidhqtBV6N9e2SyOh7wmqImHnF5Sa9SMDGjoqWQr58f92oI2_6OwLKo3iy2EqMOfkoTVtdfT_8l0p_dUw63wo5sYAitOnhQaMmnQnCw5YLVTlm-qlDq9Hn8u8B4BxF15LeSmkgnGWVO-Ogl0li-jtZ4ZAQYUOM2Oy3bmVvPITW9Y6gbR47rfK1PAHp-RIliPx8WlDeZm_KYK_gZ7AOmAp2IbaIpL9gEsdxjZrc2TSmqBztJ1Xqaa_CSlaXPR0Rj5uj-AC3AtciDfsycxB903g3YVA9aRuoopd9udj2hcIId0H-8oURjrcTki7IZHfeank1pW75YMLkOrjB3F1n3tFy0aDnLUOU_RGQ9als5jeNuVKN7SO65grZugTa-nkyFsK7LvFjlY7YoN0dzp6iF8ZULyYQ72DusFR8ApV65zwxtzYSj6bf99hxZ0F0SGSZ0xMRT-7mLeDntbgf4el1NFOZA0_NmnRoPeOfjuhBTc8rpfWEMtf2cdoex79xlPj2ZMh0eN-tcmyookPh96xFqZD1CZJDWiflpBATnhTx0_Btz1b4uGISY7qLwboVe1K4E5xdldbaK8sRtPaCtmz9JMp0ySzrKeyFwrzIJeQMbpj6Kqc1fULYQyZlxS-1GcKHFwwWAaA85viUrqAYa2YgGI0IMJuE9kURcN_d_YRRWENOpOCotey-n4ltW8YyHUdEtFexrgFEzJGMiZVkwjLopWAPWtNrmPivfkCeTRwRqYFgq1d.QHwUtJwx5rjNdIiYFDqFgQ")
			.header("origin","https://chat.openai.com")
			.header("referer","https://chat.openai.com/chat")
			.header("sec-ch-ua","\"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108\"")
			.header("sec-ch-ua-mobile","?0")
			.header("sec-ch-ua-platform","\"Linux\"")
			.header("sec-fetch-mode","cors")
			.header("sec-fetch-site","same-origin")
			.header("user-agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
			.header("x-openai-assistant-app-id","")
			.build();

		String result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
			// .thenAccept(System.out::println)
			// .thenApply(chatGptService::parse)
			.join();
		return result;


	}
	public static String parse(String responseBody){
		JSONArray posts = new JSONArray(responseBody);
		JSONObject post = new JSONObject(posts.get(0).toString());
		return post.getString("website");
	}
}
