package binary_trees.traversals.LevelByLevel;

import binary_trees.BinaryTree;

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
        tree.root.left.right = temp;

//        tree.levelBylevel();
//        tree.inOrder();
        tree.iterativePostOrder();

    }


}
