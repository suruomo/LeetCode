package interview;

/**
 * @author: suruomo
 * @date: 2021/4/2 11:25
 * @description: 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 */
public class JinZhi {
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        if(M == 0) {
            return "0";
        }
        String s = "0123456789ABCDEF";
        StringBuffer sb = new StringBuffer();
        boolean f = false;
        // 负数
        if(M < 0){
            f = true;
            M = -M;
        }
        // M不断取余N,除以N
        while(M != 0){
            sb.append(s.charAt(M%N));
            M /= N;
        }
        if(f) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
