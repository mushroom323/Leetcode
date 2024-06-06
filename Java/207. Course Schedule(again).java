package Java;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i =0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }
    public void dfs(int i) {
        visited[i] = 1;
        for (int next : edges.get(i)) {
            if (visited[next] == 0) {
                dfs(next);
                if (!valid) return;
            } else if (visited[next] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}