package Java;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 关键点在于要优先移除在位置在i的数字，位置i满足num[i] > num[i + 1]
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        Deque<Character> deque = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i > 0 && (num.charAt(i) < num.charAt(i - 1))) {
                for (int j = 0; count < k && deque.size() > 0 && deque.peekLast() > num.charAt(i); j++) {
                    count++;
                    deque.removeLast();
                }
            }
            deque.add(num.charAt(i));
        }
        System.out.println(count);
        if (count < k) {
            deque.removeLast();
            count++;
        }
        String ans = "";
        while (deque.size() != 0) {
            if (deque.peek() != '0' || !ans.equals("")) {
                ans += deque.pop();
            } else deque.pop();
        }
        if (ans.equals("")) ans = "0";
        return ans;
    }
}