package com.vm.annotation;

import com.vm.integretion.TestApplicationRunner;
import com.vm.springstarter.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("test")
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@TestPropertySource(locations = "classpath:spring.properties")
@Transactional
@WithMockUser(username = "Test",password = "122",authorities = {"ADMIN","USER"})
public @interface IT {
}
