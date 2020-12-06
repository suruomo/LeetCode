package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/6 11:31
 * @description: 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row=new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                if (j==0||j==i){
                    row.add(1);
                }else {
                    row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
