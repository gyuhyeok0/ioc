package com.ohgiraffers.section03.javaconfig;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    
    /* 필기.
            ComponentScan 이란?
            base package 로 설정 된 하위 경로에 특정 어노테이션을 가지고 있는
            클래스를 bean 으로 등록해주는 기능이다.
            @Component 어노테이션이 작성 된 클래스를 인식하여 bean으로 등록해준다.
            목적에 따라서 세부 기능을 제공하는
            @Controller, @Service, @Repository, @configuration 등을 사용한다.
         */

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        MemberDAO memberDAO = context.getBean("dao", MemberDAO.class);

        System.out.println(memberDAO.findMemberBySequence(1));

        System.out.println(memberDAO.save(new MemberDTO(3,"user03", "pass03", "조평훈")));

        System.out.println(memberDAO.findMemberBySequence(3));
    }
}
