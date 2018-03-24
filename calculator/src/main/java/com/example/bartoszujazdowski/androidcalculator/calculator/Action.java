package com.example.bartoszujazdowski.androidcalculator.calculator;

public enum Action {
    DIVISION("/"),
    MULTIPLICATION("*"),
    SUBSTRACTION("-"),
    ADDITION("+"),
    XPOW2("x^2"),
    XPOWY("x^y"),
    SIN("sin"),
    COS("cos"),
    TAN("tan"),
    LN("ln"),
    LOG("log"),
    SQRT("sqrt"),
    EMPTY("");
    String action;

    Action(String action){
        this.action = action;
    }

    @Override
    public String toString(){
        return action;
    }

    static Action get(String value){
        for (Action action : Action.values()){
            if (value.equals(action.action)){
                return action;
            }
        }
        return null;
    }
}
