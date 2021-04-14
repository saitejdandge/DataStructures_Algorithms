package graphs.has_path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

        String[] airports = "PHX BKK OKC JFK LAX MEX EZE HEL LOS LAP LIM IND".split(" ");

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
                {"HEL", "BKK"},
                {"LIM", "BKK"},
        };
        findTrack(airports, routes);
    }

    public static void findTrack(String[] airports, String[][] routes) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String airport : airports) {
            map.put(airport, new ArrayList<>());
        }
        for (String[] route : routes) {
            map.get(route[0]).add(route[1]);
            map.get(route[1]).add(route[0]);
        }
        List<String> set = new ArrayList<>();
        multipleTrack(airports[0], "XX", map, set);
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        singleTrack(airports[0], "BKK", map, set);
    }

    //prints multiple paths, by backtracking
    public static void multipleTrack(String source, String destination, HashMap<String, List<String>> map, List<String> visited)

     {
        if (source.equals(destination)) {
            visited.add(destination);
            System.out.println(visited);
            visited.remove(destination);
            return;
        }
        visited.add(source);
        for (String s : map.get(source)) {
            if (!visited.contains(s)) {
                multipleTrack(s, destination, map, visited);
            }
        }
        visited.remove(source);
    }

    //hasPath replacement
    public static boolean singleTrack(String source, String destination, HashMap<String, List<String>> map, List<String> visited) {
        if (source.equals(destination)) {
            visited.add(destination);
            System.out.println(visited);
            visited.remove(destination);
            return true;
        }
        visited.add(source);
        for (String s : map.get(source)) {
            if (!visited.contains(s) && singleTrack(s, destination, map, visited)) {
                return true;
            }
        }
        return false;
    }

}
