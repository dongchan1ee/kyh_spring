package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.cleanStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("이동찬");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member); //alt+enter치면 된다.

    }

    @Test
    public void findByName() {
        Member member= new Member();
        member.setName("이동찬");
        repository.save(member);

        Member member2= new Member(); //shift+f6
        member2.setName("마경환");
        repository.save(member2);

        Member result = repository.findByName("이동찬").get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll() {
        Member member=new Member();
        member.setName("이동찬");
        repository.save(member);

        Member member2=new Member();
        member2.setName("이동찬");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
