package heaps;

public class BuildingHeapFromArray {
    public static void main(String[] args) {

        int res[] = build(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9});
        for (int i : res)
            System.out.print(i + " ");
    }

    public static int[] build(int a[]) {
        int n = a.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(a, i);
        }
        return a;
    }

    private static void heapify(int[] a, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int n = a.length;
        if (left == n - 1 && a[left] > a[i]) {
            swap(left, i, a);
            return;
        } else if (right == n - 1 && a[right] > a[i]) {
            swap(right, i, a);
            return;
        } else if (left >= n || right >= n)
            return;
        else if (a[i] < a[left] || a[right] > a[i]) {
            if (a[left] > a[right]) {
                swap(left, i, a);
                heapify(a, left);
            } else {
                swap(right, i, a);
                heapify(a, right);

            }
        }

    }

    private static void swap(int left, int i, int[] a) {
        int temp = a[left];
        a[left] = a[i];
        a[i] = temp;
    }
}
