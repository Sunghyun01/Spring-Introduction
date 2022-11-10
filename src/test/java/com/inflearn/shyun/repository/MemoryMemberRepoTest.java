package com.inflearn.shyun.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import Domain.Member;
import Repository.MemoryMemberRepo;


class MemoryMemberRepoTest {

	MemoryMemberRepo repository = new MemoryMemberRepo();
	
	/*
	테스트가 실행되는 순서가 보장되지 않기 때문이다. 모든 테스트는 순서와 의존적이지 않게 설계해야 한다.
	이를 해결하려면 하나의 테스트가 끝날 때마다 레포지토리를 지워줘야한다.
	따라서 @AfterEach 애노테이션을 사용하여 레포지토리를 clear해야한다.
	*/
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		Member res = repository.findById(member.getId()).get();
		System.out.println("res1 = " + (res == member));
		//Assertions.assertEquals(member, res);
		Assertions.assertThat(member).isEqualTo(res);
	}

	@Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
