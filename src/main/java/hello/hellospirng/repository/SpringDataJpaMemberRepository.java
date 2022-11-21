package hello.hellospirng.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospirng.domain.Member;

//인터페이스 다중상속
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
	
	@Override
	Optional<Member> findByName(String name);
}
