package models;

public class CalculatorModel {
    private double firstNumber;
    private double secondNumber;
    private double calculationValue;
    private int operator;

    public void solveCalculation(){

       switch(operator){
           case 1: calculationValue = firstNumber + secondNumber; break;
           case 2: calculationValue = firstNumber - secondNumber; break;
           case 3: calculationValue = firstNumber * secondNumber; break;
           case 4: calculationValue = firstNumber / secondNumber; break;
           default: calculationValue = 0;
       }
    }

    public void setFirstNumber(double firstNumber){
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber){
        this.secondNumber = secondNumber;
    }

    public void setOperator(int operator){
        this.operator = operator;
    }

    public double getCalculationValue(){
        return calculationValue;
    }
}
