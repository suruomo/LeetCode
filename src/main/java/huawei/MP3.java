package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 13:49
 * @description:
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，
 * 用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 *
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，
 */
public class MP3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=Integer.valueOf(sc.next());
            String order=sc.next();
            process(num,order);
        }
        sc.close();
    }

    private static void process(int num, String order) {
        // 当前光标
        int cur=1;
        // 当前页开始行
        int start=1;
        // 当前页结束行
        int end=4;
        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i)=='U'){
                // 第一页第一行
                if (cur==1){
                    cur=num;
                    start=num-3;
                    end=num;
                }else {
                    // 如果是一般页第一行
                    if (cur==start){
                        start--;
                        end--;
                    }
                    cur--;
                }
            }else if (order.charAt(i)=='D'){
                // 最后一页最后一个
                if (cur==num){
                    cur=1;
                    start=1;
                    end=4;
                }else {
                    // 如果是一般页最后一个
                    if (cur==end){
                        start++;
                        end++;
                    }
                    cur++;
                }
            }
        }
        if (num<4){
            int i=1;
            while (i<=num){
                System.out.print(i+" ");
                i++;
            }
            System.out.println();
        }else {
            System.out.println(start+" "+(start+1)+" "+(start+2)+" "+end);
        }
        System.out.println(cur);
    }
}
