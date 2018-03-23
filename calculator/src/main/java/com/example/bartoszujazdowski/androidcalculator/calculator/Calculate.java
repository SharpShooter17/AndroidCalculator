package com.example.bartoszujazdowski.androidcalculator.calculator;

public class Calculate {
    private Double firstNum;
    private Double secondNum;
    private Action action;
    private Boolean writeToFirstNum;

    public Calculate(){
        this.clear();
    }

    public Double equal(){
        this.calculate();
        this.secondNum = 0.0;

        return this.getFirstNum();
    }

    public void clear(){
        this.secondNum = 0.0;
        this.firstNum = 0.0;
        this.action = Action.EMPTY;
        this.writeToFirstNum = true;
    }

    private void calculate(){
        switch (this.getAction()){
            case DIVISION:
                this.firstNum = this.getFirstNum() / this.getSecondNum();
                break;
            case MULTIPLICATION:
                this.firstNum = this.getFirstNum() * this.getSecondNum();
                break;
            case SUBSTRACTION:
                this.firstNum = this.getFirstNum() - this.getSecondNum();
                break;
            case ADDITION:
                this.firstNum = this.getFirstNum() + this.getSecondNum();
                break;
        }
    }

    public void setNum(Double value){
        if (this.writeToFirstNum){
            this.firstNum = value;
            this.writeToFirstNum = false;
        } else {
            this.secondNum = value;
        }
    }

    public Double getFirstNum() {
        return firstNum;
    }

    public Double getSecondNum() {
        return secondNum;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action){
        this.action = action;
    }
}
