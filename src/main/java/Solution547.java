/**
 * @Author HEYNICK
 * @Date 2022/3/9 16:56
 * @Description 朋友圈
 */
public class Solution547 {
    public int findCircleNum(int[][] M){
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);



    }

    private class UnionFind {

    }


    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        Solution547 solution547 = new Solution547();
        int res = solution547.findCircleNum(isConnected);
        System.out.println(res);
    }
}
