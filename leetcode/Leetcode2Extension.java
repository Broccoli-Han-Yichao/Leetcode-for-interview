/**
 * this is a extension for the leetcode 2
 * why this happen \?
 * at the begining, I think that this one is as complexity as I thought before
 * 单链表的反转
 */
public class Leetcode2Extension {


    /**
     * this method is to revert a ListNode
     * wrong ! 死循环了！
     * @param head
     * @return
     */
    public static ListNode revert(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next = head.next;
        while (head != null) {
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }

    /**
     * correct way to use
     * 三个指针，之前错误是因为只移动了两个，第三个next没有移动
     * @param head
     * @return
     */
    public static ListNode revert1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }

    public static ListNode revert2Recurson(ListNode head) {

//        ListNode newListNode;
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//        newListNode = revert2Recurson(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newListNode;
        ListNode newHead;
        if(head==null||head.next==null ){
            return head;
        }
        newHead=revert2Recurson(head.next); //head.next 作为剩余部分的头指针
        head.next.next=head; //head.next 代表新链表的尾，将它的 next 置为 head，就是将 head 加到最后了。
        head.next=null;
        return newHead;



    }

    public static ListNode recursion(ListNode head){

        if (head == null || head.next == null) {

            return  head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode returnList = recursion(next);
        next.next = head;
        return returnList;


    }


    public static void main(String[] args) {

        ListNode listNode2 = new ListNode(7);
        ListNode listNode22 = new ListNode(9);
        listNode2.next = listNode22;
        listNode22.next = null;
        System.out.println("the original list is "+listNode2);
        System.out.println("the invert result is "+ Leetcode2Extension.revert1(listNode2));
        //很奇怪的一个点就是不知道为什么，下面是正确的方法，但是递归输入listNode2的时候就只有一个节点，神奇
        System.out.println("recursion1   "+ Leetcode2Extension.revert2Recurson(listNode2));
        System.out.println("recursion2   "+ Leetcode2Extension.recursion(listNode2));
    }

}
