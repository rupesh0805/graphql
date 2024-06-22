package com.project.graphql.controller;

import com.project.graphql.entities.User;
import com.project.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //create user
    @MutationMapping(name = "createUser")
    //@SchemaMapping(typeName = "Mutation", field = "createUser")
    public User createUser(@Argument String name,@Argument String phone, @Argument String email, @Argument String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        return userService.createUser(user);
    }

    //get User
    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    //get Single User
    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUser(userId);
    }

    //deleteUser
    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }


}
