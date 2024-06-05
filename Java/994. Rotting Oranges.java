package Java;

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] time = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j  < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(0, i, j, time, grid);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = 0; j < time[0].length; j++) {
                count = Math.max(count, time[i][j]);
                if (grid[i][j] == 1 && time[i][j] == 0) {
                    return -1;
                }
            }
        }
        return count;
    }

    public void dfs(int minute, int i, int j, int[][] time, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == 0 ) return;
        if (grid[i][j] == 2 && minute != 0) return;
        if (minute < time[i][j] || time[i][j] == 0) {
            time[i][j] = minute;
            dfs(minute + 1, i + 1, j, time, grid);
            dfs(minute + 1, i - 1, j, time, grid);
            dfs(minute + 1, i, j + 1, time, grid);
            dfs(minute + 1, i, j - 1, time, grid);
        } else return;
        
    }
}