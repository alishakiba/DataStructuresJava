package ir.ac.vru.sort;

public class MergeSort extends ComparableSort {

    @Override
    protected void sort_(Comparable[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(Comparable[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(Comparable[] array, int low, int mid, int high) {
        Comparable[] temp = new Comparable[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (less(array[i],array[j])) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        for (i = 0; i < temp.length; i++) {
            array[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Integer[] array = getArray();

        System.out.println("Array before sort:");
        show(array);

        sort(array, new MergeSort());
        assert isSorted(array);

        System.out.println("Array after sort:");
        show(array);
    }
}
