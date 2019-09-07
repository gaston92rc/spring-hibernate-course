package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        System.out.println("\n========>>> Executing @After (finally) on method: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
                    throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){
        System.out.println("\n========>>> Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());

        System.out.println("\n========>>> The exception is:  " + theExc);
    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        System.out.println("\n========>>> Executing @AfterReturning on method: "+joinPoint.getSignature().toShortString());
        System.out.println("\n========>>> result is: "+result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n========>>> result is: "+result);

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n======>>> Executing @Before advice on method");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            System.out.println(arg);

            if(arg instanceof Account){
                Account account = (Account) arg;
                System.out.println("account name: "+account.getName());
                System.out.println("account level: "+account.getLevel());
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
