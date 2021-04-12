package interview;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: suruomo
 * @date: 2021/4/12 10:16
 * @description: 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 */
public class MergeInterval {
    public class Interval{
        int start;
        int end;
        Interval(){
            start=0;
            end=0;
        }
        Interval(int s,int e){
            start=s;
            end=e;
        }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list=new ArrayList<>();
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int len=intervals.size();
        int j=0;
        while (j<len){
            int left=intervals.get(j).start;
            int right=intervals.get(j).end;
            while (j<len-1&&intervals.get(j+1).start<=right){
                right=Math.max(intervals.get(j+1).end,right);
                j++;
            }
            list.add(new Interval(left,right));
            j++;
        }
        return list;
    }
}
