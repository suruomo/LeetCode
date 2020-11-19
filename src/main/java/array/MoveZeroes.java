package array;

/**
 * @author: suruomo
 * @date: 2020/11/19 11:57
 * @description: 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // q指示非0元素，cur移动
        int q=0,cur=0;
        while (cur<nums.length){
            if (nums[cur]!=0){
                nums[q++]=nums[cur++];
            }else {
               cur++;
            }
        }
        while (q<nums.length){
            nums[q++]=0;
        }
    }
}
