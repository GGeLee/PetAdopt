package com.pet.demo;

import com.pet.demo.entity.User;
import com.pet.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUserAccount("mm");
        user.setUserPassword("mm");
        user.setUserName("mm");
        user.setUserAge("mm");
        user.setUserSex("nan");
        user.setUserTelephone("12");
        user.setUserAddress("12");
        user.setUserState("1");
        user.setUserId("f58ebbd5-e692-4f6f-8f26-e68050f992d1");
        userService.update(user);
    }

}
