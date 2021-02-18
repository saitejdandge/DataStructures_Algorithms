package graphs;

import java.util.*;

public class Topological {
    public static Stack<Integer> stack;

    public static void main(String[] args) {
        stack = new Stack<>();
        TreeMap<Integer, List<Integer>> graph = new TreeMap<>();
        graph.put(0, Arrays.asList(new Integer[]{2, 1}));
        graph.put(2, Arrays.asList(new Integer[]{3}));
        graph.put(1, Arrays.asList(new Integer[]{3,5}));
        graph.put(3, null);
        graph.put(5, null);
        for (Integer i : graph.keySet()) {
            System.out.println(i);
            dfs(i, new HashSet<>(), graph, stack);

            System.out.println(stack);
        }

    }

    public static void dfs(Integer curr, HashSet<Integer> set, Map<Integer, List<Integer>> graph, Stack<Integer> stack) {
        set.add(curr);
        if (graph.get(curr) != null)
            for (Integer i : graph.get(curr)) {
                if (!set.contains(i)) {
                    dfs(i, set, graph, stack);
                }
            }
        System.out.println("current "+curr);
        stack.add(curr);
    }
}
