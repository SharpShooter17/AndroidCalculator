package com.example.bartoszujazdowski.androidcalculator.calculator;

/**
 * Created by Bartosz Ujazdowski on 22.03.2018.
 */

public enum Action {
    DIVISION("/"),
    MULTIPLICATION("*"),
    SUBSTRACTION("-"),
    ADDITION("+");

    String action;

    Action(String action){
        this.action = action;
    }

    @Override
    public String toString(){
        return action;
    }
}
