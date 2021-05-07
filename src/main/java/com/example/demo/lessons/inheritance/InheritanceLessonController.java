package com.example.demo.lessons.inheritance;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Getter
@Setter
@RequestMapping("/ap-lessons")
public class InheritanceLessonController {
    /* Enums for declarative type and constructor type */
    public enum DeclarativeType {Employee, Teacher, Administrator, CompScienceInstructor, Principal}
    public static DeclarativeType declarativeMasterKey = DeclarativeType.Employee;

    private DeclarativeType declarativeKey;

    public enum ConstructorType {Employee, Teacher, Administrator, CompScienceInstructor, Principal}
    public static ConstructorType constructorMasterKey = ConstructorType.Employee;

    private ConstructorType constructorKey;

    public enum MethodType {rootMethod, getInfo, displayOccupation, getSubject, getScope, getBinaryCode, getSlogan}
    public static MethodType methodMasterKey;

    private MethodType methodKey;

    @GetMapping("/inheritance-mixed-type-demo")
    public String defaultView(Model model) {

        this.declarativeKey = DeclarativeType.Employee;
        this.constructorKey = ConstructorType.Employee;

        this.methodKey = MethodType.rootMethod;

        model.addAttribute("allInheritanceData", this);
        return "lessons/michaelMixedTypes";
    }
}
