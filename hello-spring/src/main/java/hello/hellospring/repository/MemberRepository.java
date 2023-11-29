package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원정보 저장
    Optional<Member> findById(Long id); //optional은 null safe한 코드임
    Optional<Member> findByName(String name);
    List<Member> findAll();
    
}
