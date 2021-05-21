package com.example.demo.sqlite.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    UserSqlRepository userService;
    @Autowired
    public UserController(UserSqlRepository userService) {
        this.userService = userService;
    }
    @GetMapping(value="/students")
    public List<User> getAllStudents(){
        return userService.listAll();
    }
    @GetMapping(value="/students/{id}")
    public User getStudentById(@PathVariable("id") @Min(1) int id) {
        User std = userService.findById(id)
                .orElseThrow(()->new UserNotFoundException("Student with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/students")
    public User addStudent(@Valid @RequestBody User std) {
        return userService.save(std);
    }
    @PutMapping(value="/students/{id}")
    public User updateUser(@PathVariable("id") @Min(1) int id, @Valid @RequestBody User newstd) {
        User stdu = userService.findById(id)
                .orElseThrow(()->new UserNotFoundException("Student with " + id + " is Not Found!"));
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setEmail(newstd.getEmail());
        return userService.save(stdu);
    }
    @DeleteMapping(value="/students/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) int id) {
        User std = userService.findById(id)
                .orElseThrow(()->new UserNotFoundException("Student with " + id + " is Not Found!"));
        userService.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}
