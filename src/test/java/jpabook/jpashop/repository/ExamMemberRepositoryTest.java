package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ExamMemberRepositoryTest {

    @Autowired
    ExamMemberRepository examMemberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {

        //Given
        Member member = new Member();
        member.setName("memberA");

        //When
        Long saveId = examMemberRepository.save(member);

        //Then
        Member findMember = examMemberRepository.find(saveId).get();

        assertThat(findMember.getId()).isEqualTo(member.getId());

        assertThat(findMember.getName()).isEqualTo(member.getName());

        assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
    }
}