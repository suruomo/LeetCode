package bit;

/**
 * @author: suruomo
 * @date: 2021/5/7 16:04
 * @description: 1486 数据异或操作
 */
public class XorOperation {
    public int xorOperation(int n,int start){
        int[] nums=new int[n];
        int ans=0;
        for (int i = 0; i<n ; i++) {
            nums[i]=start+2*i;
            ans^=nums[i];
        }
        return ans;
    }
}
