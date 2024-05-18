package Java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/*
 * 优先队列，往里头加数对，其中nums1的坐标上限为k，所以可以直接加到(k, 0)，然后提取的时候自增num2的坐标
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] - nums1[o2[0]] + nums2[o1[1]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k > 0 && !pq.isEmpty()) {
            k--;
            int[] curPair = pq.poll();
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums1[curPair[0]]);
            list.add(nums2[curPair[1]]);
            ans.add(list);
            if (curPair[1] + 1 < nums2.length) {
                pq.offer(new int[]{curPair[0],curPair[1] + 1});
            }
        }
        return ans;
    }
}