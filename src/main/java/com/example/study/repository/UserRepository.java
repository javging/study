package com.example.study.repository;

import com.example.study.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where account = ? << test03, test04 ... account 로 검색
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    // select * from user where account = ? and email = ? << account, email 로 검색
    // 변수명, 컬럼명을 꼭 맞추지 않아도 되지만,, 순서대로 매칭됨. 하지만 맞춰주는것 추천함.
    Optional<User> findByAccountAndEmail(String account, String email);

}
