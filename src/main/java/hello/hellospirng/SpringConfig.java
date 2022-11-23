package hello.hellospirng;

import hello.hellospirng.repository.*;
import hello.hellospirng.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import javax.persistence.EntityManager;
// import javax.sql.DataSource;

@Configuration
public class SpringConfig {

	//private final DataSource dataSource;
	//private EntityManager em;
	private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
       // this.dataSource = dataSource;
        //this.em = em;
    	this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
    	//return new MemberRepository();
    	//return new JDBCMemberRepository(dataSource);
    	//return new JDBCTemplateMemberRepository(dataSource);
//    	return new JpaMemberRepository(em);
//    }
}
