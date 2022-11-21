package hello.hellospirng.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeTracceAop {
    // 공통관심사 타겟팅 (해당 패키지에 다 적용)
    @Around("execution(* hello.hellospirng..*(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		
		System.out.println("Start : " + joinPoint.toString());
		
		try {
			return joinPoint.proceed();
		} finally {
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			
			System.out.println("END : "+joinPoint.toString() + " " + timeMs + "ms");
		}
	}
}
