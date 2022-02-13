package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    // @Rollback(value = false)  기DB에서 확인하는 방법
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("member1");

        Long saveId = memberService.join(member);

        em.flush();
        Member findMember = memberRepository.findOne(saveId);
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        Assertions.assertThat(member.getAddress()).isEqualTo(findMember.getAddress());
        Assertions.assertThat(member.getDelivery()).isEqualTo(findMember.getDelivery());
        Assertions.assertThat(member.getOrders()).isEqualTo(findMember.getOrders());
    }

    @Test
    public void 중복_회원_예외()throws Exception{
        Member member1 = new Member();
        member1.setName("member");

        Member member2 = new Member();
        member2.setName("member");

        memberService.join(member1);
        assertThrows(IllegalStateException.class,()-> {
            memberService.join(member2);
                });//  예외 발생
    }

    @Test
    void 회원출력(){
        Member member = new Member();
        member.setName("member1");

        Long saveId = memberService.join(member);
        em.flush();

        List<Member> members = memberService.findMembers();
        for(Member m : members){
            Assertions.assertThat(m.getName()).isEqualTo("member1");
        }
    }
}