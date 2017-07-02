package views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CalculatorView extends JFrame {
    private JPanel calcPanel;
    private JTextField calcArea;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b0;
    private JButton bAdd;
    private JButton bSub;
    private JButton bMul;
    private JButton bDiv;
    private JButton bRes;
    private JButton bDot;
    private JButton bDel;
    private JButton bClr;

    public CalculatorView(){
        super("Calculator");

        try{
            setIconImage(ImageIO.read(new File("images/CalculatorIcon.png")));
        }catch(IOException e){
            displayErrorMessage("Image cannot be loaded");
        }

        calcPanel = new JPanel();

        setSize(350,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        createComponents();
    }

    public JTextField getCalcArea() {
        return calcArea;
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JButton getB3() {
        return b3;
    }

    public JButton getB4() {
        return b4;
    }

    public JButton getB5() {
        return b5;
    }

    public JButton getB6() {
        return b6;
    }

    public JButton getB7() {
        return b7;
    }

    public JButton getB8() {
        return b8;
    }

    public JButton getB9() {
        return b9;
    }

    public JButton getB0() {
        return b0;
    }

    public JButton getBAdd() {
        return bAdd;
    }

    public JButton getBSub() {
        return bSub;
    }

    public JButton getBMul() {
        return bMul;
    }

    public JButton getBDiv() {
        return bDiv;
    }

    public JButton getBRes() {
        return bRes;
    }

    public JButton getBDot() {
        return bDot;
    }

    public JButton getBDel() {
        return bDel;
    }

    public JButton getBClr() {
        return bClr;
    }

    public void addCalculationListeners(ActionListener buttonListener){
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b3.addActionListener(buttonListener);
        b4.addActionListener(buttonListener);
        b5.addActionListener(buttonListener);
        b6.addActionListener(buttonListener);
        b7.addActionListener(buttonListener);
        b8.addActionListener(buttonListener);
        b9.addActionListener(buttonListener);
        b0.addActionListener(buttonListener);
        bAdd.addActionListener(buttonListener);
        bSub.addActionListener(buttonListener);
        bMul.addActionListener(buttonListener);
        bDiv.addActionListener(buttonListener);
        bRes.addActionListener(buttonListener);
        bDot.addActionListener(buttonListener);
        bDel.addActionListener(buttonListener);
        bClr.addActionListener(buttonListener);
    }

    private void createComponents(){
        calcArea = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bAdd = new JButton("+");
        bSub = new JButton("-");
        bMul = new JButton("*");
        bDiv = new JButton("/");
        bDot = new JButton(".");
        bRes = new JButton("=");
        bDel = new JButton("Delete");
        bClr = new JButton("Clear");

        calcPanel.setLayout(null);

        calcArea.setEditable(false);
        calcArea.setBackground(Color.white);
        calcArea.setBounds(30,40,280,30);

        b7.setBounds(40,100,50,40);
        b8.setBounds(110,100,50,40);
        b9.setBounds(180,100,50,40);
        bDiv.setBounds(250,100,50,40);

        b4.setBounds(40,170,50,40);
        b5.setBounds(110,170,50,40);
        b6.setBounds(180,170,50,40);
        bMul.setBounds(250,170,50,40);

        b1.setBounds(40,240,50,40);
        b2.setBounds(110,240,50,40);
        b3.setBounds(180,240,50,40);
        bSub.setBounds(250,240,50,40);

        bDot.setBounds(40,310,50,40);
        b0.setBounds(110,310,50,40);
        bRes.setBounds(180,310,50,40);
        bAdd.setBounds(250,310,50,40);

        bDel.setBounds(60,380,100,40);
        bClr.setBounds(180,380,100,40);

        calcPanel.add(calcArea);
        calcPanel.add(b1);
        calcPanel.add(b2);
        calcPanel.add(b3);
        calcPanel.add(b4);
        calcPanel.add(b5);
        calcPanel.add(b6);
        calcPanel.add(b7);
        calcPanel.add(b8);
        calcPanel.add(b9);
        calcPanel.add(b0);
        calcPanel.add(bAdd);
        calcPanel.add(bSub);
        calcPanel.add(bMul);
        calcPanel.add(bDiv);
        calcPanel.add(bRes);
        calcPanel.add(bDot);
        calcPanel.add(bDel);
        calcPanel.add(bClr);

        add(calcPanel);

        setVisible(true);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
