package com.example.demo.Labs.PranavInheritence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Generals {
    public final String masterType = "General";
    private String type;

    public abstract String toString();
}
