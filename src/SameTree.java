import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SameTree {
    public static boolean isSameTree(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) return true;
        else if (head1 != null && head2 == null) return false;
        else if (head1 == null && head2 != null) return false;
        else if (head1.val != head2.val) return false;
        return isSameTree(head1.left, head2.left) && isSameTree(head1.right, head2.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null && q != null) return false;
        else if (p != null && q == null) return false;
        else if (p.val != q.val) return false;
        return check(p.left, q.right) && check(p.right, q.left);
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 1;
    }

    public static void main(String[] args) {
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode();
        TreeNode A = new TreeNode(1, B, C);
        TreeNode D = new TreeNode(1, C, B);
//        if (isSameTree(A,D)) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }
//
//        if (isSymmetric(A)) System.out.print("true");
//        else System.out.print("false")
        System.out.println(maxDepth(A));
    }

    public void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        arr.add(root.val);
        dfs(root.left, arr);
        dfs(root.right, arr);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        return arr;
    }
}
