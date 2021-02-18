import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class BSTIteratorProblem {

    public static void main(String args[]){
        List<Integer> input = Arrays.asList(4, 3, null, 2, null, null, null, 1, null, null, null, null, null, null, null);
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode root = new TreeNode(input.get(0));
        nodes.add(root);

        for(int i = 1; i < input.size(); i += 2){
            int parentIdx = (i - 1)/2;

            if(input.get(i) != null){
                TreeNode node = new TreeNode(input.get(i));
                nodes.get(parentIdx).left = node;
                nodes.add(node);
            } else nodes.add(null);
            if(input.get(i + 1) != null){
                TreeNode node = new TreeNode(input.get(i + 1));
                nodes.get(parentIdx).right = node;
                nodes.add(node);
            } else nodes.add(null);
        }

        BSTIterator it = new BSTIterator(root);
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */