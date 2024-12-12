package week1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class CalculatorApp implements ActionListener {
    JFrame frame;
    JTextField display;
    JButton[] numButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public CalculatorApp() {
        frame = new JFrame("Simple Calculator");
        display = new JTextField();

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        frame.setLayout(new GridLayout(4, 4));
        frame.add(display);

        for (JButton button : numButtons) {
            frame.add(button);
        }
        frame.add(addButton);
        frame.add(subButton);
        frame.add(mulButton);
        frame.add(divButton);
        frame.add(eqButton);
        frame.add(clrButton);

        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clrButton) {
            display.setText("");
            return;
        }
        
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
            return;
        }
        
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");  
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        // Handle number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                display.setText(display.getText() + i);
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}


