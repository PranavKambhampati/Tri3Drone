package com.example.demo.Labs.michael.linkedListsModel;

import com.example.demo.Labs.michael.trackModel.Distance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodePtr {
    private Distance data;
    private NodePtr next;
}
