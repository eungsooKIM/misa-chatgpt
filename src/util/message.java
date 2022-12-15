package util;

public class message {
	public static void start(){
		System.out.println("+반갑습니다 질문할 내용을 입력해주세요+");
	}
	public static void processing(String question){
		System.out.println(question+"에 대한 답변을 준비중입니다. 잠시만 기다려주세요");
	}
	public static void answer(String answer){
		System.out.println(answer);
	}

}
