package com.yedam.myserver.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //빈등록 aop-context.xml에서 하지 않아도 됨
@Aspect //aop:aspect와 같음
public class LogAdvice {
	@Pointcut("execution(* com.yedam..*Impl.*(..))")
	public void allpointcut() {}
	
	@Before("LogAdvice.allpointcut()")
	public void printLog(JoinPoint jp) {
		String name = jp.getSignature().getName();
		String arg = jp.getArgs() != null && jp.getArgs().length > 0 ? jp.getArgs()[0].toString() : "";
		System.out.println("[before]로그 : " + name + " : " + arg );
	}
}
