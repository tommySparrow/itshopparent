package com.it.logs;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：日志切面
 * @ throws
 */
@Slf4j
@Aspect
@Component
public class LogAspectServiceApi {

    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.it.service.*.*(..))") //com.it.service 接口所在位置
    private void controllerAspect() {
    }

    // 请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("请求内容==============================>");
        try {
            // 打印请求内容
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
        }
        log.info("<==============================请求内容");
    }

    // 在方法执行完结后打印返回内容
    @AfterReturning(returning = "obj", pointcut = "controllerAspect()")
    public void methodAfterReturning(Object obj) {
        log.info("返回内容------------------------------>");
        try {
            log.info("Response内容:" + JSON.toJSONString(obj));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodAfterReturning() ### ERROR:", e);
        }
        log.info("<------------------------------返回内容");
    }
}
