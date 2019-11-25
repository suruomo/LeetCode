package dynamicplanning;

import java.util.Scanner;

/**
 * 整数规划
 * @author 苏若墨
 */
public class IntegerDivision {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入待划分整数n和最大划分整数m：");
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println("可划分数："+division(n,m));
    }

    private static int division(int n, int m) {
        int[][] num=new int[n+1][m+1];
        //当n或m==1时，num[][]=1,
        //当n=0时，也为1，而当m=0时，则不为1
        for(int i=0;i<=n;i++){
            num[i][1]=1;
        }
        for(int j=0;j<=m;j++){
            num[1][j]=1;
            num[0][j]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=m;j++){
                if(i>=j){
                    num[i][j]=num[i-j][j]+num[i][j-1];
                }
                else{
                    num[i][j]=num[i][i];
                }
            }
        }
        return num[n][m];
    }
}
