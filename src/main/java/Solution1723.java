import java.util.Arrays;
import java.util.Collections;

/**
 * @Author HEYNICK
 * @Date 2022/4/14 14:54
 * @Description 完成所有工作的最短时间
 */
public class Solution1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        jobs = Arrays.stream(jobs).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();

        int l = jobs[0], r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (checks(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean checks(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    private boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            if (workloads[j] == 0 || workloads[j] + cur == limit){
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] jobs = {1,2,4,8,7};
        int k = 2;
        Solution1723 solution1723 = new Solution1723();
        int ans = solution1723.minimumTimeRequired(jobs, k);
        System.out.println(ans);
    }
}
