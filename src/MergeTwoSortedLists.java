import java.util.Arrays;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;

        ListNode r1 = l1;
        ListNode r2 = l2;
        ListNode mergedHead = new ListNode(),
                runner = mergedHead,
                runnerBehind = runner;

        while(r1 != null || r2 != null){

            if(r2 == null || r1 != null && r1.val <= r2.val) {
                runner.val = r1.val;
                r1 = r1.next;
            }
            else {
                runner.val = r2.val;
                r2 = r2.next;
            }

            runnerBehind = runner;
            runner.next = new ListNode();
            runner = runner.next;
        }
        runnerBehind.next = null;

        return mergedHead;
    }

    public static void main(String args[]){
        ListNode l1 = ListNode.buildList(Arrays.asList(1, 2, 4));
        ListNode l2 = ListNode.buildList(Arrays.asList(1,3,4));

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(l1, l2);

        while(mergedList != null){
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }

}
