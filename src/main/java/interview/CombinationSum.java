package interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/4/26 10:21
 * @description: 给出一组候选数 C 和一个目标数T，找出候选数中起来和等于 T 的所有组合。
 * C 中的每个数字在一个组合中只能使用一次。
 * 注意：
 * 组合中的数字要按非递增排序
 * 组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引。
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(num == null || num.length==0 || target<0) {
            return res;
        }
        Arrays.sort(num);
        dfs(num,target,res,arr,0);
        return res;
    }
    void dfs(int[] num,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> arr,int start){
        if(target==0){
            res.add(new ArrayList<Integer>(arr));
            return;
        }
        if(start >= num.length) {
            return;
        }
        for(int i=start;i<num.length;i++){
            if(i > start && num[i] == num[i-1]) {
                continue;
            }
            if(num[i] <= target){
                arr.add(num[i]);
                dfs(num,target-num[i],res,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
        return;
    }
}
