package com.example.demo.Labs.NakulInheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MasterClass {
    public final String masterType = "Master";
    private String type;

    public abstract String toString();
}
