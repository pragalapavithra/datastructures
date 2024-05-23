package trees;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    TreeNode root;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val == val){
            return root;
        }
        if(root.val>val){
            return  searchBST(root.left, val) ;
        }else{
            return  searchBST(root.right, val);
        }
    }
    public TreeNode findMin(TreeNode root) {
        if(root ==null){
            return root;
        }
        int minValue = Integer.MAX_VALUE;
        while(root.left!=null){
            minValue = root.val;
            root = root.left;
        }
        return root;
    }

    public TreeNode findMax(TreeNode root) {
        if(root ==null){
            return root;
        }
        int maxValue = 0;
        while(root.right!=null){
            maxValue = root.val;
            root = root.right;
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            if(leftHeight>rightHeight){
                return leftHeight + 1;
            }else{
                return rightHeight +1;
            }
        }
    }

    public void preOrder(TreeNode root) {
        if(root!=null){
           System.out.print(root.val+" ");
           preOrder(root.left);
           preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode element = queue.poll();
            System.out.print(element.val+" ");
            if(element.left!=null){
                queue.add(element.left);
            }
            if(element.right!=null){
                queue.add(element.right);
            }
        }
    }







    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting nodes
        tree.root = tree.insertIntoBST(tree.root, 50);
        tree.insertIntoBST(tree.root, 30);
        tree.insertIntoBST(tree.root, 20);
        tree.insertIntoBST(tree.root, 40);
        tree.insertIntoBST(tree.root, 70);
        tree.insertIntoBST(tree.root, 60);
        tree.insertIntoBST(tree.root, 80);

        int key = 60;

        // Searching in a BST
        if (tree.searchBST(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");

        System.out.println("Min Element ");
        TreeNode minNode = tree.findMin(tree.root);
        System.out.println(minNode.val);

        System.out.println("Max Element ");
        TreeNode maxNode = tree.findMax(tree.root);
        System.out.println(maxNode.val);

        System.out.println("Height/Max Depth Of Tree ");
        System.out.println(tree.maxDepth(tree.root));

        System.out.println("Depth First Traversal");
        System.out.println("Pre Order Traversal");
        tree.preOrder(tree.root);
        System.out.println("Post Order Traversal");
        tree.postOrder(tree.root);
        System.out.println("In Order Traversal");
        tree.inOrder(tree.root);

        System.out.println("Level Order Traversal");
        tree.levelOrder(tree.root);
    }
}
