package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 苏若墨
 * 问题：杨辉三角实现（每个数是它左上方和右上方的数的和）
 * 思路：
 * 动态规划，保存前一行来构造下一行。
 */
public class PscalsTrangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入杨辉三角的行数：");
        int numRows = sc.nextInt();
        generate(numRows);
    }

    private static void generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            System.out.println("");
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        System.out.println(triangle);
    }
}
