package com.example.demo.lessons.inhertiance;

import com.example.demo.Labs.michael.trackModel.Distance;
import lombok.Getter;
import lombok.Setter;
import org.dom4j.dtd.Decl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Getter
@Setter
@RequestMapping("/ap-lessons")
public class InheritanceController {
    /* Enums for declarative type and constructor type */
    public enum DeclarativeType {Employee, Teacher, Administrator, CompScienceInstructor, Principal}
    public static DeclarativeType declarationKey = DeclarativeType.Employee;

    public enum ConstructorType {Employee, Teacher, Administrator, CompScienceInstructor, Principal}
    public static ConstructorType constructorKey = ConstructorType.Employee;

    @GetMapping("/inheritance-mixed-type-demo")
    public String defaultView(Model model) {

        model.addAttribute("allInheritanceData", this);
        return "lessons/michaelMixedTypes";
    }
}
