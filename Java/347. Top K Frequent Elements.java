package Java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (mymap.containsKey(nums[i])) mymap.put(nums[i], mymap.get(nums[i]) + 1);
            else mymap.put(nums[i], 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return mymap.get(o2) - mymap.get(o1);
            }
        });
        for (Integer index : mymap.keySet()) queue.add(index);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}