package com.cyquen.jwt.controller;

import com.cyquen.jwt.entity.User;
import com.cyquen.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    static List<User> userList = new ArrayList<>(2);

    static {
        User user1 = new User(1, "cyquen", "123456");
        userList.add(user1);
        User user2 = new User(2, "xikun", "123456");
        userList.add(user2);
    }

    @PostMapping("/login")
    public String login(User user) {
        for (User dbUser : userList) {
            if (dbUser.getUsername().equals(user.getUsername()) && dbUser.getPassword().equals(user.getPassword())) {
                return JwtUtil.createToken(dbUser);
            }
        }
        return "";
    }
}
