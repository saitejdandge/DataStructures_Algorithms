package linked_list;

public class LRUCacheMain {

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(4);
        lruCache.put(1,8);
        lruCache.put(2,2);
        lruCache.put(3,2);
        lruCache.put(4,5);
        
        System.out.println(lruCache.get(1));
        
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(14));
        System.out.println(lruCache.get(41));

    }
    
}
