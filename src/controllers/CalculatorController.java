package controllers;

import models.CalculatorModel;
import views.CalculatorView;

public class CalculatorController {
    private CalculatorModel calculatorModel;
    private CalculatorView calculatorView;

    public CalculatorController(CalculatorModel calculatorModel, CalculatorView calculatorView){

        this.calculatorModel = calculatorModel;
        this.calculatorView = calculatorView;

        calculatorView.addCalculationListener(calcEvent -> {
            int firstNumber = calculatorView.getFirstNumber();
            int secondNumber = calculatorView.getSecondNumber();

            new Thread(new CalculationThread(firstNumber, secondNumber)).start();

        });
    }

    private class CalculationThread implements Runnable{
        int firstNumber;
        int secondNumber;

        CalculationThread(int firstNumber, int secondNumber){
            this.firstNumber = firstNumber;
            this.secondNumber  = secondNumber;
        }

        @Override
        public void run(){
            try{
                calculatorModel.addTwoNumbers(firstNumber, secondNumber);

                calculatorView.setCalculateSolution(calculatorModel.calculationValue());
            }
            catch(NumberFormatException e){
                calculatorView.displayErrorMessage("You need to enter 2 integers");
            }
        }

    }
}
