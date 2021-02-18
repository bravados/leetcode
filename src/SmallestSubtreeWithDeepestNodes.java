import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SmallestSubtreeWithDeepestNodes {
    int maxDepth = Integer.MIN_VALUE;
    int minHeight = Integer.MAX_VALUE;
    TreeNode ans;

    private int getDepth(TreeNode root, int height){
        if(root == null) return 0;
        int left = getDepth(root.left, height + 1);
        int right = getDepth(root.right, height + 1);

        if(left == right){
            if(height + left > maxDepth){
                maxDepth = height + left;
                minHeight = height;
                ans = root;
            }
            else if(height + left == maxDepth){
                if(height < minHeight){
                    minHeight = height;
                    ans = root;
                }
            }
        }
        return Math.max(left, right) + 1;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root){
        if(root == null) return null;
        getDepth(root, 0);
        return ans;
    }

    public static void main(String args[]) {
        List<Integer> input = Arrays.asList(0, null, 2, null, null, 1, 4);
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode root = new TreeNode(input.get(0));
        nodes.add(root);

        for (int i = 1; i < input.size(); i += 2) {
            int parentIdx = (i - 1) / 2;

            if (input.get(i) != null) {
                TreeNode node = new TreeNode(input.get(i));
                nodes.get(parentIdx).left = node;
                nodes.add(node);
            } else nodes.add(null);
            if (input.get(i + 1) != null) {
                TreeNode node = new TreeNode(input.get(i + 1));
                nodes.get(parentIdx).right = node;
                nodes.add(node);
            } else nodes.add(null);
        }

        SmallestSubtreeWithDeepestNodes problem = new SmallestSubtreeWithDeepestNodes();
        System.out.println(problem.lcaDeepestLeaves(root).val);
    }
}
