package ir.ac.vru.sort;

public class SelectionSort extends ComparableSort {

    public static void main(String[] args) {
        Integer[] array = getArray();

        System.out.println("Array before sort:");
        show(array);

        sort(array, new SelectionSort());
        assert isSorted(array);

        System.out.println("Array after sort:");
        show(array);
    }

    @Override
    protected void sort_(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) {
//                if (array[j].compareTo(array[min_index]) < 0) {
                if (less(array[j], array[min_index])) {
                    min_index = j;
                }
            }
            exchange(array, i, min_index);
        }
    }
}
