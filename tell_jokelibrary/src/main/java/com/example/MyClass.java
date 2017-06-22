package com.example;

import java.util.ArrayList;

public class MyClass {

    private ArrayList<String> jokes;

    public String tell_joke(){
        jokes=new ArrayList<>();
        jokes.add("jokes");
        jokes.add("another joke");
        jokes.add("yeaah!!another joke");
        return jokes.get((int) (Math.random()*jokes.size()));
    }

}
