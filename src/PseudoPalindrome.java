import java.util.*;

public class PseudoPalindrome {

    private int dfs(TreeNode node, boolean[] pathValues){
        int count = 0;

        pathValues[node.val - 1] = !pathValues[node.val - 1];

        // base case
        if(node.left == null && node.right == null) {

            for(int i = 0; i < pathValues.length; i++)
                if(pathValues[i])
                    count++;
            count = count > 1 ? 0 : 1;
        } else {
            if(node.left != null)
                count += dfs(node.left, pathValues);
            if(node.right != null)
                count += dfs(node.right, pathValues);
        }

        pathValues[node.val - 1] = !pathValues[node.val - 1];

        return count;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, new boolean[9]);
    }

    public static void main(String args[]) {
        Queue<Integer> input = new LinkedList<>(Arrays.asList(9,5,4,5,null, 2,6,2,5, null,8 ,3,9 ,2,3,1,1,null,4,5,4,2,2,6,4,null,null,1,7,null,5,4,7,null,null,7,null,1,5,6,1,null,null,null,null,9,2,null,9,7,2,1,null,null,null,6,null,null,null,null,null,null,null,null,null,5,null,null,3,null,null,null,8,null,1,null,null,8,null,null,null,null,2,null,8,7));
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

        PseudoPalindrome problem = new PseudoPalindrome();
        System.out.println(problem.pseudoPalindromicPaths(root));
    }
}
