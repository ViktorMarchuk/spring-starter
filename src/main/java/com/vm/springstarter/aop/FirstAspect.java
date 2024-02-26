package com.vm.springstarter.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class FirstAspect {
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {
    }

    @Pointcut("within(com.vm.springstarter.service.*Service)")
    public void isServiceLayer() {

    }

    //    @Pointcut("this(org.springframework.stereotype.Repository)")
    @Pointcut("target(org.springframework.stereotype.Repository)")
    public void isRepositoryLayer() {

    }

    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {

    }

    @Pointcut("isControllerLayer() && args(org.springframework.ui.Model,..)")
    public void hasModelArg() {

    }

    @Pointcut("isControllerLayer() && @args(com.vm.springstarter.validator.UserInfo,..)")
    public void hasInfoParamAnnotation() {

    }

    @Pointcut("bean(userService)")
    public void isUserServiceBean() {

    }

    @Pointcut("bean(*Service)")
    public void isServiceLayerBean() {
      log.info("AOP");

    }

    @Pointcut("execution(public * com.vm.springstarter.service.*Service.findById(*))")
    public void anyServiceByIdMethod() {

    }

    @Pointcut("execution(public * findById(*))")
    public void anyFindByIdMethod() {

    }


    @Before("anyServiceByIdMethod() && args(id) && target(service) && this(serviceProxy)")
    public void addLogging(JoinPoint joinPoint,
                           Object id,
                           Object service,
                           Object serviceProxy) {
        log.info("Before invoke findByIdMethod in class {}, with ID {}, proxy {}",
                service, id, serviceProxy);
    }

}