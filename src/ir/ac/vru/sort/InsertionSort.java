package ir.ac.vru.sort;

public class InsertionSort extends ComparableSort{

    public static void main(String[] args) {
        Integer[] array = getArray();

        System.out.println("Array before sort:");
        show(array);

        sort(array, new InsertionSort());
        assert isSorted(array);

        System.out.println("Array after sort:");
        show(array);
    }

    @Override
    protected void sort_(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
    }
}
