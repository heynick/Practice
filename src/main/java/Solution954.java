import java.util.*;

/**
 * @Author HEYNICK
 * @Date 2022/4/1 15:08
 * @Description 二倍数对数组
 */
public class Solution954 {
    public static void main(String[] args) {
        int[] arr = {4, -2, 2, -4};
        Solution954 solution954 = new Solution954();
        boolean ans = solution954.canReorderDoubled(arr);
        System.out.println(ans);

    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }


}
