package Java;

import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> mymap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (mymap.containsKey(c)) {
                mymap.put(c, mymap.get(c) + 1);
            } else {
                mymap.put(c, 1);
            }
        }
        int ans = 0;
        boolean is = false;
        for (Integer cur : mymap.values()) {
            if (cur % 2 == 1) is = true;
            ans += (cur - cur % 2);
        }
        return is ? ans + 1 : ans;
    }
}