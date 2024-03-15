package org.demo.demo1.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.board.model.Board;
import org.demo.demo1.board.service.BoardCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "board")
@RestController
public class BoardCrudController {

    private final BoardCrudService boardCrudService;

    @PostMapping(value = "save")
    public ResponseEntity<String> boardSave(@RequestBody Board board){
        return  boardCrudService.saveBoard(board) != null ? new ResponseEntity<>("success save board", HttpStatus.OK)
                : new ResponseEntity<>("success save board", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "modify")
    public ResponseEntity<String> boardModify(@RequestBody Board board){
        return  boardCrudService.modifyBoard(board) == 1 ? new ResponseEntity<>("success modify board", HttpStatus.OK)
                : new ResponseEntity<>("fail modify board", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity<String> boardDelete(@RequestBody Board board){
        return  boardCrudService.deleteBoard(board) == 1 ? new ResponseEntity<>("success delete board", HttpStatus.OK)
                : new ResponseEntity<>("fail delete board", HttpStatus.BAD_REQUEST);
    }

}

