public class Leetcode2 {


    public static ListNode getNewListNode(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int count = 0;
        while (p != null || q != null) {
            int x = (p != null)? p.val: 0;
            int y = (q != null)? q.val: 0;
            int sum = x + y + count;
            count = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
        }
        if (count > 0) {
            current.next = new ListNode(count);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(9);
        ListNode listNode11 = new ListNode(8);
        listNode1.next = listNode11;

        ListNode listNode2 = new ListNode(7);
        ListNode listNode22 = new ListNode(9);
        listNode2.next = listNode22;

        System.out.println(getNewListNode(listNode1,listNode2));






    }

}

class ListNode{

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
