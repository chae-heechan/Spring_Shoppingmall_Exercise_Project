package chae.shop.shoppingmall.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    public Member(String nickName, String password){
        this.nickName = nickName;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Column( name = "member_id")
    private Long id;

    private String nickName;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<Goods> goodsList = new ArrayList<>();


}
