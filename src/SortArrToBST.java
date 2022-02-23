import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SortArrToBST {
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

    private static TreeNode makeBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo)/2;
        if (mid < 0 || mid >= nums.length) return null;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = makeBST(nums, lo, mid-1);
        root.right = makeBST(nums, mid+1, hi);

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] a) {
        return makeBST(a, 0, a.length);
    }

    public static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if(data <= root.val) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void print(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode q = queue.poll();
            System.out.print(q.val + " ");
            if (q.left != null) queue.add(q.left);
            if (q.right != null) queue.add(q.right);
        }
    }
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5};
        TreeNode root = sortedArrayToBST(a);
        print(root);
    }
}
