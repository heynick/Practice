package Struct;

/**
 * @Author HEYNICK
 * @Date 2022/2/28 17:17
 * @Description default
 */
public class SingleLinkedList {

    /**
     * 标识整个链表的头
     */
    public ListNode head;

    /**
     * 头插法
     */
    public void addFirst(int data){
        ListNode cur = new ListNode(data);
        // 第一次插入节点
        if(this.head == null){
            this.head = cur;
        }
        // 不是第一次插入节点
        cur.next = head;
        head = cur;
    }

    /**
     * 尾插法
     */
    public void addLast(int data){
        ListNode node = new ListNode(data);
        // 第一次插入
        if(this.head == null){
            this.head = node;
        }
        // 不是第一次插入
        // 找到尾节点
        ListNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        // 插入新节点
        cur.next = node;
    }

    /**
     * 任意位置插入，第一个数据节点为0号下标
     */
    public boolean addIndex(int index, int data){

    }

    /**
     * 查找关键字key是否在单链表当中
     */
    public boolean contains(int key){

    }

    /**
     * 删除第一次出现关键字为key的节点
     */
    public boolean remove(int key){

    }

    /**
     * 删除所有值为key的节点
     */
    public void removeAllKey(int key){

    }

    /**
     * 得到单链表的长度
     */
    public int size(){

    }

    public void display(){

    }

    public void clear(){

    }


}
