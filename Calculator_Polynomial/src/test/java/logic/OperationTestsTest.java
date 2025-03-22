package logic;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTestsTest
{
    private Operation operation = new Operation();
    @Test
    public void testAddition1()
    {
        HashMap<Integer, Double> polynomial1 = new HashMap<>();
        polynomial1.put(3, 3.0);
        polynomial1.put(2, 2.0);
        polynomial1.put(1, 1.0);
        polynomial1.put(0, 5.0);
        HashMap<Integer, Double> polynomial2 = new HashMap<>();
        polynomial2.put(3, 2.0);
        polynomial2.put(2, 3.0);
        polynomial2.put(1, 4.0);
        polynomial2.put(0, 1.0);
        HashMap<Integer, Double> expectedResult = new HashMap<>();
        expectedResult.put(3, 5.0);
        expectedResult.put(2, 5.0);
        expectedResult.put(1, 5.0);
        expectedResult.put(0, 6.0);
        HashMap<Integer, Double> result = operation.addition(polynomial1, polynomial2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testAddition2()
    {
        HashMap<Integer, Double> polynomial1 = new HashMap<>();
        polynomial1.put(3, 1.0);
        polynomial1.put(2, 2.0);
        polynomial1.put(1, 3.0);
        polynomial1.put(0, 4.0);
        HashMap<Integer, Double> polynomial2 = new HashMap<>();
        polynomial2.put(3, 2.0);
        polynomial2.put(2, 3.0);
        polynomial2.put(1, 4.0);
        polynomial2.put(0, 5.0);
        HashMap<Integer, Double> expectedResult = new HashMap<>();
        expectedResult.put(3, 3.0);
        expectedResult.put(2, 5.0);
        expectedResult.put(1, 7.0);
        expectedResult.put(0, 9.0);
        HashMap<Integer, Double> result = operation.addition(polynomial1, polynomial2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testSubtraction1()
    {
        HashMap<Integer, Double> polynomial1 = new HashMap<>();
        polynomial1.put(3, 3.0);
        polynomial1.put(2, 2.0);
        polynomial1.put(1, 1.0);
        polynomial1.put(0, 5.0);
        HashMap<Integer, Double> polynomial2 = new HashMap<>();
        polynomial2.put(3, 2.0);
        polynomial2.put(2, 3.0);
        polynomial2.put(1, 4.0);
        polynomial2.put(0, 1.0);
        HashMap<Integer, Double> expectedResult = new HashMap<>();
        expectedResult.put(3, 1.0);
        expectedResult.put(2, -1.0);
        expectedResult.put(1, -3.0);
        expectedResult.put(0, 4.0);
        HashMap<Integer, Double> result = operation.subtraction(polynomial1, polynomial2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testSubtraction2()
    {
        HashMap<Integer, Double> polynomial1 = new HashMap<>();
        polynomial1.put(3, 5.0);
        polynomial1.put(2, 4.0);
        polynomial1.put(1, 3.0);
        polynomial1.put(0, 2.0);
        HashMap<Integer, Double> polynomial2 = new HashMap<>();
        polynomial2.put(3, 3.0);
        polynomial2.put(2, 2.0);
        polynomial2.put(1, 1.0);
        HashMap<Integer, Double> expectedResult = new HashMap<>();
        expectedResult.put(3, 2.0);
        expectedResult.put(2, 2.0);
        expectedResult.put(1, 2.0);
        expectedResult.put(0, 2.0);
        HashMap<Integer, Double> result = operation.subtraction(polynomial1, polynomial2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testMultiplication1()
    {
        HashMap<Integer, Double> polynomial1 = new HashMap<>();
        polynomial1.put(2, 2.0);
        polynomial1.put(1, 3.0);
        polynomial1.put(0, 4.0);
        HashMap<Integer, Double> polynomial2 = new HashMap<>();
        polynomial2.put(1, 1.0);
        polynomial2.put(0, 1.0);
        HashMap<Integer, Double> expectedResult = new HashMap<>();
        expectedResult.put(3, 2.0);
        expectedResult.put(2, 5.0);
        expectedResult.put(1, 7.0);
        expectedResult.put(0, 4.0);
        HashMap<Integer, Double> result = operation.multiplication(polynomial1, polynomial2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testMultiplication2()
    {
        HashMap<Integer, Double> polynomial1 = new HashMap<>();
        polynomial1.put(3, 1.0);
        polynomial1.put(2, 2.0);
        polynomial1.put(1, 1.0);
        HashMap<Integer, Double> polynomial2 = new HashMap<>();
        polynomial2.put(2, -2.0);
        polynomial2.put(1, -3.0);
        polynomial2.put(0, -4.0);
        HashMap<Integer, Double> expectedResult = new HashMap<>();
        expectedResult.put(5, -2.0);
        expectedResult.put(4, -7.0);
        expectedResult.put(3, -12.0);
        expectedResult.put(2, -11.0);
        expectedResult.put(1, -4.0);
        HashMap<Integer, Double> result = operation.multiplication(polynomial1, polynomial2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testDivision1()
    {
        HashMap<Integer, Double> dividend = new HashMap<>();
        dividend.put(3, 2.0);
        dividend.put(2, 1.0);
        dividend.put(1, -3.0);
        dividend.put(0, 5.0);
        HashMap<Integer, Double> divisor = new HashMap<>();
        divisor.put(1, 1.0);
        divisor.put(0, -1.0);
        HashMap<Integer, Double> expectedQuotient = new HashMap<>();
        expectedQuotient.put(2, 2.0);
        expectedQuotient.put(1, 3.0);
        HashMap<Integer, Double> expectedRemainder = new HashMap<>();
        expectedRemainder.put(0, 5.0);
        HashMap<Integer, Double> result = operation.division(dividend, divisor);
        assertEquals(expectedQuotient, result);
        HashMap<Integer, Double> result2 = operation.remainder(dividend, divisor);
        assertEquals(expectedRemainder, result2);
    }
    @Test
    public void testDivision2()
    {
        HashMap<Integer, Double> dividend = new HashMap<>();
        dividend.put(3, 1.0);
        dividend.put(2, -2.0);
        dividend.put(1, 6.0);
        dividend.put(0, -5.0);
        HashMap<Integer, Double> divisor = new HashMap<>();
        divisor.put(2, 1.0);
        divisor.put(0, -1.0);
        HashMap<Integer, Double> expectedQuotient = new HashMap<>();
        expectedQuotient.put(1, 1.0);
        expectedQuotient.put(0, -2.0);
        HashMap<Integer, Double> expectedRemainder = new HashMap<>();
        expectedRemainder.put(1, 7.0);
        expectedRemainder.put(0, -7.0);
        HashMap<Integer, Double> result = operation.division(dividend, divisor);
        assertEquals(expectedQuotient, result);
        HashMap<Integer, Double> result2 = operation.remainder(dividend, divisor);
        assertEquals(expectedRemainder, result2);
    }
    @Test
    public void testDerivation1()
    {
        HashMap<Integer, Double> polynomial = new HashMap<>();
        polynomial.put(3, 3.0);
        polynomial.put(2, 2.0);
        polynomial.put(1, -1.0);
        polynomial.put(0, 5.0);
        HashMap<Integer, Double> expectedDerivative = new HashMap<>();
        expectedDerivative.put(2, 9.0);
        expectedDerivative.put(1, 4.0);
        expectedDerivative.put(0, -1.0);
        HashMap<Integer, Double> result = operation.derivation(polynomial);
        assertEquals(expectedDerivative, result);
    }
    @Test
    public void testDerivation2()
    {
        HashMap<Integer, Double> polynomial = new HashMap<>();
        polynomial.put(4, 1.0);
        polynomial.put(3, -4.0);
        polynomial.put(2, 3.0);
        polynomial.put(1, 2.0);
        polynomial.put(0, -7.0);
        HashMap<Integer, Double> expectedDerivative = new HashMap<>();
        expectedDerivative.put(3, 4.0);
        expectedDerivative.put(2, -12.0);
        expectedDerivative.put(1, 6.0);
        expectedDerivative.put(0, 2.0);
        HashMap<Integer, Double> result = operation.derivation(polynomial);
        assertEquals(expectedDerivative, result);
    }
    @Test
    public void testIntegration1()
    {
        HashMap<Integer, Double> polynomial = new HashMap<>();
        polynomial.put(3, 3.0);
        polynomial.put(2, 2.0);
        polynomial.put(1, -1.0);
        polynomial.put(0, 5.0);
        HashMap<Integer, Double> expectedIntegration = new HashMap<>();
        expectedIntegration.put(4, 3.0 / 4.0);
        expectedIntegration.put(3, 2.0 / 3.0);
        expectedIntegration.put(2, -0.5);
        expectedIntegration.put(1, 5.0);
        HashMap<Integer, Double> result = operation.integration(polynomial);
        assertEquals(expectedIntegration, result);
    }
    @Test
    public void testIntegration2()
    {
        HashMap<Integer, Double> polynomial = new HashMap<>();
        polynomial.put(2, 2.0);
        polynomial.put(1, -4.0);
        polynomial.put(0, 7.0);
        HashMap<Integer, Double> expectedIntegration = new HashMap<>();
        expectedIntegration.put(3, 2.0/3.0);
        expectedIntegration.put(2, -2.0);
        expectedIntegration.put(1, 7.0);
        HashMap<Integer, Double> result = operation.integration(polynomial);
        assertEquals(expectedIntegration, result);
    }
    @Test
    public void testPolynomialParsing1()
    {
        String polynomialString = "3*x^2 + 2*x + 5";
        HashMap<Integer, Double> expectedPolynomial = new HashMap<>();
        expectedPolynomial.put(2, 3.0);
        expectedPolynomial.put(1, 2.0);
        expectedPolynomial.put(0, 5.0);
        HashMap<Integer, Double> parsedPolynomial = operation.parsePolynomial(polynomialString);
        assertEquals(expectedPolynomial, parsedPolynomial);
    }
}