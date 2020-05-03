package greedyalgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 问题：假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * @author 苏若墨
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g={1,2,3};
        int[] s={1,1};
        System.out.println(findContentChildren(g,s));
    }

    private static int findContentChildren(int[] g, int[] s) {
        if(g==null&&s==null){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        while(i<g.length&&j<s.length){
//            当前饼干满足当前小孩
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
