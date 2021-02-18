import java.util.LinkedList;
import java.util.List;

class BSTIterator {
    TreeNode current, root;

    List<TreeNode> trace = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        current = null;
        this.root = root;
    }

    public int next() {
        TreeNode runner;

        if(current == null) {
            runner = root;
            do {
                trace.add(runner);
                runner = runner.left;
            } while (runner != null);
            current = trace.remove(trace.size() - 1);

            return current.val;
        }

        TreeNode parent = null;

        if(!trace.isEmpty())
            parent = trace.get(trace.size() - 1);

        if (current.right != null) {
            trace.add(current);
            current = current.right;

            while (current.left != null) {
                trace.add(current);
                current = current.left;
            }
            return current.val;
        } else if(parent.left == current){
            current = trace.remove(trace.size() - 1);
            return current.val;
        } else { // I am right child
            trace.remove(trace.size() - 1);
            do {
                current = parent;
                parent = trace.remove(trace.size() - 1);
            }while(parent.right == current);
            current = parent;

            return current.val;
        }
    }

    public boolean hasNext() {
        if(current == null) return true;
        if(current.right != null) return true;
        if(this.trace.isEmpty()) return false;
        TreeNode parent = this.trace.get(this.trace.size() - 1);
        if(parent.left == current) return true;

        boolean has = false;
        TreeNode runner = parent;

        for(int i = trace.size() - 2; i >= 0; i--){
            parent = trace.get(i);
            if(parent.right != null && runner.val == parent.right.val){
                runner = parent;
            } else{
                has = true;
                break;
            }
        }
        return has;
    }
}