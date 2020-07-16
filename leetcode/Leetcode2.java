public class Leetcode2 {


    /**
     * official method , remember the method and use that, 2020.6.27
     * @param l1
     * @param l2
 * @return
     */
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



    /**
     * the time complexity is O(max(m,n)), after use the first method for about two weeks 2020.7.10
     * this method is wrong cause some problems
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode oldMethod(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int count= 0;
        while (p != null && q != null) {

            int temp = p.val+ q.val+ count;
            ListNode listNode = new ListNode(temp % 10);
            current.next = listNode;
            count = temp/10;
            p = p.next;
            q = q.next;

        }
        while (p != null) {
            int temp =count + p.val;
            ListNode listNode = new ListNode(temp % 10);
            count = temp /10;
            current.next = listNode;

        }
        while (q != null) {
            int temp =count + q.val;
            ListNode listNode = new ListNode(temp % 10);
            count = temp /10;
            current.next = listNode;

        }
        return dummyHead.next;

    }

    /**
     * the time complexity is O(max(m,n)), after use the first method for about two weeks 2020.7.10
     * fix this method, still wrong
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode oldMethodFix1(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int count= 0;
        while (p != null && q != null) {

            int temp = p.val+ q.val+ count;
            ListNode listNode = new ListNode(temp % 10);
            current.next = listNode;
            //add the following
            current = current.next;
            count = temp/10;
            p = p.next;
            q = q.next;

        }
        while (p != null) {
            int temp =count + p.val;
            ListNode listNode = new ListNode(temp % 10);
            count = temp /10;
            current.next = listNode;
            //add
            current = current.next;

        }
        while (q != null) {
            int temp =count + q.val;
            ListNode listNode = new ListNode(temp % 10);
            count = temp /10;
            current.next = listNode;
            //add
            current = current.next;

        }
        return dummyHead.next;

    }

    /**
     * the time complexity is O(max(m,n)), after use the first method for about two weeks 2020.7.10
     * fix the method called oldMethodFix1, success!
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode oldMethodFix2(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int count= 0;
        while (p != null && q != null) {

            int temp = p.val+ q.val+ count;
            ListNode listNode = new ListNode(temp % 10);
            current.next = listNode;
            //add the following
            current = current.next;
            count = temp/10;
            p = p.next;
            q = q.next;

        }
        while (p != null) {
            int temp =count + p.val;
            ListNode listNode = new ListNode(temp % 10);
            count = temp /10;
            current.next = listNode;
            //add
            current = current.next;

        }
        while (q != null) {
            int temp =count + q.val;
            ListNode listNode = new ListNode(temp % 10);
            count = temp /10;
            current.next = listNode;
            //add
            current = current.next;

        }
        if (count > 0) {

            ListNode listNode = new ListNode(count);
            current.next = listNode;

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

        System.out.println("the correct one   "+getNewListNode(listNode1,listNode2));
        System.out.println("the first one , some problems   "+oldMethod(listNode1,listNode2));
        System.out.println("the second one , fix the old problem but get some new bugs   "+oldMethodFix1(listNode1,listNode2));
        System.out.println("the third one , fix the old problem ,success!   "+oldMethodFix2(listNode1,listNode2));


    }

}

class ListNode {

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

