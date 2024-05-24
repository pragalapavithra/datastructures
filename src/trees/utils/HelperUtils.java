package trees.utils;

import trees.binaryTrees.BinarySearchTree;

public class HelperUtils {
    public static void binaryTreeInsertionHelper(BinarySearchTree tree) {


        // Inserting nodes
        tree.root = tree.insertIntoBST(tree.root, 50);
        tree.insertIntoBST(tree.root, 30);
        tree.insertIntoBST(tree.root, 20);
        tree.insertIntoBST(tree.root, 40);
        tree.insertIntoBST(tree.root, 70);
        tree.insertIntoBST(tree.root, 60);
        tree.insertIntoBST(tree.root, 80);
    }
}
