package org.demo.demo1.demouser.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.demouser.model.DemoUser;
import org.demo.demo1.demouser.repository.DemoUserRepository;
import org.demo.demo1.demouser.service.DemoUserSelectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "user")
@RestController
public class UserSelectController {

    private final DemoUserSelectService demoUserSelectService;

    /**
     * 로그인 및 로그인 정보를 전달
     *
     * */
    @PostMapping("login")
    public ResponseEntity<DemoUser> loginUser(@RequestBody DemoUser inputDemoUser){
        DemoUser resultDemoUser = demoUserSelectService.findUserByUserName(inputDemoUser);

        if(resultDemoUser != null ){
            resultDemoUser.setPassword("");
            log.info("로그인 성공 , 로그인 아이디 : " + resultDemoUser.getName());
            return new ResponseEntity<>(resultDemoUser , HttpStatus.OK);
        }

        // 빈 값을 보낸다.
        return new ResponseEntity<>(new DemoUser(), HttpStatus.BAD_REQUEST);
    }

}
