package com.example.reactdemo.login.controller;
import com.example.reactdemo.login.model.Login;
import com.example.reactdemo.login.model.User;
import com.example.reactdemo.login.repository.UserRepository;
import com.example.reactdemo.login.model.Login;
import com.example.reactdemo.login.model.User;
import com.example.reactdemo.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/checkLogin")
    public Map<String,Object> checkLogin(@RequestBody Login login){

        User user = userRepository.findByUserNameAndPassword
                (login.getEmail(), login.getPassword());
        Map<String,Object> map =new HashMap<>();
        System.out.println(user);

        //user found
        if (user !=null){
            map.put("message","Success");
            map.put("status",200);
            return map;
        }
        //user not found
        map.put("message","Failed");

        return map;
    }
}

