package example.spring.aop.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* example.spring.aop.concert.Performance.perform(..))")
    public void perform() {

    }

    @Around("perform()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }

//    @Before("perform()")
//    public void silenceCellPhones() {
//        System.out.println("Silencing cell phones");
//    }
//
//    @Before("perform()")
//    public void takeSeats() {
//        System.out.println("Taking seats");
//    }
//
//    @AfterReturning("perform()")
//    public void applause() {
//        System.out.println("CLAP CLAP CLAP!!!");
//    }
//
//    @AfterThrowing("perform()")
//    public void demandRefund() {
//        System.out.println("Demanding a refund");
//    }

}
