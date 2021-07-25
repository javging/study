package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"user", "item"}) // 롬복 사용하면 ToString 메소드를 자동으로 만들어주는데, 여기서 만든 user, item 변수에서도 만들어지고, 원래 있던 User 객체와 Item 객체에도 만들어져서 서로 상호참조 계속 하면서 StackOverFlow 에러 나옴... 자바 진짜 구린듯,,, 이런 설계를 이렇게 익셉션 추가해서,,, 그것도 스트링으로... 사용할 수 밖에 없다는거는... 이걸 좀 더 깔끔하게 해결하려면 너무 많은걸 뒤집어 엎어야 하니까 그런거겠지... 적폐가 너무 쌓여있는 언어같은데... 왜쓰지??? 진짜 왜 쓰지????
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderAt;

    // 오더 디테일의 입장에서,, N(자기자신):1(유저)
    @ManyToOne
    // private Long userId;
    private User user; // 하이버네잇 사용할 때 db에 있는 user_id 컬럼을 직접 연결시키는게 아니라 객체를 그대로 사용하면 알아서 user_id 찾아가게 된다고,,,


    // N:1
    @ManyToOne
    // private Long itemId;
    private Item item;
}
