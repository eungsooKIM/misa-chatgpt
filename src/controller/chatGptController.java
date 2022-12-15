package controller;

import java.io.IOException;

import service.chatGptService;
import util.message;

public class chatGptController {
	public static void main() throws IOException {
		message.start();
		String question = input.userInput.question();
		message.processing(question);
		String answer = chatGptService.getApiData(question);
		message.answer(answer);

	}
}
