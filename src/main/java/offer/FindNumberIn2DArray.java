package offer;


/**
 * @author: suruomo
 * @date: 2020/11/27 15:10
 * @description: 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：
 * 从左下角或者右上角开始遍历
 * 时间复杂度O（n+m)
 */
public class FindNumberIn2DArray {
    /**
     * 从右上角开始判断
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int rows= matrix.length;
        int columns=matrix[0].length;
        int row=0;
        int column= columns-1;
        while (row<rows&&column>=0){
            int num= matrix[row][column];
            if (num==target){
                return true;
            }else if(num<target){
                row++;
            }else {
                column--;
            }
        }
        return false;
    }
}
