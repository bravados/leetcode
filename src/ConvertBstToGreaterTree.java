import java.util.Arrays;

public class ConvertBstToGreaterTree {

    private int getConverted(TreeNode node, int accumulated){
        if(node.right != null)
            node.val += getConverted(node.right, accumulated);

        else
            node.val += accumulated;

        int greatest = node.val;

        if(node.left != null)
            greatest = getConverted(node.left, node.val);

        return greatest;
    }

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        getConverted(root, 0);
        return root;
    }

    public static void main(String args[]){
        TreeNode root = TreeNode.buildTree(Arrays.asList(3,2,4,1));
        ConvertBstToGreaterTree convertBstToGreaterTree = new ConvertBstToGreaterTree();
        convertBstToGreaterTree.convertBST(null);
        TreeNode.print(root);
    }
}
