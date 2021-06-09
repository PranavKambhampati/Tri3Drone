package com.example.demo.Security;


import com.example.demo.mysql.models.User;
import com.example.demo.mysql.models.UserSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class PrincipalUserService {
    @Autowired
    private UserSQL repository;
    Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();;

    public Long getUserID() {
        String currentUsername;
        if (currentUser instanceof UserDetails) {
            currentUsername = ((UserDetails)currentUser).getUsername();
        } else {
            currentUsername = currentUser.toString();
        }

        List<User> userCredentialsDB = repository.listAll();

        for (User user : userCredentialsDB) {
            if (user.getUsername() == currentUsername) {
                return user.getId();
            }
        }
        return Long.valueOf(-1);
    }

}
