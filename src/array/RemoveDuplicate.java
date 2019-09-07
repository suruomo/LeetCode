import java.util.HashSet;
/**
 * 问题：Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * 思路：hashset存储不重复集合
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] a={1,1,2};
        remove(a);
    }

    private static void remove(int[] a) {
        HashSet<Integer> hashSet=new HashSet();
        for(int i:a){
            hashSet.add(i);
        }
        System.out.println(hashSet.size());
    }
}
