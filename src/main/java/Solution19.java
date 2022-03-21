import Struct.ListNode;


/**
 * @Author HEYNICK
 * @Date 2022/3/3 9:28
 * @Description 删除链表的倒数第N个节点
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLenOfNode(head);
        // 虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        // 从虚拟头结点开始走len - N步
        for (int i = 0; i < len - n; i++) {
            curNode = curNode.next;
        }
        // 删除结点，先声明待删除结点
        ListNode deleteNode = curNode.next;
        // 修改指针
        curNode.next = deleteNode.next;
        // 删除结点的next指针释放引用
        deleteNode.next = null;
        return dummyNode.next;
    }

    private int getLenOfNode (ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode twoIndexRemoveNthFromEnd (ListNode head, int n) {
        // 虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 快指针
        ListNode fastNode = dummyNode;
        for (int i = 0; i < n + 1; i++) {
            fastNode = fastNode.next;
        }
        // 慢指针
        ListNode slowNode = dummyNode;
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        // 删除操作
        ListNode deleteNode = slowNode.next;
        slowNode.next = deleteNode.next;
        deleteNode.next = null;
        return  dummyNode.next;

    }

    public static void main(String[] args) {
        int n = 2;
        int[] array = {1,2,3,4,5};
        ListNode head = new ListNode(array);
        Solution19 solution19 = new Solution19();

        solution19.twoIndexRemoveNthFromEnd(head, n);
        System.out.println(head);
    }
}
