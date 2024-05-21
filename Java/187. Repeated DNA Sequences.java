package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        if (s.length() <= 10) return ans;
        HashMap<String, Integer> mymap = new HashMap<String, Integer>();
        for (int i = 10; i <= s.length(); i++) {
            String subString = s.substring(i - 10, i);
            if (!mymap.containsKey(subString)) mymap.put(subString, 1);
            else if (mymap.get(subString) == 1){
                ans.add(subString);
                mymap.put(subString, mymap.get(subString) + 1);
            }
        }
        return ans;
    }
}