package chae.shop.shoppingmall.repository;

import chae.shop.shoppingmall.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByNickName(String nickName);
}
