import Struct.Bank;

/**
 * @Author HEYNICK
 * @Date 2022/3/18 16:42
 * @Description  简易银行系统
 */
public class Solution2043 {



    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};
        Bank obj = new Bank(balance);
        boolean param_1 = obj.transfer(5, 1, 20);
        boolean param_2 = obj.deposit(5,20);
        boolean param_3 = obj.withdraw(3,10);

    }
}
