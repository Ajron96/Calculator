package controllers;

import models.CalculatorModel;
import views.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalculatorController {
    private CalculatorModel calculatorModel;
    private CalculatorView calculatorView;

    public CalculatorController(CalculatorModel calculatorModel, CalculatorView calculatorView){

        this.calculatorModel = calculatorModel;
        this.calculatorView = calculatorView;

        calculatorView.addCalculationListeners(e -> new Thread(new Calculate(e)).start() );
    }

    private class Calculate implements Runnable{
        private ActionEvent e;
        JTextField viewCalcArea;    //reference to view's calcArea
        String viewCalcAreaText;    //text of viewCalcArea

        private Calculate(ActionEvent e){
            this.e = e;
            this.viewCalcArea = calculatorView.getCalcArea();
            this.viewCalcAreaText = viewCalcArea.getText();
        }

        @Override
        public void run(){

            ifNumButtonClicked();
            ifOperatorButtonClicked();
            ifResultButtonClicked();

            //ifDotButtonClicked
            if(e.getSource() == calculatorView.getBDot() && viewCalcAreaText.matches("-?\\d+(.?(\\d)+)?")) {
                concatCalcArea(".");
            }
            //ifDelButtonClicked
            if(e.getSource() == calculatorView.getBDel() && viewCalcAreaText.length() > 0){
                String subCalcArea;
                subCalcArea = viewCalcAreaText.substring( 0, viewCalcAreaText.length() - 1 );
                viewCalcArea.setText(subCalcArea);
            }
            //ifClearButtonClicked
            if(e.getSource() == calculatorView.getBClr()){
                clearCalc();
            }
        }

        private void concatCalcArea(String text){
            viewCalcArea.setText(viewCalcAreaText.concat(text));
        }

        private void ifNumButtonClicked(){
            if(e.getSource() == calculatorView.getB1()) concatCalcArea("1");
            if(e.getSource() == calculatorView.getB2()) concatCalcArea("2");
            if(e.getSource() == calculatorView.getB3()) concatCalcArea("3");
            if(e.getSource() == calculatorView.getB4()) concatCalcArea("4");
            if(e.getSource() == calculatorView.getB5()) concatCalcArea("5");
            if(e.getSource() == calculatorView.getB6()) concatCalcArea("6");
            if(e.getSource() == calculatorView.getB7()) concatCalcArea("7");
            if(e.getSource() == calculatorView.getB8()) concatCalcArea("8");
            if(e.getSource() == calculatorView.getB9()) concatCalcArea("9");
            if(e.getSource() == calculatorView.getB0()) concatCalcArea("0");
        }

        private void ifOperatorButtonClicked(){

            // a+b
            if(e.getSource() == calculatorView.getBAdd() && viewCalcAreaText.matches("-?\\d+(.?(\\d)+)?")){
                double firstNumber = Double.parseDouble(viewCalcAreaText);
                setFirstNumAndOperation(firstNumber, 1,"");
            }

            // a-b
            if(e.getSource() == calculatorView.getBSub()){
                if(viewCalcAreaText.length() == 0){
                    concatCalcArea("-");
                }else if(viewCalcAreaText.matches("-?\\d+(.?(\\d)+)?")) {
                    double firstNumber = Double.parseDouble(viewCalcAreaText);
                    setFirstNumAndOperation(firstNumber, 1,"-");
                }
            }

            // a*b
            if(e.getSource() == calculatorView.getBMul() && viewCalcAreaText.matches("-?\\d+(.?(\\d)+)?")){
                double firstNumber = Double.parseDouble(viewCalcAreaText);
                setFirstNumAndOperation(firstNumber, 2,"");
            }

            // a/b
            if(e.getSource() == calculatorView.getBDiv() && viewCalcAreaText.matches("-?\\d+(.?(\\d)+)?")){
                double firstNumber = Double.parseDouble(viewCalcAreaText);
                setFirstNumAndOperation(firstNumber, 3,"");
            }

        }

        private void ifResultButtonClicked(){
            if(e.getSource() == calculatorView.getBRes() && calculatorModel.isFirstNumInited()){
                double secondNumber;

                try{

                    secondNumber = Double.parseDouble(viewCalcArea.getText());

                    if(secondNumber == 0){
                        calculatorView.displayErrorMessage("You cannot divide by 0");
                        clearCalc();
                    }
                    else {
                        calculatorModel.setSecondNumber(secondNumber);

                        calculatorModel.solveCalculation();

                        viewCalcArea.setText(Double.toString(calculatorModel.getCalculationValue()));
                    }
                }
                catch(NumberFormatException e){ //if empty string or "-"
                    calculatorView.displayErrorMessage("Second number is not entered");
                    clearCalc();
                }
            }
        }

        private void setFirstNumAndOperation(double firstNumber, int operator, String calcAreaText){
            calculatorModel.setFirstNumber(firstNumber);
            calculatorModel.setOperator(operator);
            viewCalcArea.setText(calcAreaText);
        }

        private void clearCalc(){
            calculatorModel.setFirstNumber(0);
            calculatorModel.setSecondNumber(0);
            calculatorModel.setOperator(0);
            calculatorModel.setFirstNumInited(false);
            viewCalcArea.setText("");
        }

    }
}