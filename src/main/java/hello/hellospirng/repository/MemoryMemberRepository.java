package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class MemoryMemberRepository implements MemberRepository{

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 8L;
	
	
	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //자바 람다식
    }

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}

	@Override
	public Optional<hello.hellospirng.domain.Member> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}

