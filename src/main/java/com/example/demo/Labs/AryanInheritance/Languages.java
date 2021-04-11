package com.example.demo.Labs.AryanInheritance;

public class Languages extends AryanInheritance {

    public enum Info {title, language, year, creator, use}
    public static Info token = Info.title;
    private final String language;
    private final int year;
    private final String creator;
    private final String use;

    public Languages (String language1, int year1, String creator1, String use1) {
        language = language1;
        year = year1;
        creator = creator1;
        use = use1;
    }

    @Override
    public String toString() {
        String display = "";
        switch(token) {
            // case statement to display the different outputs
            case language:
                display += language;
                break;
            case year:
                display += year;
                break;
            case creator:
                display += creator;
                break;
            case use:
                display += use;
                break;
            case title:
            default:
                display += "";
        }
        return display;

    }

    public static AryanInheritance[] LanguageInfo() {
        return new AryanInheritance[] {
                new Languages("Java", 1996, "James Gosling", "Web APIs, cloud based programs, Code once run everywhere"),
                new Languages("Python", 1991, "Guido van Rossum", "Web applications, backend coding"),
                new Languages("C++", 1998,"Bjarne Stroustrup","CPU functions, operating systems (MacOS, Windows), web browsers, advanced graphics"),
                new Languages("Swift", 2010,"Chris Lattner and Apple developers", "iOS apps"),
                new Languages("HTML", 1993, "Tim Berners-Lee", "web development, structure of page"),
                new Languages("CSS", 1994, "Håkon Wium Lie", "styling web pages"),
                new Languages("JavaScript", 1995,"Brandan Eich", "back end code for web pages"),
                new Languages("Scratch", 2003, "Mitchel Resnick", "teach kids the fundamentals of coding")
        };

    }
    public static void main(String[] args)
    {
        AryanInheritance[] langInfo = LanguageInfo();
        for(AryanInheritance l : langInfo)
            System.out.println("" + l);
    }


}

