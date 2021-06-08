package com.example.demo.mysql.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;


@Entity(name = "User") // explicit entity name (can be different than class name)
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    //@Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    private String role;
    @OneToMany(mappedBy = "members")
    private List<SurveyGroup> surveyGroups;
    /* Constructor without @OneToMany values */
    public User(String firstName, String lastName, String username, String password, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    /* Constructor with @OneToMany values */
    public User(String firstName, String lastName, String username, String password, String email, String role, List<SurveyGroup> surveyGroups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.surveyGroups = surveyGroups;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", groups=" + surveyGroups +
                '}';
    }
}
