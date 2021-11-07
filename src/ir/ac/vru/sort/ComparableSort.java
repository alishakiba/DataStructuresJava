package ir.ac.vru.sort;

import java.util.Scanner;

public abstract class ComparableSort {
    // inplace sorting algorithm
    public static void sort(Comparable[] array, ComparableSort algorithm) {
        algorithm.sort_(array);
    }

    protected abstract void sort_(Comparable[] array);

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean isSorted(Comparable[] array) {
        for(int i = 1; i < array.length; i++) {
            if (less(array[i], array[i-1]))
                return false;
        }
        return true;
    }

    public static void show(Comparable[] array) {
        System.out.print("[ ");
        for(int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    protected static Integer[] getArray() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("How many integers do you want to enter?");
        n = sc.nextInt();
        Integer[] array = new Integer[n];
        System.out.println("Enter " + n + " integers:");
        for(int i = 0; i < n; ++i) {
            array[i] = sc.nextInt();
        }
        return array;
    }

}
