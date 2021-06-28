package offer;

/**
 * @Author: suruomo
 * @Date: 2021/6/28 11:16
 * @Description: 阶乘末尾0的数量
 * 其实是1——n中能查拆出来5的数量
 */
public class TheNumberOf0 {
    public long thenumberof0 (long n) {
        long ans = 0;
        long d = 5;
        while(n>=d)
        {
            ans+=n/d;
            d = d*5;
        }
        return ans;
    }
}
