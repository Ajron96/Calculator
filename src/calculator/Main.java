package calculator;

import controllers.CalculatorController;
import models.CalculatorModel;
import views.CalculatorView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        CalculatorView CalculatorView = new CalculatorView();
        CalculatorModel calculatorModel = new CalculatorModel();

        EventQueue.invokeLater( () -> new CalculatorController(calculatorModel, CalculatorView) );

    }
}
