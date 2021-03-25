package dynamic_programming.general;

import java.util.ArrayList;
import java.util.Arrays;

public class WaysToDecode2 {

    public static void main(String[] args) {
        String input = "1114";
        int[] dp = new int[input.length()];
        Arrays.fill(dp, -1);
        System.out.println(waysToDecode(0, input, dp, new ArrayList<>()));
    }

    public static int waysToDecode(int i, String str, int[] dp, ArrayList<String> buffer) {


        if (i == str.length()) {
            System.out.println(buffer);
            return 1;
        }

        if (str.charAt(i) == '0')
            return 0;
//
//        if (dp[i] != -1)
//            return dp[i];

        int count = 0;
        String choice1 = str.substring(i, i + 1);
        buffer.add(choice1);
        count += waysToDecode(i + 1, str, dp, buffer);
        buffer.remove(choice1);

        if (i != str.length() - 1) {
            if (str.charAt(i) == '1' || (str.charAt(i) == '2' && Character.getNumericValue(str.charAt(i + 1)) <= 6)) {
                String choice2 = str.substring(i, i + 2);
                buffer.add(choice2);
                count += waysToDecode(i + 2, str, dp, buffer);
                buffer.remove(choice2);
            }
        }
        dp[i] = count;
        return count;
    }
}
