package com.misa.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		System.out.println("hello word");
		SpringApplication.run(BoardApplication.class, args);
	}

}
