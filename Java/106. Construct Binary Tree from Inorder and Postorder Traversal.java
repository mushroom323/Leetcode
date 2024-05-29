package Java;

import Java.TreeNode;
   

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        dfs(inorder, postorder, 0, inorder.length - 1, postorder.length - 1, root);
        return root;

    }
    public int dfs(int[] inorder, int[] postorder, int l, int r,int cur, TreeNode root) {
        if (l > r || cur < 0) {
            root.val = 5000;
            return cur;
        }
        root.val = postorder[cur];
        if (l == r) return cur - 1;
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == root.val) break;
        }
        TreeNode right = new TreeNode();
        int rightBound = dfs(inorder, postorder, i + 1, r, cur - 1, right);
        TreeNode left = new TreeNode();
        int leftBound = dfs(inorder, postorder, l, i - 1, rightBound, left);
        if (left.val == 5000) left = null;
        if (right.val == 5000) right = null; 
        root.left = left;
        root.right = right;
        return leftBound;
    }
}