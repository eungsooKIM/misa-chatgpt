package com.misa.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misa.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
