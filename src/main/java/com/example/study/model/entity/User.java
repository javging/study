package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

// import javax.persistence.Column;
import javax.persistence.*;
// import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
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

  // 유저 입장에서
  // 1(유저):N(오더디테일)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // OrderDetail 안에 있는 user 라는 변수에 매칭시키겠다,,,
  private List<OrderDetail> orderDetailList;

}
