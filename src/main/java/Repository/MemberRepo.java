package Repository;

import java.util.List;
import java.util.Optional;

import Domain.Member;

public interface MemberRepo {
	Member save(Member member);
	Optional<Member> findById(long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
	
}
