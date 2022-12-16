package com.wry.usercenter;

import com.wry.usercenter.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class UserCenterApplicationTests {

    @Resource
    private UserService userService;
    @Test
    void testDigest() throws NoSuchAlgorithmException {
        String newPassword= DigestUtils.md5DigestAsHex(("abcd" + "mypassword").getBytes());
        System.out.println(newPassword);
    }


    @Test
    void contextLoads() {
        String userAccount="wry2001";
        String userPassword="";
        String checkPassword="123456";
        String plantCode="1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,plantCode);
        Assertions.assertEquals(-1,result);

        userAccount="li";
        result= userService.userRegister(userAccount,userPassword,checkPassword,plantCode);
        Assertions.assertEquals(-1,result);

        userAccount="wry2002";
        userPassword="123456";
        result=userService.userRegister(userAccount,userPassword,checkPassword,plantCode);
        Assertions.assertEquals(-1,result);

        userAccount="wr&&%";
        result=userService.userRegister(userAccount,userPassword,checkPassword,plantCode);
        Assertions.assertEquals(-1,result);

        userPassword="12345678";
        checkPassword="123456789";
        result=userService.userRegister(userAccount,userPassword,checkPassword,plantCode);
        Assertions.assertEquals(-1,result);

        userAccount="wry2002";
        checkPassword="12345678";
        result=userService.userRegister(userAccount,userPassword,checkPassword,plantCode);
        Assertions.assertEquals(-1,result);

        userAccount="wry2001";
        result=userService.userRegister(userAccount,userPassword,checkPassword,plantCode);
        Assertions.assertTrue(result>0);

    }

}
