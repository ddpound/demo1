package org.demo.demo1.condition.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ConditionController {


    @GetMapping(value = "check-condition")
    public String checkCondition(){
        return "condition check";
    }

}

