import Struct.ListNode;
import Struct.SingleLinkedList;

/**
 * @Author HEYNICK
 * @Date 2022/2/28 15:50
 * @Description default
 */
public class Test1 {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.makeSingleLinkedList(test);
        singleLinkedList.display();

        ListNode listNode = new ListNode(test);
        System.out.println(listNode.toString());
        int i = -1;
        System.out.println(i >>2);
        System.out.println(i >>>2);
    }
}
