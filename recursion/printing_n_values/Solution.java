package recursion.printing_n_values;

public class Solution {

    public static void main(String[] args) {
        print(10);
        System.out.println();
        printRev(10);
    }

    // printing 1 to n
    public static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }

    // printing n to 1
    public static void printRev(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printRev(n - 1);
    }
}
