package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private final Node root;

    Trie() {
        root = new Node();
    }

    public void add(String s, int index) {
        add(s.toCharArray(), 0, root, index);
    }

    public int delete(String s) {
        return delete(s.toCharArray(), 0, root);
    }

    public List<Integer> search(String query) {
        return search(query.toCharArray(), 0, root);
    }

    private List<Integer> search(char[] chars, int currentIndex, Node prev) {
        if (prev == null)
            return null;
        if (currentIndex == chars.length) {
            return prev.startIndices;
        }
        return search(chars, currentIndex + 1, prev.map.get(chars[currentIndex]));

    }

    private int delete(char[] chars, int currentIndex, Node prev) {
        if (prev == null)
            return -1;
        if (currentIndex == chars.length) {
            prev.startIndices.clear();
            return 1;
        }
        return delete(chars, currentIndex + 1, prev.map.get(chars[currentIndex]));
    }

    private void add(char[] chars, int currentIndex, Node prev, int wordIndex) {
        if (currentIndex == chars.length) {
            prev.startIndices.add(wordIndex);
            return;
        }
        if (!prev.map.containsKey(chars[currentIndex]))
            prev.map.put(chars[currentIndex], new Node());

        add(chars, currentIndex + 1, prev.map.get(chars[currentIndex]), wordIndex);
    }


    private static class Node {
        Map<Character, Node> map;
        List<Integer> startIndices;

        Node() {
            map = new HashMap<>();
            startIndices = new ArrayList<>();
        }

    }
}
