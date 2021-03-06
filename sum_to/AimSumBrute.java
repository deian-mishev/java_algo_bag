package sum_to;

import java.util.ArrayList;
import java.util.function.Function;

import sum_to.interfaces.AimSum;
import sum_to.interfaces.SetCount;

public class AimSumBrute<Type, Accessor extends Function<Type, Double>> extends SetCount<Type, Accessor>
        implements AimSum<Type, Accessor, CountSets> {

    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSets count(Type[] a, int b, double aim, Accessor accessor) {
        this.accessor = accessor;
        this.a_len = a.length;
        this.aim = aim;
        this.arr_len = b;

        // n^b makes space complexity too big
        this.sets = new ArrayList<>();
        return new CountSets(this.sets, findWithSets(a, b, 0, 0, 0, new int[b]));
    }

    // TC: O((n-b)^b) (brute force)
    protected int findWithSets(Type[] a, int b, int pIndex, int count, double combinedValue, int[] arr) {
        for (int i = pIndex; i < a_len - (b - 1); i++) {
            arr[arr_len - b] = i;
            double val = accessor.apply(a[i]);
            if (b > 1) {
                count = findWithSets(a, b - 1, i + 1, count, combinedValue + val, arr);
            } else if (combinedValue + val == aim) {
                sets.add(arr.clone());
                count++;
            }
        }
        return count;
    }
}
