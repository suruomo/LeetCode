package interview;

/**
 * @author: suruomo
 * @date: 2021/4/12 13:01
 * @description: 将给出的32位整数x翻转。
 */
public class ReverseInteger {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int reverse (int x) {
        boolean f=false;
        if (x<0){
            x=-x;
            f=true;
        }
        StringBuilder s=new StringBuilder(String.valueOf(x));
        s.reverse();
        if (f){
            return Integer.valueOf("-"+s.toString());
        }
        return Integer.valueOf(s.toString());
    }
}
