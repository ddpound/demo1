package org.demo.demo1.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.board.model.Board;
import org.demo.demo1.board.service.BoardCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "board")
@RestController
public class BoardCrudController {

    private final BoardCrudService boardCrudService;

    @PostMapping(value = "save")
    public ResponseEntity<String> boardSave(@RequestBody Board board){
        return  boardCrudService.saveBoard(board) != null ? new ResponseEntity<>("success save board", HttpStatus.OK)
                : new ResponseEntity<>("success save board", HttpStatus.BAD_REQUEST) ;
    }

}

