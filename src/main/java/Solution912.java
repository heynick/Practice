import java.util.Arrays;
import java.util.Random;

/**
 * @Author HEYNICK
 * @Date 2022/2/16 23:07
 * @Description 排序数组
 */
public class Solution912{

    /**
     * 元素交换
     */
    private void swap(int[] nums, int newIndex, int oldIndex){
        int temp = nums[newIndex];
        nums[newIndex] = nums[oldIndex];
        nums[oldIndex] = temp;
    }


    /**
     * 选择排序
     */
    public int[] sortArray(int[] nums){
        int len = nums.length;
        // 最后一轮只有一个元素，一定是最大元素，所以i < len -1
        for (int i = 0; i < len -1; i++){
            int minIndex = i;
            // 在 [i + 1, len -1] 区间里选择最小元素的下标
            for (int j = i + 1; j < len; j++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
            //输出每一步数组变化过程
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }


    /**
     * 冒泡排序
     */
    public int[] bubbleSort(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++){
            boolean flag = true;
            for (int j = 0; j < len - i; j++){
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            //输出每一步数组变化过程
            System.out.println(Arrays.toString(nums));
            if (flag){
                break;
            }
        }
        return nums;
    }


    /**
     * 插入排序
     */
    public int[] insertionSort(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++){
            for (int j = i; j > 0; j--){
                if (nums[j-1] > nums[j]){
                    swap(nums, j-1, j);
                }else{
                    break;
                }
            }
            //输出每一步数组变化过程
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

    public int[] insertionSort2(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++){
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
            //输出每一步数组变化过程
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

    public int[] insertionSort3(int[] nums){
        int len = nums.length;
        //哨兵，将最小值交换到第1个位置
        int minIndex = 0;
        {
            int i = 1;
            while (i < len) {
                if (nums[i] < nums[minIndex]){
                    minIndex = i;
                }
                i++;
            }
        }
        swap(nums, 0, minIndex);

        //暂存当前变量，将前面若干元素逐个向后赋值
        for (int i = 1; i < len; i++){
            int temp = nums[i];
            int j = i;
            while (nums[j - 1] > temp ){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
            //输出每一步数组变化过程
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }


    /**
     * 归并+递归
     */
    private static final int INSERTION_SORT_THRESHOLD = 47;

    public int[] sortedArray(int[] nums){
        int len = nums.length;

        // 优化3：全局使用一份临时数组
        int[] temp = new int[len];

        mergeSort(nums, 0, len-1, temp);
        return nums;
    }
    private void mergeSort(int[] nums, int left, int right, int[] temp){
        // 优化1：小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD){
            mergeInsertionSort(nums, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // 优化2：数组已经有序的情况下不再合并
        if (nums[mid] <= nums[mid + 1]){
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }
    private void mergeOfTwoSortedArray (int[] nums, int left, int mid, int right, int[] temp){
        // 每做一次合并，复制到全局使用的临时数组
        for (int i = left; i <= right; i++ ){
            temp[i] = nums[i];
        }
        //合并两个有序数组
        //i和j分别指向前有序数据和后有序数组的起始位置
        int i = left;
        int j = mid + 1;
        for (int k = left; k < right; k++){
            //i和j的越界情况
            if (i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if (j == right + 1){
                nums[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]){
                //<= 稳定排序
                nums[k] = temp[i];
                i++;
            }else {
                nums[left + k] = temp[j];
                j++;
            }
        }
    }
    private void mergeInsertionSort(int[] arr, int left, int right){
        for (int i = left + 1; i <= right; i++){
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


    /**
     * 快速排序
     */
    private static final Random RANDOM = new Random();

    public int[] quickSortArray(int[] nums){
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);

    }
    private int partition(int[] nums, int left, int right){
        // 随机选择切分元素
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        // 循环不变量: le即 less equals, 分界线
        // [left + 1, lt] < pivot
        // [lt + 1], i] >= pivot
        int le = left;
        for (int i = left + 1; i <= right; i++){
            if (nums[i] < pivot){
                // 交换当前元素于lt的位置
                le++;
                swap(nums, i, le);
            }
        }
        // 交换到切分元素的位置
        swap(nums, left, le);
        return le;
    }


    /**
     * 主程序
     */
    public static void main(String[] args) {
        Solution912 solution912 = new Solution912();

        System.out.println("选择排序");
        int[] nums = {8, 3, 9, 6, 4, 1, 5, 2, 10, 7};
        int[] res = solution912.sortArray(nums);
        System.out.println(Arrays.toString(res));

        System.out.println("冒泡排序");
        int[] nums1 = {8, 3, 9, 6, 4, 1, 5, 2, 10, 7};
        int[] resBubbleSort = solution912.bubbleSort(nums1);
        System.out.println(Arrays.toString(resBubbleSort));

        System.out.println("插入排序-逐个交换");
        int[] nums2 = {8, 3, 9, 6, 4, 1, 5, 2, 10, 7};
        int[] resInsertionSort= solution912.insertionSort(nums2);
        System.out.println(Arrays.toString(resInsertionSort));

        System.out.println("插入排序-交换");
        int[] nums3 = {8, 3, 9, 6, 4, 1, 5, 2, 10, 7};
        int[] resInsertionSort2= solution912.insertionSort2(nums3);
        System.out.println(Arrays.toString(resInsertionSort2));

        System.out.println("插入排序-哨兵");
        int[] nums4 = {8, 3, 9, 6, 4, 1, 5, 2, 10, 7};
        int[] resInsertionSort3= solution912.insertionSort3(nums4);
        System.out.println(Arrays.toString(resInsertionSort3));

        System.out.println("归并排序-优化后");
        int[] nums5 = {8, 3, 9, 6, 4, 1, 5, 2, 10, 7};
        int[] resMergeSort = solution912.sortedArray(nums5);
        System.out.println(Arrays.toString(resMergeSort));

        System.out.println("快速排序");
        int[] nums6 = {8, 3, 9, 6, 4, 1, 5, 2, 10, 7};
        int[] quickSortArray = solution912.quickSortArray(nums6);
        System.out.println(Arrays.toString(quickSortArray));
    }

}
