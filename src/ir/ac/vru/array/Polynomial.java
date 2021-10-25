package ir.ac.vru.array;

import java.util.Arrays;

public class Polynomial {
    private double[] coefficient; // coefficients p(x)=\sum { coefficient[i] * x^i }
    private int degree; // degree of polynomial (-1 means that P(x)=0)

    public Polynomial(int degree, double default_coefficient) {
        this.degree = degree;
        this.coefficient = new double[this.degree+1];
//        for(int i = 0; i < this.coefficient.length; ++i) {
//            this.coefficient[i] = default_coefficient;
//        }
        Arrays.fill(this.coefficient, default_coefficient);
    }

    public Polynomial(int degree) {
        this(degree, 0);
    }

    public Polynomial(double[] coefficient) {
        this.coefficient = new double[coefficient.length];
        this.degree = this.coefficient.length - 1;
        for(int i = 0; i < this.coefficient.length; ++i) {
            this.coefficient[i] = coefficient[i];
        }
    }

    public Polynomial(Polynomial p) {
//        this.degree = p.getDegree();
//        this.coefficient = new double[this.degree + 1];
//        for(int i = 0; i < this.coefficient.length; ++i) {
//            this.coefficient[i] = p.getCoefficient(i);
//        }
        this(p.getCoefficients());
    }

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int degree) {
        if (this.degree < degree) {
            double [] old_coefficient = this.coefficient;
            this.coefficient = new double[degree + 1];
            for(int i = 0; i < old_coefficient.length; ++i) {
                this.coefficient[i] = old_coefficient[i];
            }
            for(int i = old_coefficient.length; i < this.coefficient.length; ++i) {
                this.coefficient[i] = 0;
            }
            this.degree = degree;
            old_coefficient = null;
        }
        else if (this.degree > degree) {
            double [] old_coefficient = this.coefficient;
            this.coefficient = new double[degree + 1];
            for(int i = 0; i < coefficient.length; ++i) {
                this.coefficient[i] = old_coefficient[i];
            }
        }
    }

    public double getCoefficient(int i) {
        return this.coefficient[i];
    }

    public double[] getCoefficients() {
        return coefficient;
    }

    public void setCoefficient(int i, double coefficient) {
        this.coefficient[i] = coefficient;
    }

    public static Polynomial add(Polynomial p, Polynomial q) {
//        Polynomial r = new Polynomial(p.getDegree() > q.getDegree() ? p.getDegree() : q.getDegree());
        Polynomial r = new Polynomial(Math.max(p.getDegree(),q.getDegree()));
        for(int i = 0; i <= p.getDegree(); ++i) {
//            r.setCoefficient(i, p.getCoefficient(i));
            r.coefficient[i] = p.coefficient[i];
        }
        for(int i = 0; i <= q.degree; ++i) {
            r.coefficient[i] += q.coefficient[i];
        }
        r.reduce();
        return r;
    }

    private void reduce() {
        int degree = -1;
        for(int i = this.coefficient.length - 1; i >= 0; i--) {
            if (this.coefficient[i] != 0) {
                degree = i;
                break;
            }
        }
        if (degree != this.degree && degree >= 0)
        {
            double[] old_coefficient = this.coefficient;
            this.coefficient = new double[degree + 1];
            this.degree = degree;
            for (int i = 0; i < this.coefficient.length; ++i) {
                this.coefficient[i] = old_coefficient[i];
            }
        }
        else if (degree != this.degree && degree < 0) {
//            this.coefficient = new double[1];
            this.coefficient = null;
            this.degree = degree;
        }
    }

    public static Polynomial negate(Polynomial p) { return null; }

    public static Polynomial sub(Polynomial p, Polynomial q) {
        return null;
    }

    public static Polynomial div(Polynomial p, Polynomial q) {
        return null;
    }

    public static Polynomial mul(Polynomial p, Polynomial q) {
        return null;
    }

    public static Polynomial mod(Polynomial p, Polynomial q) {
        return null;
    }

}
