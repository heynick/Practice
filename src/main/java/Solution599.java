import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/3/15 11:02
 * @Description 两个列表的最小索引综合
 */
public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {

        int lenList1 = list1.length;
        int lenList2 = list2.length;

        if (lenList1 > lenList2) {
            return findRestaurant(list2, list1);
        }


        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>(lenList1);

        for (int i = 0; i < lenList1; i++) {
            hashMap.put(list1[i], i);
        }

        for (int j = 0; j < lenList2; j++) {
            if (hashMap.containsKey(list2[j])) {
                int curMin = j + hashMap.get(list2[j]);
                if (curMin == min) {
                    res.add(list2[j]);
                } else if (curMin < min) {
                    min = curMin;
                    res.clear();
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[res.size()]);


    }


    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Solution599 solution599 = new Solution599();
        String[] res = solution599.findRestaurant(list1, list2);
        Arrays.stream(res).forEach(System.out::println);
    }
}
