/**
 * @Author HEYNICK
 * @Date 2022/3/9 16:56
 * @Description 朋友圈
 */
public class Solution547 {
    public int findCircleNum(int[][] M){
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);

        for (int i = 0; i < len; i++) {
            // 矩阵的下三角部分（不包括对角线）
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.getCount();
    }

    private static class UnionFind {
        /**
         * quick-find 每个结点的id标识，id标识一样，标识被分在一个组; quick-union
         */
        private final int[] parent;
        /**
         * 连通分量的个数
         */
        private int count;
        private int N;

        public int getCount() {
            return count;
        }

        public UnionFind(int N){
            this.N = N;
            this.count = N;
            this.parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        // 找到父结点
        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
    }


    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,0,0,0,1,1,0,1,0,0,0,1,0,0,0},{0,1,0,0,1,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,1,0,0,0,0,0,0,0,1,1,0},{0,0,0,1,0,0,0,0,0,0,0,1,1,1,0},{1,1,1,0,1,0,0,0,0,0,1,0,0,0,0},{1,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,1,0,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,0,1},{0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0,1,0,0,1,0},{1,0,0,1,0,0,0,0,0,0,0,1,1,0,0},{0,0,1,1,0,0,0,0,0,0,0,1,1,0,0},{0,0,1,1,0,0,0,0,0,0,1,0,0,1,0},{0,0,0,0,0,0,0,0,1,0,0,0,0,0,1}};
        Solution547 solution547 = new Solution547();
        int res = solution547.findCircleNum(isConnected);
        System.out.println(res);
    }
}
