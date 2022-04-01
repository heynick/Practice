import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author HEYNICK
 * @Date 2022/4/1 16:54
 * @Description 单线程CPU
 */
public class Solution1834 {
    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        Solution1834 solution1834 = new Solution1834();
        int[] ans = solution1834.getOrder(tasks);
        System.out.println(ans);
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // 将tasks转存成nts,保留任务编号
        int[][] nts = new int[n][3];
        for (int i = 0; i < n; i++) {
            nts[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        // 根据任务入队时间进行排序
        Arrays.sort(nts, (a, b) -> a[0] - b[0]);
        // 根据题意，先按照持续时间排序，再根据任务编号排序
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        int[] ans = new int[n];
        for (int time = 1, j = 0, idx = 0; idx < n; ) {
            // 如果当前任务可以添加到队列中（满足入队时间），则入队
            while (j < n && nts[j][0] <= time) {
                q.add(nts[j++]);
            }
            if (q.isEmpty()) {
                // 如果当前队列没有任务，直接跳到下个任务的入队时间
                time = nts[j][0];
            } else {
                // 如果有可执行任务的话，根据优先级将任务出队（记录下标），并跳到该任务完成时间点
                int[] cur = q.poll();
                ans[idx++] = cur[2];
                time += cur[1];
            }
        }
        return ans;
    }
}
