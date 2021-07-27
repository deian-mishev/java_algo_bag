package service;

import sort.interfaces.Sort;
import util.RandomUtils;
import util.StdInReader;
import sort.InsertionSort;
import sort.SelectSort;
import sort.ShellSort;
import sort.MergeSort;
import sort.BogoSort;
import sort.BogoSort;
import sort.QuickSort;

import java.util.Comparator;

import comparator.ComparableComparator;

public class SortService {
    public static void main(String[] args) {

        Comparator<Integer> b = new ComparableComparator<>();
        Sort<Integer> sr = new QuickSort<>();

        // sr = new InsertionSort<>();
        // sr = new SelectSort<>();
        // sr = new ShellSort<>();
        // sr = new MergeSort<>();
        // sr = new BogoSort<>();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        Integer[] N = RandomUtils.randIntArray(1000, 0, 1000);
        Integer[] R = N.clone();

        long start = System.nanoTime();
        for (int i = 0; i < N.length; i++) {
            sr.sort(N, 0, N.length, b);
            if (!sr.isSorted(N, 0, N.length, b)) {
                System.out.println("Not Sorted");
                return;
            }
            N = R.clone();
        }
        System.out.printf("Sort of %d elements sorted in %d ns.%n", N.length, System.nanoTime() - start);
    }
}