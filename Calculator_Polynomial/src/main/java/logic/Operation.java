package logic;
import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation
{
    public HashMap<Integer, Double> addition(HashMap<Integer,Double> firstPolynomial, HashMap<Integer,Double> secondPolynomial)
    {
        HashMap<Integer, Double> polynomialAddition = new HashMap<>();
        HashSet<Integer> allKeys = new HashSet<>();
        allKeys.addAll(firstPolynomial.keySet());
        allKeys.addAll(secondPolynomial.keySet());
        for (int i : allKeys)
        {
            double coef1 = firstPolynomial.getOrDefault(i, 0.0);
            double coef2 = secondPolynomial.getOrDefault(i, 0.0);
            double sum = coef1 + coef2;
            polynomialAddition.put(i, sum);
        }
        return polynomialAddition;
    }

    public HashMap<Integer, Double> subtraction(HashMap<Integer,Double> firstPolynomial, HashMap<Integer,Double> secondPolynomial)
    {
        HashMap<Integer, Double> polynomialSubtraction = new HashMap<>();
        HashSet<Integer> allKeys = new HashSet<>();
        allKeys.addAll(firstPolynomial.keySet());
        allKeys.addAll(secondPolynomial.keySet());
        for (int i : allKeys)
        {
            double coef1 = firstPolynomial.getOrDefault(i, 0.0);
            double coef2 = secondPolynomial.getOrDefault(i, 0.0);
            double diff = coef1 - coef2;
            polynomialSubtraction.put(i, diff);
        }
        return polynomialSubtraction;
    }

    public HashMap<Integer, Double> multiplication(HashMap<Integer, Double> firstPolynomial, HashMap<Integer, Double> secondPolynomial)
    {
        HashMap<Integer, Double> polynomialMultiplication = new HashMap<>();
        for(int i : firstPolynomial.keySet())
        {
            for(int j : secondPolynomial.keySet())
            {
                double coef1 = firstPolynomial.getOrDefault(i, 0.0);
                double coef2 = secondPolynomial.getOrDefault(j, 0.0);
                double product = coef1 * coef2;
                int degree = i + j;
                polynomialMultiplication.put(degree, polynomialMultiplication.getOrDefault(degree, 0.0) + product);
            }
        }
        return polynomialMultiplication;
    }

    public HashMap<Integer, Double> integration(HashMap<Integer, Double> firstPolynomial)
    {
        List<Integer> keys = new ArrayList<>(firstPolynomial.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        HashMap<Integer, Double> polynomialIntegration = new HashMap<>();
        for (int i : keys)
        {
            if(i != 0)
                polynomialIntegration.put(i + 1, firstPolynomial.getOrDefault(i, 0.0) / (i + 1));
            else
                polynomialIntegration.put(i + 1,firstPolynomial.getOrDefault(i, 0.0));
        }
        return polynomialIntegration;
    }

    public HashMap<Integer, Double> derivation(HashMap<Integer, Double> firstPolynomial)
    {
        HashMap<Integer, Double> polynomialDerivation = new HashMap<>();
        for(int i : firstPolynomial.keySet())
        {
            if(i > 0)
                polynomialDerivation.put(i - 1, firstPolynomial.getOrDefault(i, 0.0) * i);
        }
        return polynomialDerivation;
    }

    public int degree(HashMap<Integer, Double> polynomial)
    {
        int maxDegree = 0;
        for (Integer degree : polynomial.keySet())
            if (degree > maxDegree)
                maxDegree = degree;
        return maxDegree;
    }

    private double leadingTerm(HashMap<Integer, Double> polynomial)
    {
        int leadExp = 0;
        double leadCoef = 0.0;
        for (Integer exponent : polynomial.keySet()) {
            double coefficient = polynomial.get(exponent);

            if (exponent > leadExp) {
                leadExp = exponent;
                leadCoef = coefficient;
            }
        }
        return leadCoef;
    }

    private HashMap<Integer, Double> removeZeroCoefficients(HashMap<Integer, Double> polynomial)
    {
        Iterator<Map.Entry<Integer, Double>> iterator = polynomial.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Double> entry = iterator.next();
            if (entry.getValue() == 0.0)
                iterator.remove();
        }
        return polynomial;
    }

    public HashMap<Integer, Double> division(HashMap<Integer, Double> dividend, HashMap<Integer, Double> divisor)
    {
        if (divisor.isEmpty() || divisor.values().stream().allMatch(coef -> coef == 0.0))
            throw new IllegalArgumentException("Division by zero polynomial");
        HashMap<Integer, Double> quotient = new HashMap<>();
        HashMap<Integer, Double> remainder = new HashMap<>(dividend);
        while (!remainder.isEmpty() && degree(remainder) >= degree(divisor))
        {
            double leadR = leadingTerm(remainder);
            double leadD = leadingTerm(divisor);
            double term = leadR / leadD;
            int expDiff = degree(remainder) - degree(divisor);
            quotient.put(expDiff, term);
            HashMap<Integer, Double> tempRemainder = new HashMap<>();
            for (int expR : remainder.keySet())
            {
                double coefR = remainder.get(expR);
                int expD = expR - expDiff;
                double coefD = divisor.containsKey(expD) ? divisor.get(expD) : 0.0;
                tempRemainder.put(expR, coefR - term * coefD);
            }
            remainder = removeZeroCoefficients(tempRemainder);
        }
        return quotient;
    }

    public HashMap<Integer, Double> remainder(HashMap<Integer, Double> dividend, HashMap<Integer, Double> divisor)
    {
        if (divisor.isEmpty() || divisor.values().stream().allMatch(coef -> coef == 0.0))
            throw new IllegalArgumentException("Division by zero polynomial");
        HashMap<Integer, Double> remainder = new HashMap<>(dividend);
        while (!remainder.isEmpty() && degree(remainder) >= degree(divisor))
        {
            double leadR = leadingTerm(remainder);
            double leadD = leadingTerm(divisor);
            double term = leadR / leadD;
            int expDiff = degree(remainder) - degree(divisor);
            HashMap<Integer, Double> tempRemainder = new HashMap<>();
            for (int expR : remainder.keySet())
            {
                double coefR = remainder.get(expR);
                int expD = expR - expDiff;
                double coefD = divisor.containsKey(expD) ? divisor.get(expD) : 0.0;
                tempRemainder.put(expR, coefR - term * coefD);
            }
            remainder = removeZeroCoefficients(tempRemainder);
        }
        return remainder;
    }

    public String polynomialToString(HashMap<Integer, Double> firstPolynomial) {
        StringBuilder polynomialString = new StringBuilder();
        int max = 0;
        for (Integer i : firstPolynomial.keySet()) {
            if(i > max)
                max = i;
        }
        List<Integer> keys = new ArrayList<>(firstPolynomial.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        for (int i : keys) {
            double coef = firstPolynomial.getOrDefault(i, 0.0);
            if (coef != 0) {
                if (coef > 0 && i < max)
                    polynomialString.append(" + ");
                else if (coef < 0) {
                    polynomialString.append(" - ");
                    coef = Math.abs(coef);
                }
                if(coef - (int)coef == 0)
                    polynomialString.append((int)coef);
                else
                    polynomialString.append(coef);
                if (i > 1)
                    polynomialString.append("*X^").append(i);
                else if(i >0)
                    polynomialString.append("*X");
            }
        }
        return polynomialString.toString();
    }

    public HashMap<Integer, Double> parsePolynomial(String polynomialString) {
        String termPattern = "([+-]?\\s?((\\d*\\.?\\d*\\s?\\*?\\s?[xX](\\^\\d+)?)|\\d*\\.?\\d+))";
        Pattern pattern = Pattern.compile(termPattern);
        Matcher matcher = pattern.matcher(polynomialString);
        HashMap<Integer, Double> polynomialMap = new HashMap<>();
        int sign = 1;
        while (matcher.find()) {
            String term = matcher.group().trim();
            int exponent = 0;
            double coefficient;
            if (term.startsWith("+")) {
                sign = 1;
                term = term.substring(1);
            } else if (term.startsWith("-")) {
                sign = -1;
                term = term.substring(1);
            }
            if (!term.isEmpty()) {
                String[] parts = term.split("\\*");
                if (parts.length > 1 || term.contains("x") || term.contains("X")) {
                    coefficient = parts.length == 2 ? Double.parseDouble(parts[0].trim()) : 1.0;
                    if (coefficient == 0.0)
                        continue;
                    exponent = parts[parts.length - 1].contains("^") ? Integer.parseInt(parts[parts.length - 1].split("\\^")[1]) : 1;
                } else {
                    coefficient = Double.parseDouble(term);
                    exponent = 0;
                }
                coefficient *= sign;
                polynomialMap.put(exponent, polynomialMap.getOrDefault(exponent, 0.0) + coefficient);
            }
        }
        return polynomialMap;
    }
}
