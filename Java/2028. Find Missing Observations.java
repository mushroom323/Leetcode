package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = (rolls.length + n) * mean, curSum = Arrays.stream(rolls).sum();
        int diff = sum - curSum;
        System.out.println(diff);
        List<Integer> arr = new ArrayList<Integer>(); 
        int pro = diff / n;
        if (pro > 6 || (pro == 6 && (diff - (pro * n)) != 0) || pro <= 0) return arr.stream().mapToInt(Integer::valueOf).toArray();
        else {
            int num = (diff - (pro * n)) == 0 ? n : (n - (diff - (pro * n)));
            for (int i = 0; i < num; i++) {
                arr.add(pro);
            }
            for (int i = 0; i < (diff - (pro * n)); i++) {
                arr.add(pro + 1);
            }
        }
        System.out.println(Arrays.stream(arr.stream().mapToInt(Integer::valueOf).toArray()).sum());
        return arr.stream().mapToInt(Integer::valueOf).toArray();
    }
}