
import java.util.HashMap;

/**
 * @author: suruomo
 * @date: 2021/1/15 10:53
 * @description: 146. LRU 缓存机制
 * 需要：
 * 1.双向链表：双向链表按照被使用的顺序存储了这些键值对，
 * 靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
 * 2.hash表：哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
 */
public class LRUcache {
    /**
     * 双向链表
     */
    class LinkedNode{
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * hash表
     */
    private HashMap<Integer,LinkedNode> cache=new HashMap<>();
    /**
     * 当前链表大小
     */
    private int size;
    /**
     * 链表最大容量
     */
    private int capacity;
    /**
     * 链表头节点
     */
    private LinkedNode head;
    /**
     * 链表尾节点
     */
    private LinkedNode tail;

    /**
     * 1.缓存初始化
     * @param capacity
     */
    public LRUcache(int capacity) {
        this.capacity = capacity;
        this.size=0;
        head=new LinkedNode();
        tail=new LinkedNode();
        head.next=tail;
        tail.pre=tail;
    }

    /**
     * 2.get操作
     * @param key
     * @return
     */
    public int get(int key) {
        LinkedNode node=cache.get(key);
        if (node==null){
            return -1;
        }else {
            // 若key存在，则将该结点移到头部，返回该节点至
            moveToHead(node);
            return node.value;
        }

    }
    /**
     * 3.put操作
     * @param key
     * @param value
     */
    public void put(int key,int value){
        LinkedNode node=cache.get(key);
        // 如果节点不存在
        if (node==null){
            // 创建新节点，添加至hash表中，链表中移到头部，缓存大小加一
            node=new LinkedNode(key,value);
            cache.put(key,node);
            addToHead(node);
            size++;
            // 若缓存大小大于链表容量，则删除尾部节点和对应hash表中值
            if (size>capacity){
                LinkedNode tail=removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else {
            // 如果节点存在，则更新结点值，并将节点移到头部
            node.value=value;
            moveToHead(node);
        }
    }



    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkedNode node) {
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    private void removeNode(LinkedNode node) {
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    private LinkedNode removeTail() {
        LinkedNode res=tail.pre;
        removeNode(res);
        return res;
    }
}
