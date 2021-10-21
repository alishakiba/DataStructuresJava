package ir.ac.vru.array;

public class PolynomialSparse {
    /**
     * data is a 2D array, data[0] holds the degree and data[1] holds the corresponding coefficients
     */
    protected double[][] data;
    protected int degree;
    protected int numOfNonZeroCoefficients;
    protected int top; // the next empty place in the data array

    public PolynomialSparse(double[][] data) {
        this.data = new double[data.length][data[0].length];
        this.degree = -1;
        for(int i = 0; i < data.length; ++i) {
            for(int j = 0; j < data[0].length; ++j) {
                this.data[i][j] = data[i][j];
                if (i == 0 && this.data[i][j] > this.degree) {
                    this.degree = (int) this.data[i][j];
                }
            }
        }
        this.numOfNonZeroCoefficients = this.data[0].length;
        this.top = data[0].length;
    }

    public PolynomialSparse(PolynomialSparse ps) {
        // TODO: Exercise
    }

    public PolynomialSparse(int numOfNonZeroCoefficients) {
        this.numOfNonZeroCoefficients = numOfNonZeroCoefficients;
        this.data = new double[2][this.numOfNonZeroCoefficients];
        this.degree = -1; // not known
        this.top = 0;
    }

    public boolean addPair(int power, double coefficient) {
        if (this.top < this.numOfNonZeroCoefficients) {
            // that is the array can hold another pair
            this.data[0][this.top] = power;
            this.data[1][this.top] = coefficient;
            this.top++;
            return true;
        }
        else {
            return false;
        }
    }
}
