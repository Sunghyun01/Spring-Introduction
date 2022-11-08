package com.inflearn.shyun.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Domain.Member;
import Repository.MemberRepo;
import Repository.MemoryMemberRepo;
import service.MemberService;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepo repository = new MemoryMemberRepo();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@BeforeEach
	public void beforeEach() {
		repository = new MemoryMemberRepo();
		memberService = new MemberService(repository);
	}
	
	@Test
	void 회원가입() {
		// given :: 주어진 조건
        Member member = new Member();
        member.setName("spring1");
        // when :: 검증할 것
        long saveId = memberService.join(member);
        // then :: 어떻게 되는지
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void 중복회원예외() {
		// given :: 주어진 조건
        Member member1 = new Member();
        member1.setName("test");
        
        Member member2 = new Member();
        member2.setName("test");
        
        // when :: 검증할 것
        memberService.join(member1);
        
        // IllegalStateException 이 나와야 성공
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        
/*
        try {
        	memberService.join(member2);
        	fail("테스트 예외가 발생해야 합니다!");
		} catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
		}
*/      
        
        // then :: 어떻게 되는지
        
	}
}
