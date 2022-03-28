/**
 * @Author HEYNICK
 * @Date 2022/3/28 21:24
 * @Description default
 */
public class SolutionOffer62 {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public static void main(String[] args) {
        int n = 5, m =3;
        SolutionOffer62 solutionOffer62 = new SolutionOffer62();
        int res = solutionOffer62.lastRemaining(n, m);
        System.out.println(res);
    }
}
