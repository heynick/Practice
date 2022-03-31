import java.util.*;

/**
 * @Author HEYNICK
 * @Date 2022/3/30 15:39
 * @Description 找到处理最多请求的服务器
 */
public class Solution1606 {
    static int N = 100010;
    // 统计处理任务数
    static int[] cnts = new int[N];
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Arrays.fill(cnts, 0);
        int n = arrival.length, max = 0;
        // 优先队列存储当前忙碌的服务器索引及其任务结束时间，根据结束时间升序排列
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b)->a[1]-b[1]);
        // 红黑数集合 存储当前任务开始时刻，所有空闲的服务器索引
        TreeSet<Integer> free = new TreeSet<>();
        // 初始所有服务器均空闲，全部加入到free
        for (int i = 0; i < k; i++) free.add(i);
        // 依次遍历每一个任务
        for (int i = 0; i < n; i++) {
            // 当前待分配任务的开始时刻与结束时刻
            int start = arrival[i], end = start + load[i];
            // 找出所有当前忙碌的服务器的任务结束时刻早于待分配任务的开始时刻的，都加入到free集合中等待筛选
            while (!busy.isEmpty() && busy.peek()[1] <= start) free.add(busy.poll()[0]);
            // 用u来表示当前轮次待分配到的服务器索引，优先取>=i%k的
            Integer u = free.ceiling(i % k);
            // 若娶不到，则取>=0的
            if (u == null) u = free.ceiling(0);
            // 若依然取不到，则放弃该任务
            if (u == null) continue;
            // 取到了，将该服务器索引从free中移除
            free.remove(u);
            // 与此同时，将该服务器加入到忙碌队列中，存储一个长度为2的数组，[0]:索引 [1]:任务结束时刻
            busy.add(new int[]{u, end});
            // 更新当前最大的处理任务数目
            max = Math.max(max, ++cnts[u]);
        }
        // 将最忙碌的服务器索引筛选出来加入list
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (cnts[i] == max) ans.add(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int k = 3;
        int[] arrival = {1,2,3,4,5}, load = {5,2,3,3,3};
        Solution1606 solution1606 = new Solution1606();
        List<Integer> res = solution1606.busiestServers(k, arrival, load);
        System.out.println(res);
    }

}
