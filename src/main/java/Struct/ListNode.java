package Struct;

/**
 * @Author HEYNICK
 * @Date 2022/2/28 16:05
 * @Description default
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
