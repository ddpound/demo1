package org.demo.demo1.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.board.model.Board;
import org.demo.demo1.demouser.model.DemoUser;
import org.demo.demo1.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class BoardSelectService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> findAllList(){
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Board findByBoardId(Board board){
        return boardRepository.findById(board.getBoardId()).isPresent() ? boardRepository.findById(board.getBoardId()).get() : null;
    }

    @Transactional(readOnly = true)
    public List<Board> findBoardListByUser(DemoUser demoUser){
        return !boardRepository.findBoardByDemoUser(demoUser).isEmpty() ? boardRepository.findBoardByDemoUser(demoUser) : null;
    }
}
