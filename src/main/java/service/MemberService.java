package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Domain.Member;
import Repository.MemberRepo;
import Repository.MemoryMemberRepo;

public class MemberService {
	
	private final MemberRepo memberRepository;
	
	public MemberService(MemberRepo memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	//회원가입
	public long join(Member member) {
		//같은 이름이 있는 중복회원 X		
		validateDuplicateMember(member);
		
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		/*
		* result.get 으로 꺼내는 방식 권장 X
		* orElseGet 사용
		* Optional<Member> result = memberRepository.findByName(member.getName());
		*/
		memberRepository.findByName(member.getName())
		.ifPresent(m-> {
			throw new IllegalStateException("이미 존재하는 회원입니다");
		});
	}
	
	/*
	 * 전체 회원 조회
	 * */
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne (Long memberId){
		return memberRepository.findById(memberId);
	}
}
