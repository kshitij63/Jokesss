package com.example;

import java.util.ArrayList;

public class MyClass {

    private ArrayList<String> jokes;

    public String tell_joke(){
        jokes=new ArrayList<>();
        jokes.add("jokes");
        return jokes.get(0);
    }

}
