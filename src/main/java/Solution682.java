/**
 * @Author HEYNICK
 * @Date 2022/3/26 22:53
 * @Description 棒球比赛
 */
public class Solution682 {
    static int[] nums = new int[1010];
    public int calPoints(String[] ops) {
        int n = ops.length, idx = 0;
        for (int i = 0; i < n; i++, idx++) {
            if (ops[i].equals("+")) {
                nums[idx] = nums[idx - 1] + nums[idx - 2];
            } else if (ops[i].equals("D")) {
                nums[idx] = nums[idx - 1] * 2;
            } else if (ops[i].equals("C")) {
                idx -= 2;
            } else {
                nums[idx] = Integer.parseInt(ops[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < idx; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] ops = {"8373","C","9034","-17523","D","1492","7558","-5022","C","C","+","+","-16000","C","+","-18694","C","C","C","-19377","D","-25250","20356","C","-1769","-8303","C","-25332","29884","C","+","C","-29875","-15374","C","+","14584","13773","+","17037","-28248","+","16822","D","+","+","-19357","-26593","-8548","4776","D","-8244","378","+","-19269","-25447","18922","-16782","2886","C","-17788","D","-22256","C","308","-9185","-19074","1528","28424","D","8658","C","7221","-13704","8995","-21650","22567","-29560","D","-9807","25632","6817","28654","D","-18574","C","D","20103","7875","C","9911","23951","C","D","C","+","18219","-20922","D","-24923"};
        Solution682 solution682 = new Solution682();
        int res = solution682.calPoints(ops);
        System.out.println(res);
    }
}
