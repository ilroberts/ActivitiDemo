package com.ilroberts.main;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iwan roberts on 04/11/2016.
 */
@SpringBootApplication
public class ActivitiApp {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiApp.class, args);
    }

    @Bean
    CommandLineRunner init(final RepositoryService repositoryService,
                           final RuntimeService runtimeService,
                           final TaskService taskService) {

        return strings -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("applicantName", "John Doe");
            variables.put("email", "john.doe@activiti.com");
            variables.put("phoneNumber", "123456789");
            runtimeService.startProcessInstanceByKey("hireProcess", variables);
        };
    }

  /*  @Bean
    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

        return () -> {

            Group group = identityService.newGroup("user");
            group.setName("user");
            group.setType("security-role");
            identityService.saveGroup(group);

            User admin = identityService.newUser("admin");
            admin.setPassword("admin");
            identityService.saveUser(admin);

        };
    }*/

}
