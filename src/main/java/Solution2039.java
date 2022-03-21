import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author HEYNICK
 * @Date 2022/3/21 20:15
 * @Description 网络空闲的时刻
 */
public class Solution2039 {
    static int N = 100010, M = N*2, INF=0x3f3f3f3f;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] dist = new int[N];
    int idx;
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Arrays.fill(he, -1);
        Arrays.fill(dist, INF);
         int n = patience.length;
        for (int[] e : edges) {
            add(e[0], e[1]);
            add(e[1], e[0]);
        }
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        dist[0] = 0;
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int i = he[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] != INF) {
                    continue;
                }
                dist[j] = dist[t] + 1;
                d.addLast(j);
                }
            }
         int ans = 0;
        for (int i = 1; i < n; i++) {
            int di = dist[i] * 2, t = patience[i];
            int cur = di <= t ? di : (di - 1) / t * t + di;
            if (cur > ans) {
                ans = cur;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2}};
        int[] patience = {0,2,1};
        Solution2039 solution2039 = new Solution2039();
        int res = solution2039.networkBecomesIdle(edges, patience);
        System.out.println(res);
    }
}
