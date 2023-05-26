package com.memmatch;

import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;

    //Constructors
    public Player( String name) {
        setName(name);
    }

    //business or action methods


    // accessor methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}