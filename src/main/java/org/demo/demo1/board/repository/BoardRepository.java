package org.demo.demo1.board.repository;

import org.demo.demo1.board.model.Board;
import org.demo.demo1.demouser.model.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Integer> {

    List<Board> findBoardByDemoUser(DemoUser demoUser);
}
