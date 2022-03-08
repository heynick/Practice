import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author HEYNICK
 * @Date 2022/3/3 14:29
 * @Description 简化路径
 */
public class Solution71 {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        if (dirs.length == 0) {
            return "/";
        }

        Deque<String> stack = new ArrayDeque<>();
        for (String dir : dirs) {
            if ("".equals(dir) || ".".equals(dir)) {
                continue;
            }
            if ("..".equals(dir)) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
                continue;
            }
            stack.addLast(dir);
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()) {
            stringBuilder.append("/");
        }
        while (!stack.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append( stack.removeLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        Solution71 solution71 = new Solution71();
        String res = solution71.simplifyPath(path);
        System.out.println(res);
    }
}
