import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/3/24 11:29
 * @Description 图片平滑器
 */
public class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                int sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum+= img[x][y];
                        }
                    }
                }
                res[i][j] = sum / num;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] img = {{1,1,1},{1,0,1},{1,1,1}};
        Solution661 solution661 = new Solution661();
        int[][] res = solution661.imageSmoother(img);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }
}
