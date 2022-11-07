package com.inflearn.shyun.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import Domain.Member;
import Repository.MemoryMemberRepo;

class MemoryMemberRepoTest {

	MemoryMemberRepo repo = new MemoryMemberRepo();
	
	@Test
	void testSave() {
		Member member = new Member();
		member.setName("spring");
		
		repo.save(member);
		Member res = repo.findById(member.getId()).get();
		System.out.println("res = " + (res == member));
		//Assertions.assertEquals(member, res);
		Assertions.assertThat(member).isEqualTo(res);
	}

}
