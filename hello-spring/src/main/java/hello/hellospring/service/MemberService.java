package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    
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
    public List<Mebmer> findMembers(Member member) {
        return memberRepository.findAll();
    }

}
