package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame {
    private JTextField firstNumber;
    private JLabel additionalLabel;
    private JTextField secondNumber;
    private JButton calculateButton;
    private JTextField calculateSolution;

    public CalculatorView(){
        super("Calculator");

        JPanel calcPanel = new JPanel();

        setLayout(new FlowLayout());
        setResizable(false);
        setSize(600,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        firstNumber = new JTextField(10);
        additionalLabel = new JLabel("+");
        secondNumber = new JTextField(10);
        calculateButton = new JButton("Calculate");
        calculateSolution = new JTextField(10);

        calcPanel.add(firstNumber);
        calcPanel.add(additionalLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(calculateButton);
        calcPanel.add(calculateSolution);

        add(calcPanel);

        pack();
        setVisible(true);
    }

    public int getFirstNumber(){
        return Integer.parseInt(firstNumber.getText());
    }

    public int getSecondNumber(){
        return Integer.parseInt(secondNumber.getText());
    }

    public void setCalculateSolution(int solution){
        calculateSolution.setText(Integer.toString(solution));
    }

    public void addCalculationListener(ActionListener listenForCalcButton){
        calculateButton.addActionListener(listenForCalcButton);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
