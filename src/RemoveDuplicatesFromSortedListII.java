import java.util.Arrays;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return null;

        ListNode newHead = null;
        ListNode left = null, middle = head, right = head.next;

        while(middle != null){

            if((left == null || left.val != middle.val) && (right == null || right.val != middle.val)){

                if(left == null) newHead = middle;

                left = middle;
                middle = right;
                right = right != null ? right.next : null;
            } else {
                int val = middle.val;

                while(middle != null && val == middle.val){
                    middle = right;
                    right = right != null ? right.next : null;

                    if(left != null)
                        left.next = middle;
                }
            }
        }

        return newHead;
    }

    public static void main(String args[]){
        ListNode list = ListNode.buildList(Arrays.asList());

        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();

        ListNode.print(removeDuplicatesFromSortedListII.deleteDuplicates(list));
    }
}
