package com.example.bartoszujazdowski.androidcalculator.calculator;

public class Calculate {
    private Double firstNum;
    private Double secondNum;
    private Action action;
    private Boolean writeToFirstNum;

    public Calculate(){
        this.clear();
    }

    public Double equal() throws ArithmeticException {
        this.calculate();
        return this.getFirstNum();
    }

    public void clear(){
        this.secondNum = 0.0;
        this.firstNum = 0.0;
        this.action = Action.EMPTY;
        this.writeToFirstNum = true;
    }

    private void calculate() throws ArithmeticException{
        switch (this.getAction()){
            case DIVISION:
                if (this.getSecondNum() != 0) {
                    this.firstNum = this.getFirstNum() / this.getSecondNum();
                } else {
                    throw new ArithmeticException();
                }
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
            case EMPTY:
                this.firstNum = this.secondNum;
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
