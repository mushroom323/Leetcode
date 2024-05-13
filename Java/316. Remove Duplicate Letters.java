package Java;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/*
 * 题解跟这个写法差不多，也是单调栈处理
 * 但LastOccur和isLastOccur可以通过一个计数数组来替换，方便很多
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastOccur = new int[26];
        Arrays.fill(lastOccur, 0);
        for (int i = 0; i < s.length(); i++) {
            lastOccur[s.charAt(i) - 'a'] = Math.max(lastOccur[s.charAt(i) - 'a'], i);
        }
        Deque<Character> deque = new LinkedList<Character>();
        boolean[] isOccur = new boolean[26];
        Arrays.fill(isOccur, false);
        boolean[] isLastOccur = new boolean[26];
        Arrays.fill(isLastOccur, false);
        for (int i = 0; i < s.length(); i++) {
            if (!isOccur[s.charAt(i) - 'a']) {
                while (!deque.isEmpty()) {
                    if (deque.peekLast() > s.charAt(i) && !(isLastOccur[deque.peekLast() - 'a'])) {
                        isOccur[deque.removeLast() - 'a'] = false;
                    } else {
                        break;
                    }
                }
                deque.add(s.charAt(i));
                isOccur[s.charAt(i) - 'a'] = true;
            }
            if (i == lastOccur[s.charAt(i) - 'a'])
                isLastOccur[s.charAt(i) - 'a'] = true;
        }
        String ans = "";
        while (!deque.isEmpty()) {
            ans += deque.removeFirst();
        }
        return ans;
    }
}

/*
 * acdbcd abcd
 * acdcbc acdb
 */