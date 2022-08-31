package chae.Spring_Shoppingmall_Exercise_Project.repository;

import chae.Spring_Shoppingmall_Exercise_Project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByNickName(String nickName);
}
