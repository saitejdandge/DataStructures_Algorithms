package bst;

public class Solution {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        bst.add(10);
        bst.add(6);
        bst.add(15);
        bst.add(4);
        bst.add(8);
        bst.add(12);
        bst.remove(6);
        bst.remove(8);
        bst.add(20);
        System.out.println(); 

        bst.remove(10);
        bst.print();
        // for (int i = -3; i < 11; i++)
        // System.out.println(i + " " + bst.contains(i));
    }
}
