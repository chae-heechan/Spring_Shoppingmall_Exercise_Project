package chae.Spring_Shoppingmall_Exercise_Project.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Goods {

    @Id
    @GeneratedValue
    @Column( name = "goods_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private int price;
}
