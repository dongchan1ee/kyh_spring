package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//ctrl+shift+t를 누르면 새 테스트를 생성

@SpringBootTest
@Transactional
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @Test
    @Commit
    void 회원가입() {
        Member member = new Member();
        member.setName("이동찬");

        Long joinId = memberService.join(member);
        Member findMember = memberService.findOne(joinId).get();

        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void 중복_회원가입() {
        Member member1 = new Member();
        member1.setName("이동찬");

        Member member2 = new Member();
        member2.setName("이동찬");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}