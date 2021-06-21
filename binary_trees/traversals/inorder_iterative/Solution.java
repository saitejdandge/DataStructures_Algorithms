package binary_trees.traversals.inorder_iterative;

import binary_trees.BinaryTree;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {


        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new BinaryTree.Node<>(10);
        tree.root.left = new BinaryTree.Node<>(20);
        tree.root.right = new BinaryTree.Node<>(30);
        tree.root.right.right = new BinaryTree.Node<>(60);

        tree.root.left.left = new BinaryTree.Node<>(40);
        BinaryTree.Node<Integer> temp = new BinaryTree.Node<>(50);
        temp.left = new BinaryTree.Node<>(70);
        temp.right = new BinaryTree.Node<>(80);
        tree.root.left.left.left = temp;

        tree.iterativeInOrder();

        Stack<BinaryTree.Node<Integer>> stack = new Stack<>();
        stack.add(tree.root);
        while (!stack.isEmpty()) {
            System.out.println(tree.nexIterativeInOrder(stack));
            stack.pop();
        }

    }

}
