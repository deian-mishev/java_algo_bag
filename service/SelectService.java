package service;

import misc.RandomUtils;
import misc.StdInReader;
import misc.pojo.Point2D;
import search.BinarySearch;
import search.Search;
import select.QuickSelect;
import select.interfaces.Select;
import sort.InsertionSort;
import sort.QuickSort;

public class SelectService {
    public static void main(String[] args) {

        Select<Point2D> sl = new QuickSelect<>();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        final int COUNT = 100000;
        final int LOOKING_FOR = 0;

        Point2D[] N = new Point2D[COUNT];

        final Integer[] ARR = RandomUtils.randIntArray(COUNT, 0, 10000);
        final Integer[] ARR_Y = RandomUtils.randIntArray(COUNT, 0, 10000);

        for (int i = 0; i < COUNT; i++) {
            N[i] = new Point2D(ARR[i], ARR_Y[i]);
        }

        new QuickSort<Point2D>(20, new InsertionSort<>()).sort(N, 0, N.length, Point2D.X_ACCESSOR);

        Search<Point2D> bs = new BinarySearch<>();
        int l = bs.first(N, 0, COUNT - 1, N[LOOKING_FOR], Point2D.X_COMP);
        int r = bs.last(N, 0, COUNT - 1, N[LOOKING_FOR], Point2D.X_COMP);
        for (int i = l; i <= r; i++) {
            System.out.println(N[i]);
        }
        RandomUtils.shuffle(N);

        long start = System.nanoTime();
        System.out.printf("Select of %s element done in %d ns.%n", sl.select(N, Point2D.X_COMP, LOOKING_FOR),
                System.nanoTime() - start);
    }
}