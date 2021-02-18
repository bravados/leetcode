import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TargetNodeInClonedTree {

    private boolean dfs(TreeNode original, TreeNode target, Deque<Integer> path){
        boolean found = true;

        if(original != target){

            if(original.left != null){
                path.add(-1);
                found = dfs(original.left, target, path);

                if(found) return true;
                else path.removeLast();
            }

            if(original.right != null){
                path.add(1);
                found = dfs(original.right, target, path);

                if(found) return true;
                else path.removeLast();
            }
            found = false;
        }

        return found;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target){
        Deque<Integer> path = new LinkedList<>();

        dfs(original, target, path);

        TreeNode targetCloned = cloned;

        while(!path.isEmpty()){
            Integer direction = path.poll();

            if(direction == -1)
                targetCloned = targetCloned.left;
            else
                targetCloned = targetCloned.right;
        }

        return targetCloned;
    }

    public static void main(String args[]){
        TreeNode root = TreeNode.buildTree(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        TreeNode copy = TreeNode.buildTree(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        TreeNode target = root.left.right;

        TargetNodeInClonedTree targetNodeInClonedTree = new TargetNodeInClonedTree();
        TreeNode targetCopy = targetNodeInClonedTree.getTargetCopy(root, copy, target);
        System.out.println(targetCopy.val);
    }
}
