package array;

/**
 * @author 苏若墨
 * 问题：找出10000以下的亲和数（两个数互为对方因子之和）
 */
public class QinHeShu {
    public static void main(String[] args) {
        int b;
        int n=10000;
        int sum1=0,sum2=0;
        long end=0;
        long start=System.currentTimeMillis();
        for(int a=0;a<n;a++){
          b=sumYin(a);
          if(b>a&&sumYin(b)==a){
              System.out.println(a+"和"+b+"是亲密数");
          }
       }
        end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"(ms)");
    }
    private static int sumYin(int a) {
        int sum=0;
        //找出数字a的真约数之和
        for(int i=1;i<a;i++) {
            if(a%i==0) {
                sum+=i;
            }
        }
        return sum;
    }
}
