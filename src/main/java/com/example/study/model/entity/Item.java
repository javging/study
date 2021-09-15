package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;

    // 1:N
    // LAZY = 지연로딩, EAGER = 즉시로딩

    // LAZY -> select * from item where id = ?

    // EAGER -> 1:1 에서만 기본적으로 사용하라,,,
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    // 연관관계 설정된 모든 테이블에 대해서 조인 후 데이터를 가져옴
    // 데이터가 많은 테이블에 대해서 EAGER로 걸려있으면 성능저하, 데이터 많아서 못가져오는 경우 등이 생길 수 있음
    // 1:N 같이 여러가지 데이터 로딩이 일어날 수 있는 경우에는 반드시 LAZY 로 걸어줘야 함.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
