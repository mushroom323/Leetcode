package Java;
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> arr;
    public List<List<Integer>> combine(int n, int k) {
        arr = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(n, k, 0, cur);
        return arr;
    }

    public void dfs(int n, int k, int level, List<Integer> cur) {
        if (level >= k) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < cur.size(); i++) {
                tmp.add(cur.get(i));
            }
            arr.add(tmp);
        } else {
            for (int i = cur.size() == 0 ? 1 : cur.getLast(); i <= n; i++) {
                if (cur.indexOf(i) == -1) {
                    cur.add(i);
                    dfs(n, k, level + 1, cur);
                    cur.removeLast();
                }
            }
        }
        return;
    }
}