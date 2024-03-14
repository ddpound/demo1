package org.demo.demo1.demouser.repository;

import org.demo.demo1.demouser.model.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoUserRepository extends JpaRepository<DemoUser, Integer> {

    DemoUser findDemoUserByName(String username);
}
