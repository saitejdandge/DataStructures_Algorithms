package recursion.differnt_styles_of_braces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Styles {

    static HashMap<Character, List<Character>> map = new HashMap<>();

    public static void main(String[] args) {

        solve("()))", "");
    }

    public static void initMap() {

        List<Character> list = new ArrayList<>();
        list.add('{');
        list.add('[');

        map.put('(', list);

        List<Character> list2 = new ArrayList<>();
        list2.clear();
        list2.add('}');
        list2.add(']');

        map.put(')', list2);
    }

    public static void solve(String input, String output) {
        if (map == null || map.size() == 0) {
            initMap();
        }
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        for (Character c : map.get(input.charAt(0)))
            solve(input.substring(1), output + c);
    }

}
