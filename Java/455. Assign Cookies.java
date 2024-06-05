package Java;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if (s.length == 0) return 0;
        int count = 0;
        int fed = 0;
        for (int i = 0; i < g.length; i++) {
            while (s[count] < g[i]) {
                count++;
                if (count >= s.length) break;
            }
            if (count >= s.length) break;
            count++;
            fed++; 
            if (count >= s.length) break;
        }
        return fed;
    }
}