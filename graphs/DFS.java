package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

        String[] airports = "PHX BKK OKC JFK LAX MEX EZE HEL LOS LAP LIM".split(" ");

        String[][] routes = {
                {"PHX", "LAX"},
                {"PHX", "JFK"},
                {"JFK", "OKC"},
                {"JFK", "HEL"},
                {"JFK", "LOS"},
                {"MEX", "LAX"},
                {"MEX", "BKK"},
                {"MEX", "LIM"},
                {"MEX", "EZE"},
                {"LIM", "BKK"},
        };
        solve(airports, routes);
    }

    public static void solve(String[] aiports, String[][] routes) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String airport : aiports) {
            map.put(airport, new ArrayList<>());
        }
        for (String[] route : routes) {
            map.get(route[0]).add(route[1]);
            map.get(route[1]).add(route[0]);
        }
        System.out.println(map);
        HashSet<String> visited = new HashSet<>();
        dfs(aiports[0], aiports[1], map, visited);

    }

    public static void dfs(String source, String destination, HashMap<String, List<String>> map, HashSet<String> visited) {

        visited.add(source);
        System.out.println(source);
        for (String s : map.get(source)) {
            if (s.equals(destination)) {
                System.out.println("Found");
                return;
            }
            if (!visited.contains(s)) {
                dfs(s, destination, map, visited);
            }
        }
    }
}
