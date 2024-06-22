package com.project.graphql.service;

import com.project.graphql.entities.User;
import com.project.graphql.helper.ExceptionHelper;
import com.project.graphql.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    //creating user
    public User createUser(User user){
        return this.userRepo.save(user);
    }

    //getting all user
    public List<User> findAllUsers(){
        return this.userRepo.findAll();
    }

    //getting single user
    public User getUser(int userId){
        return this.userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    //updating user
    public User updateUser(User user){
        User userDetail = getUser(user.getUserId());
        return userRepo.save(user);
    }

    //deleting user
    public boolean deleteUser(int userId){
        User user = getUser(userId);
        userRepo.delete(user);
        return true;
    }
}
