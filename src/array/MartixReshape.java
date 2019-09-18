package array;

/**
 * 问题：给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * @author 苏若墨
 */
public class MartixReshape {
    public static void main(String[] args) {
        int[][] nums={{1,2},{3,4},{5,6}};
        int r=2,c=3;
        martixReshape(nums,r,c);
    }

    private static int[][] martixReshape(int[][] nums, int r, int c) {
        int[][] res=new int[r][c];
        int rows=0,col=0;
        if(nums.length==0||r*c!= nums.length*nums[0].length){
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;i<nums[0].length;j++){
                res[rows][col]=nums[i][j];
                col++;
                //当前行等于制定行数时，换行
                if(col==c){
                    rows++;
                    col=0;
                }
            }
        }
        return res;
    }
}
