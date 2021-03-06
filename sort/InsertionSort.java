package sort;

import java.util.Comparator;

import sort.interfaces.SortAbst;

public class InsertionSort<T> extends SortAbst<T> {

    public void sort(T[] a, int lo, int hi, Comparator<? super T> b) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo; j--)
                if (less(a[j], a[j - 1], b))
                    swap(a, j, j - 1);
                else
                    break;
        }
    }

    private void printSort(T[] a, Comparator<? super T> b) {
        int N = a.length;
        System.out.println();
        System.out.print(" j");
        for (int i = 0; i < N; i++) {
            System.out.print("  " + i);
        }
        System.out.println();
        System.out.println("i ");

        for (int i = 0; i < N; i++) {
            System.out.print(i + (i >= 10 ? "  " : "   "));
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1], b)) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
            for (int n = 0; n < N; n++) {
                if (n == i) {
                    System.out.print("x  ");
                } else {
                    System.out.print(a[n] + (a[n].toString().length() >= 1 ? " " : "  "));
                }
                System.out.print(n >= 10 ? " " : "");
            }
            System.out.println();
        }
        System.out.println();
    }
}
