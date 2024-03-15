package org.demo.demo1.demouser.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.demouser.model.DemoUser;
import org.demo.demo1.demouser.repository.DemoUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Log4j2
@Service
public class DemoUserSelectService {

    private final DemoUserRepository demoUserRepository;

    @Transactional(readOnly = true)
    public DemoUser findUserByUserName(DemoUser demoUser){
        return demoUserRepository.findDemoUserByName(demoUser.getName());
    }

    @Transactional(readOnly = true)
    public DemoUser tryUserLogin(DemoUser demoUser){
        DemoUser findDemoUser = findUserByUserName(demoUser);

        // 간단한 비밀번호가 같은지 로그인
        if(findDemoUser.getPassword().equals(demoUser.getPassword())){
            return demoUserRepository.findDemoUserByName(demoUser.getName());
        }else{
            return null;
        }

    }
}
