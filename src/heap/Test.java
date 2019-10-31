package heap;

/**
 * @author 苏若墨
 */
public class Test {
    public static void main(String[] args) {
        Heap<Integer> h=new Heap("空白位");
        int[] nums={3,7,1,6,2,9,0};
        for(int i=0;i<nums.length;i++){
            h.insert(nums[i]);
        }
        System.out.println(h.getCurrentSize());
        System.out.println(h.getList());
        h.deleteMin();
        System.out.println(h.getList());
    }
}
