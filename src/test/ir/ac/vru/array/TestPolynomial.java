package test.ir.ac.vru.array;

import ir.ac.vru.array.Polynomial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPolynomial {
    @Test
    @DisplayName("Testing summation of two polynomials of different degrees")
    public void testPolynomialAddDifferntDegrees() {
        Polynomial p = new Polynomial(new double[] {1,0,0,-1,5,4.5,3}); // 1 - x^3 + 5x^4 + 4.5x^5 + 3x^6
        Polynomial q = new Polynomial(new double[] {-1,0,1,0,0,2}); // -1 + x^2 + 2x^5
        Polynomial p_plus_q = new Polynomial(new double[] {0,0,1,-1,5,6.5,3}); // x^2 - x^3 + 5x^4 + 6.5x^5 + 3x^6

        Polynomial r = Polynomial.add(p, q);

        assertEquals(p_plus_q.getDegree(), r.getDegree(), "Not of the same degree");
        for(int i = 0; i <= r.getDegree(); ++i) {
            assertEquals(p_plus_q.getCoefficient(i), r.getCoefficient(i), String.format("Coefficient %d is not equal.", i));
        }
        assertArrayEquals(p_plus_q.getCoefficients(), r.getCoefficients(), "Coefficients are not equal");
    }

    @Test
    @DisplayName("Testing summation of a polynomial with its negative")
    public void testPolynomialAddPwithNegativeP() {

    }

    @Test
    @DisplayName("Testing summation of two polynomials of the same degree with result of zero")
    public void testPolynomialAddResultZero() {

    }

    @Test
    @DisplayName("Testing copy constructor")
    public void testPolynomialAdd() {

    }
}
