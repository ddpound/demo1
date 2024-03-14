package org.demo.demo1.demouser.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.demouser.model.DemoUser;
import org.demo.demo1.demouser.service.DemoUserCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "user")
@RestController
public class UserCrudController {

    private final DemoUserCrudService demoUserCrudService;

    @PostMapping(value = "save")
    public ResponseEntity<String> saveDemoUser(@RequestBody DemoUser demoUser){

        return demoUserCrudService.saveUser(demoUser) != null ? new ResponseEntity<>("success save user", HttpStatus.OK) : new ResponseEntity<>("success save user", HttpStatus.BAD_REQUEST);
    }

}
