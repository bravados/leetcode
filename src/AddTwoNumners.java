import java.util.Arrays;

public class AddTwoNumners {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode runner1 = l1, runner2 = l2;
        ListNode resultHead = null, runnerResult = null;
        int carry = 0;

        while(runner1 != null || runner2 != null || carry > 0){
            int val1 = 0, val2 = 0, result;

            if(runner1 != null){
                val1 = runner1.val;
                runner1 = runner1.next;
            }

            if(runner2 != null){
                val2 = runner2.val;
                runner2 = runner2.next;
            }

            result = carry + val1 + val2;

            if(result >= 0) {
                ListNode resultNode = new ListNode(result % 10);

                if (resultHead == null) {
                    resultHead = resultNode;
                    runnerResult = resultHead;
                } else {
                    runnerResult.next = resultNode;
                    runnerResult = runnerResult.next;
                }
                carry = result / 10;
            }
        }
        return resultHead;
    }

    public static void main(String args[]){
        AddTwoNumners addTwoNumners = new AddTwoNumners();
        ListNode l1 = ListNode.buildList(Arrays.asList(2,4,3));
        ListNode l2 = ListNode.buildList(Arrays.asList(5,6,4));
        ListNode.print(addTwoNumners.addTwoNumbers(l1, l2));
    }
}
