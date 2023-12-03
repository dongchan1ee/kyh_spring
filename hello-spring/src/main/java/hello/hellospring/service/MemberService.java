package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional //JPA는 Transactional이 있어야 한다.
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) { //DI
        this.memberRepository = memberRepository;
    }

    /*
        회원가입
         */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { //ctrl+alt+m 을 누르면 Method를 생성해 준다.
        //같은 이름이 있는 중복 회원 x alt+enter
        memberRepository.findByName(member.getName()).ifPresent(m -> { //return이 Optional이기에 바로 ifPresent사용가능
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
    }

    /*
    전체 회원조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }



}
