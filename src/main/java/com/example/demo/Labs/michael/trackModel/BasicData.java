package com.example.demo.Labs.michael.trackModel;

import lombok.Getter;
import lombok.Setter;

/*
    Root class to all children
 */

@Getter
@Setter
public abstract class BasicData {
    public final String masterType = "Basic";
    private String type;

    public abstract String toString();
}
