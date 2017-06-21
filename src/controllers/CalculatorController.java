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

        calculatorView.addCalculationListeners(e -> new Thread(new CalculationThread(e)).start() );
    }

    private class CalculationThread implements Runnable{
        private ActionEvent e;

        CalculationThread(ActionEvent e){
            this.e = e;
        }

        @Override
        public void run(){
            double firstNumber;
            double secondNumber;
            JTextField viewCalcArea = calculatorView.getCalcArea();
            String viewCalcAreaText = viewCalcArea.getText();

           if(e.getSource() == calculatorView.getB1()){
                viewCalcArea.setText(viewCalcAreaText.concat("1"));
           }
           if(e.getSource() == calculatorView.getB2()){
               viewCalcArea.setText(viewCalcAreaText.concat("2"));
           }
           if(e.getSource() == calculatorView.getB3()){
               viewCalcArea.setText(viewCalcAreaText.concat("3"));
           }
           if(e.getSource() == calculatorView.getB4()){
               viewCalcArea.setText(viewCalcAreaText.concat("4"));
           }
           if(e.getSource() == calculatorView.getB5()){
               viewCalcArea.setText(viewCalcAreaText.concat("5"));
           }
           if(e.getSource() == calculatorView.getB6()){
               viewCalcArea.setText(viewCalcAreaText.concat("6"));
           }
           if(e.getSource() == calculatorView.getB7()){
               viewCalcArea.setText(viewCalcAreaText.concat("7"));
           }
           if(e.getSource() == calculatorView.getB8()){
               viewCalcArea.setText(viewCalcAreaText.concat("8"));
           }
           if(e.getSource() == calculatorView.getB9()){
               viewCalcArea.setText(viewCalcAreaText.concat("9"));
           }
           if(e.getSource() == calculatorView.getB0()){
               viewCalcArea.setText(viewCalcAreaText.concat("0"));
           }
           if(e.getSource() == calculatorView.getBAdd() && viewCalcAreaText.matches("-?[0-9]+(.?([0-9])+)?")){
               firstNumber = Double.parseDouble(viewCalcAreaText);
               calculatorModel.setFirstNumber(firstNumber);
               calculatorModel.setOperator(1);
               viewCalcArea.setText("");
           }
           if(e.getSource() == calculatorView.getBSub()){
               if(viewCalcAreaText.length() == 0){
                   viewCalcArea.setText(viewCalcAreaText.concat("-"));
               }else if(viewCalcAreaText.matches("-?[0-9]+(.?([0-9])+)?")){
                   firstNumber = Double.parseDouble(viewCalcAreaText);
                   calculatorModel.setFirstNumber(firstNumber);
                   calculatorModel.setOperator(2);
                   viewCalcArea.setText("-");
               }
           }
           if(e.getSource() == calculatorView.getBMul() && viewCalcAreaText.matches("-?[0-9]+(.?([0-9])+)?")){
               firstNumber = Double.parseDouble(viewCalcAreaText);
               calculatorModel.setFirstNumber(firstNumber);
               calculatorModel.setOperator(3);
               viewCalcArea.setText("");
           }
           if(e.getSource() == calculatorView.getBDiv() && viewCalcAreaText.matches("-?[0-9]+(.?([0-9])+)?")){
               firstNumber = Double.parseDouble(viewCalcAreaText);
               calculatorModel.setFirstNumber(firstNumber);
               calculatorModel.setOperator(4);
               viewCalcArea.setText("");
           }
           if(e.getSource() == calculatorView.getBRes() && calculatorModel.isFirstNumInited()){
               secondNumber = Double.parseDouble(viewCalcArea.getText());
               calculatorModel.setSecondNumber(secondNumber);

               calculatorModel.solveCalculation();

               viewCalcArea.setText( Double.toString(calculatorModel.getCalculationValue()) );
           }
           if(e.getSource() == calculatorView.getBDot() && viewCalcAreaText.matches("-?[0-9]+(.?([0-9])+)?")) {
               viewCalcArea.setText(viewCalcArea.getText().concat("."));
           }
           if(e.getSource() == calculatorView.getBDel() && viewCalcAreaText.length() > 0){
               String subCalcArea;
               subCalcArea = viewCalcAreaText.substring( 0, viewCalcAreaText.length() - 1 );
               viewCalcArea.setText(subCalcArea);
           }
           if(e.getSource() == calculatorView.getBClr()){
               calculatorModel.setFirstNumber(0);
               calculatorModel.setSecondNumber(0);
               calculatorModel.setOperator(0);
               calculatorModel.setFirstNumInited(false);
               viewCalcArea.setText(""); 
           }
        }
    }
}
