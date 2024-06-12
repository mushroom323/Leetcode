package Java;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> myset = new HashSet<Integer>();
        myset.add(n);
        while (n != 1) {
            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = tmp;
            System.out.println(n);
            if (myset.contains(n)) return false;
            else myset.add(n);
        }
        return true;
    }
}