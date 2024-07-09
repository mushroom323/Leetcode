package Java;
import Java.TreeNode;

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root.left != null) dfs(root.left, root.val * 10);
        if (root.right != null) dfs(root.right, root.val * 10);
        else if (root.left == null) sum += root.val;
        return sum;
    }
    public void dfs(TreeNode root, int curSum) {
        curSum += root.val;
        if (root.left == null && root.right == null) sum += curSum; 
        if (root.left != null) dfs(root.left, curSum * 10);
        if (root.right != null) dfs(root.right, curSum * 10);
    }
}