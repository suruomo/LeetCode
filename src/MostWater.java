/*
问题：Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
思路：双重循环两两比较
 */
public class MostWater {
    public static void main(String[] args) {
        int t[]={1,8,6,2,5,4,8,3,7};
        int max=0;
        for(int i=0;i<t.length;i++){
            for(int j=i+1;j<t.length;j++){
                int result=Math.abs(i - j) * Math.min(t[i], t[j]);
                if(result>=max){
                     max=result;
                }
            }
        }
        System.out.println("可承受的最大水量是："+max);
    }
}
