import Struct.AllOne;

import java.security.Key;

/**
 * @Author HEYNICK
 * @Date 2022/3/21 20:39
 * @Description 全O(1)的数据结构
 */
public class Solution432 {
    public static void main(String[] args) {
        AllOne obj = new AllOne();
        String key = "hello";
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        // 返回 "hello"
        String res1 = allOne.getMaxKey();
        // 返回 "hello"
        String res2 = allOne.getMinKey();
        allOne.inc("leet");
        // 返回 "hello"
        String res3 = allOne.getMaxKey();
        // 返回 "leet"
        String res4 = allOne.getMinKey();
        System.out.println(res1 + "," + res2 + "," + res3 + "," + res4);
    }
}
