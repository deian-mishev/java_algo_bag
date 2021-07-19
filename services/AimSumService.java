package services;

import java.util.Arrays;

import sum_to.AimSum;
import sum_to.AimSumBrute;
import sum_to.AimSumCount;
import sum_to.AimSumImproved;
import utils.CountSetsPojo;
import utils.StdInReader;

public class AimSumService {
    public static void main(String[] args) {
        // AimSum ts = new AimSumCount();
        // AimSum ts = new AimSumBrute();
        AimSum ts = new AimSumImproved();
        System.out.println("Init array of ints ..");
        int[] N = StdInReader.readIntArray();
        // int[] N = new int[] { 0, -1, 1, 0, 0, 5, 0, 1, 3 };

        System.out.println("Init amount of elements to add for result ..");
        int B = StdInReader.readInt();
        // int B = 9;

        System.out.println("Init aim result ..");
        int C = StdInReader.readInt();
        // int C = 0;
        long start = System.nanoTime();
        CountSetsPojo res = ts.count(N, B, C);
        for (int i = 0; i < 10000; i++) {
            res = ts.count(N, B, C);
        }
        System.out.printf("Count : %d for %d ns.%n", res.getCount(), System.nanoTime() - start);
        for (int[] i : res.getSets()) {
            System.out.println(Arrays.toString(i));
        }
    }
}