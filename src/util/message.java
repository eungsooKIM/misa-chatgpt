package util;

public class message {
	public static void start(){
		System.out.println("+반갑습니다 질문할 내용을 입력해주세요+");
	}
	public static void processing(String question){
		System.out.println('"'+question+'"'+"에 대한 답변을 준비중입니다. 잠시만 기다려주세요");
	}
	public static void answer(String answer){
		System.out.println("엔트로피는 세태와 에너지 변화의 정도를 나타내는 양이며, \n물리학에서는 에너지의 낭비나 불균일함을 나타내는 척도로 사용됩니다. 엔트로피는 일반적으로 정리된 상태에서 상태가 역전될 수 없다고 생각되며, \n엔트로피가 증가할 때 상태는 더 불균일해지고 역전되지 않을 것으로 예상됩니다.");
	}

}
