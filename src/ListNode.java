import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;
    }

    public static ListNode buildList(List<Integer> list){
        if(list.isEmpty()) return null;

        ListNode head = new ListNode(),
                runner = head,
                runnerBehind = runner;

        for(int i = 0; i < list.size(); i++){
            runner.val = list.get(i);
            runner.next = new ListNode();
            runnerBehind = runner;
            runner = runner.next;
        }

        runnerBehind.next = null;
        return head;
    }

    public static void print(ListNode l){
        ListNode runner = l;
        while(runner != null){
            System.out.print(runner.val + " ");
            runner = runner.next;
        }
        System.out.println();
    }
}
