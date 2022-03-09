package Struct;

import Interface.Queue;

import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/3/9 11:21
 * @Description 优先队列
 */
public class MaxHeap implements Queue {

    /**
     * 0号下标不存放数据
     */
    private int[] data;
    /**
     * 堆中能够存储的元素的最大数量
     */
    private int capacity;
    /**
     * 当前最大堆中真正存储的元素的个数
     */
    private int size;

    @Override
    public int size() {
        size = data.length;
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("堆为空");
        }
        // 下标0不存元素
        return data[1];
    }

    @Override
    public void offer(int item) {
        if (size + 1 > capacity) {
            throw new IllegalArgumentException("堆空间已满");
        }
        // 把新添加的元素放在数组的最后一位
        data[size + 1] = item;
        // 维护size的定义
        size++;
        // 考虑将data[size]的元素上移到合适的位置
        siftUp(size);
    }

    public void siftUp(int k) {
        // 有下标就要考虑索引越界的情况，已经在下标1的位置就不用上移
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k/2, k);
            k /= 2;
        }
    }

    public void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    @Override
    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        int ret = data[1];
        // 把最后一个元素的值赋值到二叉堆的根节点
        data[1] = data[size];
        size--;
        siftDown(1);
        return ret;
    }

    public void siftDown(int k) {
        // 只要它有孩子，这里使用等号，因为真正存数据的下标从1开始
        while (2 * k <= size) {
            int j = 2 * k;
            // 如果它有右边的孩子，并且右边的孩子大于左边的孩子
            if (j + 1 < size && data[j + 1] > data[j]) {
                j++;
            }
            // 如果当前的值，比右边的孩子节点要大，则逐渐下落的过程到此结束
            if (data[k] >= data[j]) {
                break;
            }
            // 否则交换位置
            swap(data, k, j);
            k = j;
        }
    }

    public void replace(int item) {
        if (isEmpty()) {
            throw new IllegalArgumentException("堆为空");
        }
        // 注意：堆顶元素替换，size不变
        data[1] = item;
        siftDown(1);
    }

    public void display() {
        System.out.println(Arrays.toString(data));
    }

    public MaxHeap(int capacity) {
        // 下标0不存元素，因此需要空间为 capacity + 1
        data = new int[capacity + 1];
        this.capacity = capacity;
        size = 0;
    }

    public MaxHeap(int[] arr) {
        capacity = arr.length + 1;
        data = new int[capacity];
        size = arr.length;
        System.arraycopy(arr, 0, data, 1, size);
        for (int i = size / 2; i >= 1; i--) {
            siftDown(i);
        }
    }
}
