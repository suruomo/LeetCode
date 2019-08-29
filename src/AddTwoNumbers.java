import java.util.ArrayList;
import java.util.List;

/**
 * @author 苏若墨
 *  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(5);
        List<Integer> list2=new ArrayList<>();
        list2.add(5);
        list2.add(8);
        list2.add(4);
        addTwoNumbers(list1,list2);
    }

    private static void addTwoNumbers(List<Integer> list1, List<Integer> list2) {
        List<Integer> list3=new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            int n=list1.get(i)+list2.get(i);
            if(n<10){
                list3.add(n);
            }
            else{
                int z=n%10;
                list3.add(z);
            }
        }
        for(int i=0;i<list1.size();i++){
            System.out.println("list1:"+list1.get(i));
            System.out.println("list2:"+list2.get(i));
            System.out.println("list3:"+list3.get(i));
        }
    }
}
