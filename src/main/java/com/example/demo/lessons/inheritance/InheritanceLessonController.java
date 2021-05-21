package com.example.demo.lessons.inheritance;

import com.example.demo.Labs.michael.trackModel.Distance;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.groovy.runtime.MethodKey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.MemoryHandler;

@Controller
@Getter
@Setter
@RequestMapping("/ap-lessons")
public class InheritanceLessonController<T> {
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

    private T employee;
    private String formattedResult = "";
    private String displayInstantiation;


    @GetMapping("/inheritance-mixed-type-demo")
    public String defaultView(Model model) {

        this.declarativeKey = DeclarativeType.Employee;
        declarativeMasterKey = this.declarativeKey;

        this.constructorKey = ConstructorType.Employee;
        constructorMasterKey = this.constructorKey;

        this.methodKey = MethodType.rootMethod;
        methodMasterKey = this.methodKey;

        model.addAttribute("allInheritanceData", this);
        return "lessons/michaelMixedTypes";
    }

    @PostMapping("/inheritance-mixed-type-demo")
    public String userSelection(@RequestParam(value = "declarativeKey", required = false) DeclarativeType declarativeKey,
                                @RequestParam(value = "constructorKey", required = false) ConstructorType constructorKey,
                                @RequestParam(value = "methodKey", required = false) MethodType methodKey, Model model) {
        this.declarativeKey = declarativeKey;
        declarativeMasterKey = this.declarativeKey;
        this.constructorKey = constructorKey;
        constructorMasterKey = this.constructorKey;
        this.methodKey = methodKey;
        methodMasterKey = this.methodKey;

        this.checkObjectValidity();

        model.addAttribute("allInheritanceData", this);

        return "lessons/michaelMixedTypes";

    }

    private void setEmployee(T employee) {
        this.employee = employee;
    }

    private void checkObjectValidity() {
        if ((this.declarativeKey.equals(DeclarativeType.Administrator) && this.constructorKey.equals(ConstructorType.Employee)) || (this.declarativeKey.equals(DeclarativeType.Teacher) && this.constructorKey.equals(ConstructorType.Employee)) || (this.declarativeKey.equals(DeclarativeType.CompScienceInstructor) && this.constructorKey.equals(ConstructorType.Employee)) || (this.declarativeKey.equals(DeclarativeType.Principal) && this.constructorKey.equals(ConstructorType.Employee)) || (this.declarativeKey.equals(DeclarativeType.CompScienceInstructor) && this.constructorKey.equals(ConstructorType.Teacher)) || (this.declarativeKey.equals(DeclarativeType.Principal) && this.constructorKey.equals(ConstructorType.Administrator))) {
            this.formattedResult = "The selected object instantiation does not respect class hierarchy and will throw an error";
        } else if ((this.declarativeKey.equals(DeclarativeType.CompScienceInstructor) && this.constructorKey.equals(ConstructorType.Principal)) || (this.declarativeKey.equals(DeclarativeType.Principal) && this.constructorKey.equals(ConstructorType.CompScienceInstructor)) || (this.declarativeKey.equals(DeclarativeType.Administrator) && this.constructorKey.equals(ConstructorType.Teacher)) || (this.declarativeKey.equals(DeclarativeType.Teacher) && this.constructorKey.equals(ConstructorType.Administrator))) {
            this.formattedResult = "The selected object instantiation is composed of unrelated types";
        } else {
            if (this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Employee)) {
                if ((this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod))) {
                    Employee ee1 = new Employee("Terrell", 23);
                    this.setEmployee((T) ee1);
                    switch (this.methodKey) {
                        case getInfo:
                            this.formattedResult = ee1.getInfo();
                            break;
                        case displayOccupation:
                            this.formattedResult = ee1.displayOccupation();
                            break;
                        case rootMethod:
                            this.formattedResult = ee1.rootMethod();
                            break;
                        default:
                            this.formattedResult = "Unknown error in radio assignments";
                    }
                } else if ((this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Employee)) != (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod))) {
                    this.formattedResult = "The selected method is not accessible to Employee e = new Employee();";
                }
            } else if (this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Teacher)) {
                if ((this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getSubject))) {
                    Employee et1 = new Teacher("Terrell", 23, "Computer Science");
                    this.setEmployee((T) et1);
                    switch (this.methodKey) {
                        case getInfo:
                            this.formattedResult = et1.getInfo();
                            break;
                        case displayOccupation:
                            this.formattedResult = et1.displayOccupation();
                            break;
                        case rootMethod:
                            this.formattedResult = et1.rootMethod();
                            break;
                        case getSubject:
                            this.formattedResult = ((Teacher) et1).getSubject();
                            break;
                        default:
                            this.formattedResult = "Unknown error in radio assignments";
                    }
                } else if ((this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Teacher)) != (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getSubject))) {
                    this.formattedResult = "The selected method is not accessible to Employee e = new Teacher();";
                }
            } else if (this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Administrator)) {
                if ((this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getScope))) {
                    Employee ea1 = new Administrator("Terrell", 23, "Principal");
                    this.setEmployee((T) ea1);
                    switch (this.methodKey) {
                        case getInfo:
                            this.formattedResult = ea1.getInfo();
                            break;
                        case displayOccupation:
                            this.formattedResult = ea1.displayOccupation();
                            break;
                        case rootMethod:
                            this.formattedResult = ea1.rootMethod();
                            break;
                        case getScope:
                            this.formattedResult = ((Administrator) ea1).getScope();
                            break;
                        default:
                            this.formattedResult = "Unknown error in radio assignments";
                    }
                } else if ((this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Administrator)) != (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getScope))) {
                    this.formattedResult = "The selected method is not accessible to Employee e = new Teacher();";
                }
            } else if (this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.CompScienceInstructor)) {
                if ((this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getSubject)|| this.methodKey.equals(MethodType.getBinaryCode))) {
                    Employee ec1 = new CompScienceInstructor("Terrell", 23,01000011);
                    this.setEmployee((T) ec1);
                    switch (this.methodKey) {
                        case getInfo:
                            this.formattedResult = ec1.getInfo();
                            break;
                        case displayOccupation:
                            this.formattedResult = ec1.displayOccupation();
                            break;
                        case rootMethod:
                            this.formattedResult = ec1.rootMethod();
                            break;
                        case getSubject:
                            this.formattedResult = ((CompScienceInstructor) ec1).getSubject();
                            break;
                        case getBinaryCode:
                            this.formattedResult = Float.toString(((CompScienceInstructor) ec1).getBinaryCode());
                            break;
                        default:
                            this.formattedResult = "Unknown error in radio assignments";
                    }
                } else if ((this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Administrator)) != (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getSubject) || this.methodKey.equals(MethodType.getBinaryCode))) {
                    this.formattedResult = "The selected method is not accessible to Employee e = new CompScienceInstructor();";
                }
            } else if (this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Principal)) {
                if ((this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getScope)|| this.methodKey.equals(MethodType.getSlogan))) {
                    Employee ep1 = new Principal("Terrell", 23, "One flock, one family");
                    this.setEmployee((T) ep1);
                    switch (this.methodKey) {
                        case getInfo:
                            this.formattedResult = ep1.getInfo();
                            break;
                        case displayOccupation:
                            this.formattedResult = ep1.displayOccupation();
                            break;
                        case rootMethod:
                            this.formattedResult = ep1.rootMethod();
                            break;
                        case getScope:
                            this.formattedResult = ((Principal) ep1).getScope();
                            break;
                        case getSlogan:
                            this.formattedResult = ((Principal) ep1).getSlogan();
                            break;
                        default:
                            this.formattedResult = "Unknown error in radio assignments";
                    }
                } else if ((this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Administrator)) != (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getScope) || this.methodKey.equals(MethodType.getSlogan))) {
                    this.formattedResult = "The selected method is not accessible to Employee e = new Principal();";
                }
            }
        }

        /*
        if (this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Employee) && (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod))) {
            Employee ee1 = new Employee("Terrell", 23);
            this.setEmployee((T) ee1);
            switch (this.methodKey) {
                case getInfo:
                    this.formattedResult = ee1.getInfo();
                    break;
                case displayOccupation:
                    this.formattedResult = ee1.displayOccupation();
                    break;
                case rootMethod:
                    this.formattedResult = ee1.rootMethod();
                    break;
                default:
                    this.formattedResult = "Unknown error in radio assignments";
            }
        } else if ((this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Employee)) != (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod))) {
            this.formattedResult = "The selected method is not accessible to Employee e = new Employee();";
        }

        if (this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Teacher) && (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getSubject))) {
            Employee et1 = new Teacher("Terrell", 23, "Computer Science");
            this.setEmployee((T) et1);
            switch (this.methodKey) {
                case getInfo:
                    this.formattedResult = et1.getInfo();
                    break;
                case displayOccupation:
                    this.formattedResult = et1.displayOccupation();
                    break;
                case rootMethod:
                    this.formattedResult = et1.rootMethod();
                    break;
                case getSubject:
                    this.formattedResult = ((Teacher) et1).getSubject();
                    break;
                default:
                    this.formattedResult = "Unknown error in radio assignments";
            }
        } else if ((this.declarativeKey.equals(DeclarativeType.Employee) && this.constructorKey.equals(ConstructorType.Teacher)) != (this.methodKey.equals(MethodType.getInfo) || this.methodKey.equals(MethodType.displayOccupation) || this.methodKey.equals(MethodType.rootMethod) || this.methodKey.equals(MethodType.getSubject))) {
            this.formattedResult = "The selected method is not accessible to Employee e = new Teacher();";
        }*/

    }
}
