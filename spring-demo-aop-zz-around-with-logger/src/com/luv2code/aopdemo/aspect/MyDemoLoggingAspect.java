package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
import com.luv2code.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around(("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))"))
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        logger.info("\n========>>> Executing @Around on method: "+proceedingJoinPoint.getSignature());

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        logger.info("\n========>>> Duration: " + (end-begin)/1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        logger.info("\n========>>> Executing @After (finally) on method: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
                    throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){
        logger.info("\n========>>> Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());

        logger.info("\n========>>> The exception is:  " + theExc);
    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        logger.info("\n========>>> Executing @AfterReturning on method: "+joinPoint.getSignature().toShortString());
        logger.info("\n========>>> result is: "+result);

        convertAccountNamesToUpperCase(result);

        logger.info("\n========>>> result is: "+result);

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n======>>> Executing @Before advice on method");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            logger.info(arg.toString());

            if(arg instanceof Account){
                Account account = (Account) arg;
                logger.info("account name: "+account.getName());
                logger.info("account level: "+account.getLevel());
            }

        }
    }

    private void convertAccountNamesToUpperCase(List<Account> result){
        if(!result.isEmpty()) {
            for (Account account : result) {
                account.setName(account.getName().toUpperCase());
            }
        }
    }

}
