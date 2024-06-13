package Java;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mymap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (mymap.containsKey(c)) {
                mymap.put(c, mymap.get(c) + 1);
            } else {
                mymap.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (!mymap.containsKey(c)) return false;
            else mymap.put(c, mymap.get(c) - 1);
        }
        for (Integer num : mymap.values()) {
            if (num != 0) return false;
        }
        return true;
    }
}