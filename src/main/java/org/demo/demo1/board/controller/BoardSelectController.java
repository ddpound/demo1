package org.demo.demo1.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.board.model.Board;
import org.demo.demo1.demouser.model.DemoUser;
import org.demo.demo1.board.service.BoardSelectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RequestMapping(value = "board-select")
@RestController
public class BoardSelectController {

    private final BoardSelectService boardSelectService;

    @GetMapping(value = "all-list")
    public List<Board> findAllBoard(){
        return boardSelectService.findAllList();
    }

    @GetMapping(value = "boar-id")
    public Board findbyBoardId(Board board){
        return boardSelectService.findByBoardId(board);
    }

    @GetMapping(value = "user")
    public List<Board> findBoardListbyUser(DemoUser demoUser){
        return boardSelectService.findBoardListByUser(demoUser);
    }

}
