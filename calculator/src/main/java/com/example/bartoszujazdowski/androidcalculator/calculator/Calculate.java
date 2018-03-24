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
                    throw new ArithmeticException("You can not divide by 0");
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
            case XPOW2:
                this.firstNum *= this.firstNum;
                break;
            case XPOWY:
                this.firstNum = Math.pow(this.firstNum, this.secondNum);
                break;
            case SIN:
                this.firstNum = Math.sin(this.firstNum);
                break;
            case COS:
                this.firstNum = Math.cos(this.firstNum);
                break;
            case TAN:
                this.firstNum = Math.tan(this.firstNum);
                break;
            case LN:
                if ( this.firstNum < 0 ){
                    throw new ArithmeticException("Number less than 0!");
                }
                this.firstNum = Math.log(this.firstNum);
                break;
            case LOG:
                if ( this.firstNum < 0 ){
                    throw new ArithmeticException("Number less than 0!");
                }
                this.firstNum = Math.log10(this.firstNum);
                break;
            case SQRT:
                if ( this.firstNum < 0 ){
                    throw new ArithmeticException("Number less than 0!");
                }
                this.firstNum = Math.sqrt(this.firstNum);
                break;
            case EMPTY:
                this.firstNum = this.secondNum;
                break;
        }
        if (isOneParameterFunctionSet()){
            this.writeToFirstNum = true;
        }

        if (Double.isInfinite(this.firstNum)){
            throw new ArithmeticException("Result is infinite!");
        }

        if (Double.isNaN(this.firstNum)){
            throw new ArithmeticException("Result is NaN!");
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

    private Boolean isOneParameterFunctionSet(){
        return action == Action.COS || action == Action.SIN || action == Action.TAN || action == Action.LN || action == Action.SQRT || action == Action.XPOW2 || action == Action.LOG;
    }

    public void setAction(Action action) throws ArithmeticException{
        this.action = action;
        if (this.isOneParameterFunctionSet()){
            this.calculate();
        }
    }
}
