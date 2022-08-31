package chae.Spring_Shoppingmall_Exercise_Project.service;

import chae.Spring_Shoppingmall_Exercise_Project.domain.Member;
import chae.Spring_Shoppingmall_Exercise_Project.dto.JoinRequestDto;
import chae.Spring_Shoppingmall_Exercise_Project.dto.LogInRequestDto;
import chae.Spring_Shoppingmall_Exercise_Project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(JoinRequestDto joinRequestDto){
        validate(joinRequestDto);
        Member member = new Member(joinRequestDto.getNickName(), joinRequestDto.getPassword());
        memberRepository.save(member);

        return member.getId();
    }

    public Long logIn(LogInRequestDto logInRequestDto){
        Member member = memberRepository.findByNickName(logInRequestDto.getNickName());
        validateNickname(member);
        validatePassword(member.getPassword(), logInRequestDto.getPassword());

        return member.getId();
    }

    private void validateNickname(Member member) {
        if (member != null) {    // 닉네임이 DB에 존재하지 않는 경우
            throw new IllegalStateException("존재하지 않는 닉네임 입니다.");
        }
    }

    private void validatePassword(String member_password, String input_password) {
        if (member_password != input_password){  // 비밀번호가 다를 경우
            throw new IllegalStateException("비밀번호가 다릅니다.");
        }
    }

    private void validate(JoinRequestDto joinRequestDto) {
        Member member = memberRepository.findByNickName(joinRequestDto.getNickName());
        if (member != null){    // 맴버가 디비에 있을 경우
            throw new IllegalStateException("존재하는 아이디 입니다.");
        }
    }
}
