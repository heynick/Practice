package Struct;


import java.util.List;

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
            return;
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
            return;
        }
        // 不是第一次插入
        ListNode cur = this.head;
        // 找到尾节点
        while(cur.next != null){
            cur = cur.next;
        }
        // 插入新节点
        cur.next = node;
    }

    /**
     * 任意位置插入，第一个数据节点为0号下标
     */
    public ListNode findIndexSubOne(int index){
        // 查找index - 1位置的节点prev
        ListNode prev =this.head;
        while(index - 1 > 0){
            prev = prev.next;
            index--;
        }
        return prev;
    }

    public void addIndex(int index, int data){
        // 判断index是否合法
        if(index < 0 || index > size()){
            System.out.println("index 不合法");
            return;
        }
        // 插入index=0 头插法
        if(index == 0){
            addFirst(data);
            return;
        }
        // 插入index=sizeof() 尾插法
        if(index == size()){
            addLast(data);
            return;
        }
        // 找到要插入下标节点的前一个节点
        ListNode prev = findIndexSubOne(index);
        // 任意节点插入中间位置
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;

    }

    /**
     * 查找关键字key是否在单链表当中
     */
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除第一次出现关键字为key的节点
     */
    public ListNode searchPrev(int key){
        ListNode prev = this.head;
        while (prev.next != null){
            if(prev.next.val == key){
                return prev;
            }
            prev = prev.next;
        }
        // 没有找到这个节点
        return null;

    }
    public void remove(int key){
        // 如果要删除头节点
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        // 找到要删除节点key的前驱节点
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有要删除的节点");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;

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
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    /**
     * 打印链表
     */
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.println(cur.val+ " ");
            cur = cur.next;
        }
    }
    public void display(ListNode cur){
        while(cur != null){
            System.out.println(cur.val+ " ");
            cur = cur.next;
        }
    }

    /**
     * 删除链表
     */
    public void clear(){
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
    }

    /**
     * 根据数组生成单链表
     */
    public ListNode makeSingleLinkedList(int[] list){
        ListNode cur = new ListNode();
        for(int i : list){
            addLast(i);
        }
        return this.head;
    }
}
