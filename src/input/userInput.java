package input;

import java.util.Scanner;

public class userInput {
	public static String question(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}

}
