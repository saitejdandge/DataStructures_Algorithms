package linked_list.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private final Deque<Node> list = new LinkedList<>();
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node n = map.get(key);
            list.remove(n);
            list.addFirst(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            list.remove(map.get(key));
            list.addFirst(map.get(key));
            return;
        }
        Node node = new Node(key, value);
        if (list.size() == capacity) {
            Node n = list.removeLast();
            map.remove(n.key);
        }
        list.addFirst(node);
        map.put(key, node);
    }

    private class Node {
        int value;
        int key;

        Node(int key, int v) {
            this.value = v;
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */