package com.example.demo.mysql.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SurveyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;
    @OneToOne
    private User adminOwner;
    @ManyToOne
    private User members;

    public SurveyGroup(String groupName, User adminOwner, User members) {
        this.groupName = groupName;
        this.adminOwner = adminOwner;
        this.members = members;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", adminOwner=" + adminOwner +
                ", members=" + members +
                '}';
    }
}
