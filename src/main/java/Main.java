import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 10:29
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
           String s=sc.nextLine();
           System.out.println(get(s));
        }
    }

    private static String get(String s) {
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else {
                continue;
            }
        }
        StringBuilder stringBUilder=new StringBuilder();
        for(Character c:set){
            stringBUilder.append(c);
        }
        return stringBUilder.toString();
    }
}
