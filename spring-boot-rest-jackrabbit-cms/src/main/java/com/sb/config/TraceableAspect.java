package com.sb.config;

import java.util.concurrent.atomic.AtomicLong;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TraceableAspect {

	private final static AtomicLong Count = new AtomicLong(0);

    @Around("execution(* *(..)) && @annotation(com.sb.config.Traceable)")
    public Object aroundTraceableMethod(ProceedingJoinPoint pjp) throws Throwable {

        Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
        if (logger.isTraceEnabled()) {
            return executeWithTrace(pjp, logger, Count.incrementAndGet());
        }

        return pjp.proceed();
    }

    private Object executeWithTrace(ProceedingJoinPoint pjp, Logger logger, long id) throws Throwable {

        long start = System.currentTimeMillis();
        try {
            logger.trace(String.format("#### - #%d - Starting execution of method '%s'", id, pjp.toShortString()));
            return pjp.proceed();
        } catch (Throwable throwable) {
            logger.error(String.format("#### - #%d - Error while executing method '%s' : %s", id, pjp.toShortString(), throwable.toString()));
            throw throwable;
        } finally {
            if (logger.isTraceEnabled()) {
                logger.trace(String.format("#### - #%d - End of method '%s' (duration %s ms)", id, pjp.toShortString(), (System.currentTimeMillis() - start)));
            }
        }
    }    
}
