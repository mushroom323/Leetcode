package Java;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int[] pre = new int[101];
        Arrays.fill(pre, 1);
        prePrime(pre, 100);
        int l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (pre[nums[i]] == 1) {
                if (r == -1) {
                    r = i;
                    l = i;
                } else r = i;
            }
        }
        return r - l;
    }

    // 埃氏筛法
    public void prePrime(int[] pre, int n) {
        pre[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (pre[i] == 1) {
                for (int j = 2; i * j <= n; j++)  {
                    pre[i * j] = 0;
                }
            }
        }
    }
}