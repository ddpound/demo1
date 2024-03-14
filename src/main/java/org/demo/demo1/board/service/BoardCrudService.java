package org.demo.demo1.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.board.model.Board;
import org.demo.demo1.board.repository.BoardRepository;
import org.demo.demo1.demouser.model.DemoUser;
import org.demo.demo1.demouser.repository.DemoUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class BoardCrudService {

    private final DemoUserRepository demoUserRepository;

    private final BoardRepository boardRepository;

    @Transactional(readOnly = false)
    public Integer saveBoard(Board board){
        DemoUser demoUser = demoUserRepository.findDemoUserByName(board.getDemoUser().getName());

        board.setDemoUser(demoUser); // user setting
        Integer saveBoardId = boardRepository.save(board).getBoardId();

        if(saveBoardId != null) return saveBoardId;
        else return null;
    }

    @Transactional(readOnly = false)
    public Integer modifyBoard(Board board){
        // 영속화
        Optional<Board> findBoard =  boardRepository.findById(board.getBoardId());

        if(findBoard.isEmpty()){
            return null;
        }

        // 더티체킹
        findBoard.get().setBoardTitle(board.getBoardTitle());
        findBoard.get().setContent(board.getContent());

        return 1;
    }

    @Transactional(readOnly = false)
    public Integer deleteBoard(Board board){
        boardRepository.delete(board);
        return 1;
    }
}
