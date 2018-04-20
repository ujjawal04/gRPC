package com.example.httpserver.web;

import com.example.httpserver.model.User;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUserHttp(@RequestBody Map<String, Object> payload) {
        String name = payload.get("name").toString();
        int age = Integer.parseInt(payload.get("age").toString());

        new User(name, age);

        return "User created successfully.";
    }

    @RequestMapping(value = "/grpc", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createUserGrpc(@RequestBody Map<String, Object> payload) {
        String name = payload.get("name").toString();
        int age = Integer.parseInt(payload.get("age").toString());

        new User(name, age);

        return "User created successfully.";
    }
}
