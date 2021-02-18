import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(List<Integer> nodes){
        Queue<Integer> input = new LinkedList<>(nodes);
        Queue<TreeNode> build = new LinkedList<>();
        TreeNode root = new TreeNode(input.poll());
        build.add(root);

        while(!build.isEmpty()){
            TreeNode node = build.poll();

            Integer leftValue = input.poll();
            if(leftValue != null) {
                TreeNode left = new TreeNode(leftValue);
                node.left = left;
                build.add(left);
            }
            Integer rightValue = input.poll();
            if(rightValue != null) {
                TreeNode right = new TreeNode(rightValue);
                node.right = right;
                build.add(right);
            }
        }

        return root;
    }

    public static void print(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null)   q.add(node.left);
            if(node.right != null) q.add(node.right);
            System.out.print(node.val + " ");
        }
        System.out.println();
    }
}