package service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Repository.MemberRepo;
import Repository.MemoryMemberRepo;

@Configuration
public class SpringConfig {
    @Bean //빈을 등록하겠다는 의미
    public MemberService memberService () {
        return new MemberService(memberRepository());
    } //생성자 매개변수에 memberRepository가 필요하므로 아래에 또 빈으로 등록해줌

    @Bean
    public MemberRepo memberRepository() {
        return new MemoryMemberRepo();
        //인터페이스는 new가 안되기때문에 구현체로 new
    }
}