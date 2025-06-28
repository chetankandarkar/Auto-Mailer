package com.auto.mailer.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

	@Before("execution(* com.auto.mailer..*(..))")
	public void logBefore(JoinPoint joinpoint) {
		logger.info("➡️ Entering: {} with args = {}", joinpoint.getSignature(), joinpoint.getArgs());
	}

	@AfterReturning(pointcut = "execution (* com.auto.mailer..*(..))", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		logger.info("⬅️ Exiting: {} with parameters {} and result = {}", joinPoint.getSignature(), joinPoint.getArgs(),
				result);
	}

	@AfterThrowing(pointcut = "execution(* com.auto.mailer..*(..))", throwing = "exception")
	public void logException(JoinPoint joinPoint, Object exception) {
		logger.error("💥 Exception in: {} with parameters {} and exception = {}", joinPoint.getSignature(),
				joinPoint.getArgs(), exception);
	}

}
