package tree;

/**
 * @author: suruomo
 * @date: 2020/11/18 10:50
 * @description: 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 */
public class Trie {
    /**
     *每一个结点的可能链接，为26个字母
     */
    private Trie[] next =new Trie[26];
    /**
     * 当前结点是否是一个字符串的结尾
     */
    private boolean isEnd=false;

    public Trie(){}

    /**
     * 插入字符串
     * @param word
     */
    public void insert(String word){
        Trie root=this;
        char[] words=word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (root.next[words[i]-'a']==null){
                root.next[words[i]-'a']=new Trie();
            }
            root=root.next[words[i]-'a'];
        }
        root.isEnd=true;
    }

    /**
     * 查找字符串
     * @param word
     * @return
     */
    public boolean search(String word){
        Trie root=this;
        char[] words=word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (root.next[words[i]-'a']==null){
               return false;
            }
            root=root.next[words[i]-'a'];
        }
        return root.isEnd;
    }

    /**
     * 前缀查找
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix){
        Trie root=this;
        char[] words=prefix.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (root.next[words[i]-'a']==null){
              return false;
            }
            root=root.next[words[i]-'a'];
        }
        return true;
    }
}
