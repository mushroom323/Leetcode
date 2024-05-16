package Java;

import java.util.PriorityQueue;

// 直接用优先队列

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qu = new PriorityQueue<Integer>((o1, o2)->o2.compareTo(o1)); // 大根堆
        for (int n : nums) {
            qu.add(n);
        }
        int i = 1;
        while (i < k) {
            qu.poll();
            i++;
        }
        return qu.peek();
    }
}