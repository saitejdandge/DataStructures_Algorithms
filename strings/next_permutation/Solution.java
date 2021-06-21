package strings.next_permutation;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] a;
        a = new int[]{4, 3, 2, 1, 1, 1, 2, 1, 2, 1, 2};
        for (int i = 0; i < 1000; i++) {
            Arrays.stream(next(a)).forEach(x -> System.out.print(x + " "));
            System.out.println();
        }

    }

    public static int[] next(int[] input) {

        if (input.length <= 1)
            return input;

        int i = input.length - 2;
        while (i >= 0 && input[i] >= input[i + 1])
            i--;

        if (i >= 0) {
            int j = input.length - 1;
            while (input[j] <= input[i])
                j--;

            swap(i, j, input);
        }

        reverse(i + 1, input.length - 1, input);

        return input;
    }

    static void swap(int i, int j, int[] input) {

        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void reverse(int i, int j, int[] input) {

        while (i < j) {
            swap(i, j, input);
            i++;
            j--;
        }
    }
}
