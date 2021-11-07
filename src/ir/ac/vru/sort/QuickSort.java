package ir.ac.vru.sort;

public class QuickSort extends ComparableSort {
    @Override
    protected void sort_(Comparable[] array) {
        // quicksort algorithm
        quick_sort(array, 0, array.length - 1);
    }

    protected static void quick_sort(Comparable[] array, int left, int right) {
        if (left < right) {
            int q = partition(array, left, right);
            quick_sort(array, left, q - 1);
            quick_sort(array, q + 1, right);
        }
    }

    protected static int partition(Comparable[] array, int left, int right) {
        // the last element of the array is the pivot
        Comparable x = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (less(array[j], x)) {
                i++;
                exchange(array, i, j);
            }
        }
        exchange(array, i + 1, right);
        return i + 1;
    }

    public static void main(String[] args) {
        Integer[] array = getArray();

        System.out.println("Array before sort:");
        show(array);

        sort(array, new QuickSort());
        assert isSorted(array);

        System.out.println("Array after sort:");
        show(array);
    }
}
