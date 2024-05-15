package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> mymap = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            if (!mymap.containsKey(s.charAt(i))) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                tmp.add(1);
                mymap.put(s.charAt(i), tmp);
            } else {
                List<Integer> tmp = mymap.get(s.charAt(i));
                tmp.set(1, tmp.get(1) + 1);
                mymap.put(s.charAt(i), tmp);
            }
        }
        int ans = 100005;
        for (Character key : mymap.keySet()) {
            if (mymap.get(key).get(1) == 1 && mymap.get(key).get(0) < ans) ans = mymap.get(key).get(0);
        }
        if (ans == 100005) ans = -1;
        return ans;
    }
}