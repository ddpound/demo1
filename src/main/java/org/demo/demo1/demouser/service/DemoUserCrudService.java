package org.demo.demo1.demouser.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.demo.demo1.demouser.model.DemoUser;
import org.demo.demo1.demouser.repository.DemoUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class DemoUserCrudService {

    private final DemoUserRepository demoUserRepository;

    public Integer saveUser(DemoUser demoUser){
        return demoUserRepository.save(demoUser).getId();
    }


}
