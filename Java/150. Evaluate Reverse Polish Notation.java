package Java;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int tmp = stk.pop() + stk.pop();
                stk.push(tmp);
            } else if (tokens[i].equals("-")) {
                int tmp = 0 - stk.pop() + stk.pop();
                stk.push(tmp);
            } else if (tokens[i].equals("*")) {
                int tmp = stk.pop() * stk.pop();
                stk.push(tmp);
            } else if (tokens[i].equals("/")) {
                int first = stk.pop();
                int tmp = stk.pop() / first;
                stk.push(tmp);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
        }
        return stk.pop();
     }
}