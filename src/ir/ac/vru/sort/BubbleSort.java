package ir.ac.vru.sort;

import java.util.Scanner;

public class BubbleSort extends ComparableSort {
    @Override
    protected void sort_(Comparable[] array) {
        for(int j = 1; j < array.length; ++j)
        {
            boolean changed = false;
            for (int i = 0; i < array.length - j; ++i) {
                if (less(array[i + 1], array[i])) {
                    exchange(array, i + 1, i);
                    changed = true;
                }
            }
            if (!changed) break;
        }
    }

    public static void main(String[] args) {
        Integer[] array = getArray();

        System.out.println("Array before sort:");
        show(array);

        sort(array, new BubbleSort());
        assert isSorted(array);

        System.out.println("Array after sort:");
        show(array);
    }

}
