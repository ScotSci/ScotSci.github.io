package assignment_5;

public class problem_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static Integer prev = null;
    private static int minDiff = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private static void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        
        inOrderTraversal(node.left);
        
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prev));
        }
        prev = node.val;
        
        inOrderTraversal(node.right);
    }
    
    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        
        System.out.println("Minimum absolute difference (Example 1): " + getMinimumDifference(root1)); // Output: 1
        
        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(48);
        root2.right.left = new TreeNode(12);
        root2.right.right = new TreeNode(49);
        
        System.out.println("Minimum absolute difference (Example 2): " + getMinimumDifference(root2)); // Output: 1
    }

}
