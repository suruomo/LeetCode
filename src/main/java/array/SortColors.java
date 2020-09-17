package array;

/**
 * @author: suruomo
 * @date: 2020/9/17 10:01
 * @description: 75 颜色分类
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
    }

    private static void sortColors(int[] nums) {
        //记录0的最右边界
        int p0=0;
        //记录2的最左边界
        int p2= nums.length-1;
        //当前位置
        int cur=0;
        int temp=0;
        while (cur<=p2){
            if(nums[cur]==0){
                // 交换第 p0个和第cur个元素
                // 同时右移p0,cur
                // cur左边一定是0，1所以cur右移
                temp=nums[p0];
                nums[p0]=nums[cur];
                nums[cur]=temp;
                p0++;
                cur++;
            }else if (nums[cur]==2){
                // 交换第k个和第cur个元素
                // p2左移
                // cur不右移是因为交换过来的元素可能是2，需要继续判断
                temp=nums[cur];
                nums[cur]=nums[p2];
                nums[p2]=temp;
                p2--;
            }
            //如果当前位置为1，右移cur，判断下一位
            else {
                cur++;
            }
        }
    }
}
