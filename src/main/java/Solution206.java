import Struct.ListNode;
import Struct.SingleLinkedList;

/**
 * @Author HEYNICK
 * @Date 2022/3/2 16:24
 * @Description 反转链表
 */
public class Solution206 {

    public  ListNode reverseList(ListNode head){
        // 特判
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public ListNode recursionReverseList (ListNode head, int depthForDebug) {
        //递归日志1
        System.out.println(" ".repeat(depthForDebug) + "divide("  + ")");

        // 特判
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newNode = recursionReverseList(nextNode,depthForDebug + 1);
        nextNode.next = head;
        head.next = null;

        //递归日志2
        System.out.println(" ".repeat(depthForDebug) + "divide("  + ")");

        return newNode;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Solution206 solution206 = new Solution206();

/*        int[] head = {1,2,3,4,5};
        ListNode cur = singleLinkedList.makeSingleLinkedList(head);
        ListNode now = solution206.reverseList(cur);
        singleLinkedList.display(now);*/


        int[] head = {1,2,3,4,5};
        ListNode cur = singleLinkedList.makeSingleLinkedList(head);
        ListNode recursionNow = solution206.recursionReverseList(cur, 0);
        singleLinkedList.display(recursionNow);
    }
}
