package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/18 14:40
 * @description:
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半;
 * 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 最后的误差判断是小数点6位
 */
public class Path {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            double sum = 0;
            double temp = n;
            for(int i = 0; i < 5; i++){
                sum += temp * 2;
                temp = temp / 2;
            }
            //第一次按它先弹上来再掉下去算的，要减掉第一次弹上来的路程
            sum -= n;
            System.out.printf("%.6f\n",sum);
            System.out.printf("%.6f\n",temp);
        }
    }
}
