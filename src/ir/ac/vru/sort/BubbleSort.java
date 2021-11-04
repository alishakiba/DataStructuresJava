package ir.ac.vru.sort;

public class BubbleSort extends ComparableSort {
    @Override
    protected void sort_(Comparable[] array) {
        for(int j = 1; j < array.length; ++j)
        {
            for (int i = 0; i < array.length - j; ++i) {
                if (less(array[i + 1], array[i])) {
                    exchange(array, i + 1, i);
                }
            }
        }
    }
}
