package com.misa.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misa.board.entity.Board;
import com.misa.board.repository.BoardRepository;

@Service
public class BoardService 	{
	@Autowired
	private BoardRepository boardRepository;
	public void write(Board board) {
		boardRepository.save(board);
	}

	public List<Board> boardList() {
		return boardRepository.findAll();
	}
}
