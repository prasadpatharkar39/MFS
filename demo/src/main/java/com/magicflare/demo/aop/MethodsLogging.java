package com.magicflare.demo.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class MethodsLogging {
    @Autowired
    private ObjectMapper mapper;


    @Pointcut(value = "execution(* com.magicflare.demo.*.*.*(..))")
    public void pointcut() {
    }



    @Around("pointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws  Throwable{
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName= pjp.getSignature().getName();
        String className= pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();

    log.info("    ---  method invoked  Classname =>  " + className + " ::  Method Name => " + methodName  );
        Object object = pjp.proceed();
        if(className!=null&&methodName!=null&&object !=null) {

            log.info(className + " ::" + methodName + " ()" + "Response ::" );
        }
        return object;
    }






}
