package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

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
        user.setAccount("TestUser02");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findById(4L);

        user.ifPresent(selectedUser -> {
//            System.out.println("user: "+selectedUser);
//            System.out.println("email: "+selectedUser.getEmail());
            selectedUser.getOrderDetailList().stream().forEach(orderDetail -> {
//                System.out.println(orderDetail.getItemId());
                System.out.println(orderDetail.getItem());
            });
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectedUser -> {
            selectedUser.setAccount("pppp");
            selectedUser.setUpdatedAt(LocalDateTime.now());
            selectedUser.setUpdatedBy("update method");
            
            userRepository.save(selectedUser);
            // id 값으로 row 찾아서 업데이트 함
        });
    }

    @Test
    @Transactional // 테스트 하고 다시 롤백시킴
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent()); // True

        user.ifPresent(selectedUser -> {
            userRepository.delete(selectedUser);
        });

        Optional<User> deletedUser = userRepository.findById(3L);

//        if(deletedUser.isPresent()) {
//            System.out.println("데이터 존재: "+deletedUser);
//        } else {
//            System.out.println("데이터 없음. 삭제됨. ");
//        }
        Assertions.assertFalse(deletedUser.isPresent()); // false

    }
}
