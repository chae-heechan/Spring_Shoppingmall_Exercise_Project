package chae.shop.shoppingmall.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LogInRequestDto {

    private String nickName;

    private String password;
}
