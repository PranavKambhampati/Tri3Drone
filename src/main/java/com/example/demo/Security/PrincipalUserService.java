package com.example.demo.Security;


import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.util.List;

public class PrincipalUserService {
    @Autowired
    private UserSQL repository;
    Object currentUser;

    public PrincipalUserService(UserSQL repository) { // UserSQL needs to be passed from class that is managed by Spring, @Autowired annotation will not be enough to manage it outside of a Spring class
        this.repository = repository;
         this.currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // grabs current user from Spring Security inMemoryDetails
    }


    public Long getUserID() {
        String currentUsername;
        if (currentUser instanceof UserDetails) {
            currentUsername = ((UserDetails)currentUser).getUsername();
        } else {
            currentUsername = currentUser.toString();
        }

        List<User> userCredentialsDB = repository.listAll();

        for (User user : userCredentialsDB) {
            if (user.getUsername().equals(currentUsername)) {
                return user.getId();
            }
        }
        return Long.valueOf(-1);
    }

}
