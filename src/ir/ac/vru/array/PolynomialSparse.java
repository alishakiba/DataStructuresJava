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
        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data[0].length; ++j) {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new PolynomialSparse(this);
    }

    @Override
    public String toString() {
        // TODO: implement this
        return null;
    }

    public PolynomialSparse(int numOfNonZeroCoefficients) {
        this.numOfNonZeroCoefficients = numOfNonZeroCoefficients;
        if (this.numOfNonZeroCoefficients != 0) {
            this.data = new double[2][this.numOfNonZeroCoefficients];
            this.degree = -1; // not known
            this.top = 0;
        } else {
            this.degree = 0;
            this.top = 0;
            this.data = null;
        }
    }

    public boolean addPair_unsorted(int power, double coefficient) {
        // searching whether the power exists in the data
        int index = -1;
        for (int i = 0; i < this.top; ++i) {
            if (this.data[0][i] == power) {
                // we found it
                index = i;
                break;
            }
        }
        if (index >= 0) {
            this.data[1][index] = coefficient;
            return true;
        } else if (this.top < this.numOfNonZeroCoefficients) {
            // that is the array can hold another pair
            this.data[0][this.top] = power;
            this.data[1][this.top] = coefficient;
            this.top++;
            if (this.degree < power) {
                // updating the degree
                this.degree = power;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean addPair_sorted(int power, double coefficient) {
        // finding where this element should go
        // TODO: replace this with binary search
        int i = 0;
        while (i < this.top && this.data[0][i] <= power) {
            ++i;
        }
        if (this.data[0][i-1] == power) {
            this.data[1][i-1] = coefficient;
            return true;
        } else if (this.top < this.numOfNonZeroCoefficients) {
            // that is the array can hold another pair
            for (int j = this.top; j > i; --j) {
                data[0][j] = data[0][j - 1];
                data[1][j] = data[1][j - 1];
            }
            data[0][i] = power;
            data[1][i] = coefficient;
            this.top++;
            if (this.degree < power) {
                this.degree = power;
            }
            return true;
        } else {
            return false;
        }
    }

    protected double[][] getData() {
        return this.data;
    }

    public double getCoefficient_unsorted(int degree) {
        for (int i = 0; i < this.top; ++i) {
            if (data[0][i] == degree) {
                return data[1][i];
            }
        }
        // we could not find it, so it is zero for sure
        return 0;
    }

    public double getCoefficient_sorted(int degree) {
        boolean found = false;
        int left = 0;
        int right = this.top;
        int middle = (left + right) / 2;
        while (left < right) {
            if (this.data[0][middle] == degree) {
                found = true;
                break;
            } else if (this.data[0][middle] < degree) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            // updating the middle
            middle = (left + right) / 2;
        }
        if (found) {
            return data[1][middle];
        } else {
            return 0;
        }
    }

    public int getDegree() {
        return this.degree;
    }

    public static PolynomialSparse add_unsorted(PolynomialSparse p, PolynomialSparse q) {
        // upper bound on the # of nonzero coefficients equals p.numOfNonZeroCoefficients + q.numOfNonZeroCoefficients
        double[][] r_data = new double[2][p.numOfNonZeroCoefficients + q.numOfNonZeroCoefficients];
        int r_top = 0;
        int r_degree = 0;
        // adding the coefficients with the same degree
        // O(N^2)
        for (int i = 0; i < p.top; i++) {
            int degree = (int) p.data[0][i];
            boolean found_in_q = false;
            for (int j = 0; j < q.top; j++) {
                if (degree == (int) q.data[0][j]) {
                    double p_coeff = p.data[1][i];
                    double q_coeff = q.data[1][j];
                    if (p_coeff + q_coeff != 0) {
                        r_data[0][r_top] = degree;
                        r_data[1][r_top] = p_coeff + q_coeff;
                        r_top++;
                        if (r_degree < degree) {
                            r_degree = degree;
                        }
                    }
                    // else, nothing to do since it is zero and should not appear in the data array
                    found_in_q = true;
                    break; // no need for further search
                }
            }
            if (!found_in_q) {
                // this degree is present in p, but not in the q
                r_data[0][r_top] = degree;
                r_data[1][r_top] = p.data[1][i];
                r_top++;
                // taking care of the r degree
                if (r_degree < degree) {
                    r_degree = degree;
                }
            }
        }
        // now, it is time for the powers in the q
        // O(N^2)
        for (int i = 0; i < q.top; i++) {
            int degree = (int) q.data[0][i];
            boolean found_in_p = false;
            for (int j = 0; j < p.top; j++) {
                if (degree == (int) p.data[0][j]) {
                    found_in_p = true;
                    break;
                }
            }
            if (!found_in_p) {
                // so, we need to consider it
                r_data[0][r_top] = degree;
                r_data[1][r_top] = q.data[1][i];
                r_top++;
                if (r_degree < degree) {
                    r_degree = degree;
                }
            }
        }
        // O(N)
        return new PolynomialSparse(r_data);
    }

    public static PolynomialSparse add_sorted(PolynomialSparse p, PolynomialSparse q) {
        if (p.numOfNonZeroCoefficients + q.numOfNonZeroCoefficients == 0) {
            return new PolynomialSparse(0);
        }
        // upper bound on the # of nonzero coefficients equals p.numOfNonZeroCoefficients + q.numOfNonZeroCoefficients
        double[][] r_data = new double[2][p.numOfNonZeroCoefficients + q.numOfNonZeroCoefficients];
        int r_top = 0;
        int r_degree = 0;
        // adding the coefficients with the same degree
        int current_p = 0;
        int current_q = 0;
        while (current_p < p.top && current_q < q.top) {
            if (p.data[0][current_p] == q.data[0][current_q]) {
                // the coefficients are of the same degree
                double p_coef = p.data[1][current_p];
                double q_coef = q.data[1][current_q];
                if (p_coef + q_coef != 0) {
                    r_data[0][r_top] = p.data[0][current_p];
                    r_data[1][r_top] = p_coef + q_coef;
                    r_top++;
                    if (r_degree < p.data[0][current_p]) {
                        r_degree = (int) p.data[0][current_p];
                    }
                }
                current_p++;
                current_q++;
            } else if (p.data[0][current_p] < q.data[0][current_q]) {
                // advancing on the p
                r_data[0][r_top] = p.data[0][current_p];
                r_data[1][r_top] = p.data[1][current_p];
                r_top++;
                if (r_degree < p.data[0][current_p]) {
                    r_degree = (int) p.data[0][current_p];
                }
                current_p++;
            } else {
                // advanding on the q
                r_data[0][r_top] = q.data[0][current_q];
                r_data[1][r_top] = q.data[1][current_q];
                r_top++;
                if (r_degree < q.data[0][current_q]) {
                    r_degree = (int) q.data[0][current_q];
                }
                current_q++;
            }
        }
        // TODO: copy the rest of the elements from P or Q to R
        if (current_p < p.top) {
            // there are remaining elements in p
            for(int i = current_p; i < p.top; ++i) {
                r_data[0][r_top] = p.data[0][i];
                r_data[1][r_top] = p.data[1][i];
                r_top++;
                if (r_degree < p.data[0][i]) {
                    r_degree = (int) p.data[0][i];
                }
            }
        } else if (current_q < q.top) {
            // there are remaining elements in q
            for(int i = current_q; i < q.top; ++i) {
                r_data[0][r_top] = q.data[0][i];
                r_data[1][r_top] = q.data[1][i];
                r_top++;
                if (r_degree < q.data[0][i]) {
                    r_degree = (int) q.data[0][i];
                }
            }
        }
        return new PolynomialSparse(r_data);
    }

    public static PolynomialSparse add_sorted_memory_efficient(PolynomialSparse p, PolynomialSparse q) {
        //
        int r_non_zero_elements = 0;
        int current_p = 0;
        int current_q = 0;
        while (current_p < p.top && current_q < q.top) {
            //
            if (p.data[0][current_p] == q.data[0][current_q]) {
                if (p.data[1][current_p] + q.data[1][current_q] != 0) {
                    r_non_zero_elements++;
                    current_q++;
                    current_p++;
                } else if (p.data[0][current_p] < q.data[0][current_q]) {
                    current_p++;
                    r_non_zero_elements++;
                } else {
                    current_q++;
                    r_non_zero_elements++;
                }
            }
        }
        // upper bound on the # of nonzero coefficients equals p.numOfNonZeroCoefficients + q.numOfNonZeroCoefficients
        double[][] r_data = new double[2][r_non_zero_elements];
        int r_top = 0;
        int r_degree = 0;
        // adding the coefficients with the same degree
        current_p = 0;
        current_q = 0;
        while (current_p < p.top && current_q < q.top) {
            if (p.data[0][current_p] == q.data[0][current_q]) {
                // the coefficients are of the same degree
                double p_coef = p.data[1][current_p];
                double q_coef = q.data[1][current_q];
                if (p_coef + q_coef != 0) {
                    r_data[0][r_top] = p.data[0][current_p];
                    r_data[1][r_top] = p_coef + q_coef;
                    r_top++;
                    if (r_degree < p.data[0][current_p]) {
                        r_degree = (int) p.data[0][current_p];
                    }
                }
                current_p++;
                current_q++;
            } else if (p.data[0][current_p] < q.data[0][current_q]) {
                // advancing on the p
                r_data[0][r_top] = p.data[0][current_p];
                r_data[1][r_top] = p.data[1][current_p];
                r_top++;
                if (r_degree < p.data[0][current_p]) {
                    r_degree = (int) p.data[0][current_p];
                }
                current_p++;
            } else {
                // advanding on the q
                r_data[0][r_top] = q.data[0][current_q];
                r_data[1][r_top] = q.data[1][current_q];
                r_top++;
                if (r_degree < q.data[0][current_q]) {
                    r_degree = (int) q.data[0][current_q];
                }
                current_q++;
            }
        }
        return new PolynomialSparse(r_data);
    }

    public static PolynomialSparse sub(PolynomialSparse p, PolynomialSparse q) {
        return null;
    }

    public static PolynomialSparse mul(PolynomialSparse p, PolynomialSparse q) {
        return null;
    }

    public static PolynomialSparse div(PolynomialSparse p, PolynomialSparse q) {
        return null;
    }

    public static PolynomialSparse mod(PolynomialSparse p, PolynomialSparse q) {
        return null;
    }

    public static PolynomialSparse negate(PolynomialSparse p) {
        return null;
    }

    public Polynomial toDense() {
        return null;
    }

}
