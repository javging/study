package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.Table;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
// @Table(name="user") 이름 똑같을 경우에는 굳이 안써줘도 됨. JPA가 알아서 매핑해준다고 함.
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String account;
  private String email;
  // @Column(name="phone_number") 마찬가지로 이름 같은경우, JPA가 알아서 매칭시켜줌.
  // camel <-> snake 가능,,
  private String phoneNumber;
  private LocalDateTime createdAt;
  private String createdBy;
  private LocalDateTime updatedAt;
  private String updatedBy;
}
