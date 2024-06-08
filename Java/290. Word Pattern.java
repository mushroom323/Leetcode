package Java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mymap = new HashMap<Character, String>();
        int count = 0;
        String cur = new String();
        Set<String> myset = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (count >= pattern.length()) return false;
                if (mymap.containsKey(pattern.charAt(count))) {
                    if (!cur.equals(mymap.get(pattern.charAt(count)))) {
                        return false;
                    }
                } else {
                    if (myset.contains(cur)) return false;
                    mymap.put(pattern.charAt(count), cur);
                    myset.add(cur);
                }
                count++;
                cur = new String();
            } else {
                cur += s.charAt(i);
            }
        }
        if (count >= pattern.length()) return false;
        if (mymap.containsKey(pattern.charAt(count))) {
            if (!cur.equals(mymap.get(pattern.charAt(count)))) {
                return false;
            }
        } else {
            if (myset.contains(cur)) return false;
            mymap.put(pattern.charAt(count), cur);
            myset.add(cur);
        }
        if (count != pattern.length() - 1) return false;
        return true;
    }
}