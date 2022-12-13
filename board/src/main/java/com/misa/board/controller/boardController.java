package com.misa.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.misa.board.entity.Board;
import com.misa.board.service.BoardService;

@Controller
public class boardController {
	@Autowired
	private BoardService boardService;
	@GetMapping("/board/write")
	public String boardWriteForm() {
		return "boardWrite";
	}
	@PostMapping("/board/writepro")
	public String boardWritePro(Board board) {
		System.out.println("제목"+board.getTitle());
		boardService.write(board);
		return "";
	}
	@GetMapping("/board/list")
	public String boardList(Model model) {
		model.addAttribute("list", boardService.boardList());
		return "boardList";
	}
}
