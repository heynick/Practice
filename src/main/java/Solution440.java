/**
 * @Author HEYNICK
 * @Date 2022/3/23 15:49
 * @Description 字典序的第K小数字
 */
public class Solution440 {
    public int findKthNumber(int n, int k) {
        // 区间起点 i
        // 位置p
        long p = 1, i = 1;
        // 还未到达第k个元素
        while (p < k) {
            // 以数字i开始的数字个数
            long cnt = getCount(i, n);
            if (p + cnt <= k) {
                // 说明将以数字i开头的数字串都算进去，也不够
                // 数字i要增加到i+1，同时，位置p要跨过count个数字
                p += cnt;
                i++;
            }else {
                // 说明以数字i开头的数字串太多了，并且第k个数字一定是以数字i开头
                // 此时数字i更新为10*i，缩小搜索范围
                // 位置p向前移动一位，因为新数字i字典序向后移动一位了
                p += 1;
                i *= 10;
            }
        }
        return Integer.parseInt(String.valueOf(i));
    }


    private long getCount(long i, long n) {
        // 区间起点 i
        // 区间终点 i + 1
        long res = 0, upper = i + 1;
        // 说明区间没有超过最大数字n
        while (i <= n) {
            res += Math.min(n + 1, upper) - i;
            i *= 10;
            upper *= 10;
        }
        return res;
    }




    public static void main(String[] args) {
        int n = 13, k = 2;
        Solution440 solution440 = new Solution440();
        int res = solution440.findKthNumber(n, k);
        System.out.println(res);


    }


}
