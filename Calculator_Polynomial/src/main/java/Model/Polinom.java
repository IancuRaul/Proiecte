package Model;

import logic.Operation;

import java.util.HashMap;

import java.util.Collections;

public class Polinom
{
    private HashMap<Integer, Double> Polinom = new HashMap<Integer, Double>();
    public Polinom(HashMap<Integer, Double>P)
    {
        Polinom = P;

    }

    public void setPolinom(HashMap<Integer, Double> polinom) {
        Polinom = polinom;
    }

    public static void main(String[] args)
    {
        HashMap<Integer, Double> P1 = new HashMap<>();
        P1.put(0, -5.);
        P1.put(1, 6.);
        P1.put(2, -2.);
        P1.put(3, 1.);

        HashMap<Integer, Double> P2 = new HashMap<>();
        P2.put(0, -1.);
        P2.put(2, 1.);

        Operation operation = new Operation();
        String text = "x^5 + x - 2";
        HashMap<Integer, Double> polynomialMap = operation.parsePolynomial(text);
        String text2 = operation.polynomialToString(polynomialMap);
        System.out.println(text2);
    }
}
