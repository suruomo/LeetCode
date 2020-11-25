package sort;

/**
 * @author: suruomo
 * @date: 2020/11/25 10:12
 * @description: 1370. 上升下降字符串
 *
 * 思路：桶计数
 */
public class SortString {
    public String sortString(String s) {
        // 桶
        int[] num=new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-'a']++;
        }
        StringBuffer ret=new StringBuffer();
        while (ret.length()<s.length()){
            //升序
            for (int i = 0; i < 26; i++) {
                if (num[i]>0){
                    ret.append((char)(i+'a'));
                    num[i]--;
                }
            }
            // 降序
            for (int i = 25; i >=0; i++) {
                if (num[i]>0){
                    ret.append((char)(i+'a'));
                    num[i]--;
                }
            }
        }
        return ret.toString();
    }
}
