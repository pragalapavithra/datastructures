package trees.binaryTrees;

import java.util.ArrayList;

import static trees.utils.HelperUtils.binaryTreeInsertionHelper;

/***
 * Time Complexity O(n)
 * Space Complexity O(h)
 *
 */
public class isValidBST {
    ArrayList<Integer> arrList = new ArrayList();

    public void inOrder(BinarySearchTree.TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            arrList.add(root.val);
            inOrder(root.right);
        }

    }

    //Solution 1
    public boolean isValidBST(BinarySearchTree.TreeNode root) {
        inOrder(root);
        for (int i = 0; i < arrList.size() - 1; i++) {
            if (arrList.get(i) > arrList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    //Solution 1 restricting to specific range

    public boolean isValidBST2(BinarySearchTree.TreeNode root) {
        return isBSTValidHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTValidHelper(BinarySearchTree.TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val < minValue || root.val > maxValue) {
            return false;
        }
        return isBSTValidHelper(root.left, root.val - 1, maxValue)
                && isBSTValidHelper(root.right, minValue, root.val + 1);
    }

    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        isValidBST obj = new isValidBST();
        binaryTreeInsertionHelper(tree);
        System.out.println(obj.isValidBST(tree.root));
    }


}
