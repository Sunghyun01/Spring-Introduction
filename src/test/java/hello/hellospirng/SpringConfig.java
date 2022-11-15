package hello.hellospirng;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospirng.repository.JDBCMemberRepository;
import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.service.MemberService;

@Configuration
public class SpringConfig {
	private DataSource dataSource;
	
	@Autowired
	public SpringConfig(DataSource dataSource) { 
		this.dataSource = dataSource;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new JDBCMemberRepository(dataSource);
	}
}
