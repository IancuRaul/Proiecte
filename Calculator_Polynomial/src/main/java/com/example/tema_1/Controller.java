package com.example.tema_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.Operation;

import java.util.HashMap;

public class Controller
{
    public TextField Polinom2;
    @FXML
    private Label welcomeText;
    @FXML
    public TextField Polinom1;

    @FXML
    protected void addition()
    {
        String text1 = Polinom1.getText();
        String text2 = Polinom2.getText();
        Operation operation = new Operation();
        HashMap<Integer, Double> P1 = operation.parsePolynomial(text1);
        HashMap<Integer, Double> P2 = operation.parsePolynomial(text2);
        HashMap<Integer, Double> P3 = operation.addition(P1, P2);
        String result = operation.polynomialToString(P3);
        if(!text1.isEmpty() || !text2.isEmpty())
        {
            if (!result.isEmpty())
                welcomeText.setText(result);
            else
                welcomeText.setText("0");
        }
        else
            welcomeText.setText("Imput polynomial in one of the TextBox-es");
    }
    @FXML
    protected void subtraction()
    {
        String text1 = Polinom1.getText();
        String text2 = Polinom2.getText();
        Operation operation = new Operation();
        HashMap<Integer, Double> P1 = operation.parsePolynomial(text1);
        HashMap<Integer, Double> P2 = operation.parsePolynomial(text2);
        HashMap<Integer, Double> P3 = operation.subtraction(P1, P2);
        String result = operation.polynomialToString(P3);
        if(!text1.isEmpty() || !text2.isEmpty())
        {
            if (!result.isEmpty())
                welcomeText.setText(result);
            else
                welcomeText.setText("0");
        }
        else
            welcomeText.setText("Imput polynomial in one of the TextBox-es");
    }

    public void multiplication(ActionEvent actionEvent)
    {
        String text1 = Polinom1.getText();
        String text2 = Polinom2.getText();
        Operation operation = new Operation();
        HashMap<Integer, Double> P1 = operation.parsePolynomial(text1);
        HashMap<Integer, Double> P2 = operation.parsePolynomial(text2);
        HashMap<Integer, Double> P3 = operation.multiplication(P1, P2);
        String result = operation.polynomialToString(P3);
        if(!text1.isEmpty() && !text2.isEmpty())
        {
            if (!result.isEmpty())
                welcomeText.setText(result);
            else
                welcomeText.setText("0");
        }
        else
            welcomeText.setText("Imput polynomial in both of the TextBox-es");
    }

    public void division(ActionEvent actionEvent)
    {
        String text1 = Polinom1.getText();
        String text2 = Polinom2.getText();
        Operation operation = new Operation();
        HashMap<Integer, Double> P1 = operation.parsePolynomial(text1);
        HashMap<Integer, Double> P2 = operation.parsePolynomial(text2);
        if(operation.degree(P1) < operation.degree(P2))
            welcomeText.setText("Second polynomial has higher degree than the first one");
        else
        {
            if(text1.isEmpty() || text2.isEmpty())
                welcomeText.setText("Input two polynomials");
            else
            {
                if(operation.degree(P2) == 0)
                    welcomeText.setText("Input a polynomial with a higher degree for the divider");
                else
                {
                    HashMap<Integer, Double> P3 = operation.division(P1, P2);
                    String result = operation.polynomialToString(P3);
                    HashMap<Integer, Double> P4 = operation.remainder(P1, P2);
                    String result2 = operation.polynomialToString(P4);
                    if (!result2.isEmpty())
                        welcomeText.setText("Quotient : " + result + "  Remainder : " + result2);
                    else
                        welcomeText.setText("Quotient : " + result);
                }
            }
        }
    }

    public void integration(ActionEvent actionEvent)
    {
        String text1 = Polinom1.getText();
        Operation operation = new Operation();
        HashMap<Integer, Double> P1 = operation.parsePolynomial(text1);
        HashMap<Integer, Double> P3 = operation.integration(P1);
        String result = operation.polynomialToString(P3);
        if(!text1.isEmpty())
        {
            if (!result.isEmpty())
                welcomeText.setText(result);
            else
                welcomeText.setText("0");
        }
        else
            welcomeText.setText("Imput polynomial in the first TextBox");
    }

    public void derivation(ActionEvent actionEvent)
    {
        String text1 = Polinom1.getText();
        Operation operation = new Operation();
        HashMap<Integer, Double> P1 = operation.parsePolynomial(text1);
        HashMap<Integer, Double> P3 = operation.derivation(P1);
        String result = operation.polynomialToString(P3);
        if(!text1.isEmpty())
        {
            if (!result.isEmpty())
                welcomeText.setText(result);
            else
                welcomeText.setText("0");
        }
        else
            welcomeText.setText("Imput polynomial in the first TextBox");
    }
}