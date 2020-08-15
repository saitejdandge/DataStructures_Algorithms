package LCS;

import java.util.HashMap;

public class IsInterLeaving {

    public static HashMap<String,Boolean>map=new HashMap<>();
    public static void main(String[] args) {
        System.out.println(solve("ab","xd","axbd"));
    }
    public static boolean solve(String a, String b, String c) {
        if (a.isEmpty() && b.isEmpty() && c.isEmpty())
            return true;
        if (c.isEmpty())
            return false;
        if (map.get(a + "|" + b + "|" + c) != null)
            return map.get(a + "|" + b + "|" + c);
        boolean first = (!a.isEmpty() && (a.charAt(0) == c.charAt(0))) && solve(a.substring(1), b, c.substring(1));
        boolean second = (!b.isEmpty() && (b.charAt(0) == c.charAt(0))) && solve(a, b.substring(1), c.substring(1));
        map.put(a + "|" + b + "|" + c, first || second);
        return first || second;
    }
}