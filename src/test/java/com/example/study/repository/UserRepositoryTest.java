package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository; // = new UserRepository(); 직접 생성할 필요 없음. @Autowired 덕분에 알아서 만들어줌

    @Test
    public void create() {
        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        // 요런식으로하지않고,,
        User user = new User();
        // user.setId // 자동생성이라 안해줘도 됨,,
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}
