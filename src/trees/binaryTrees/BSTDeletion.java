package trees.binaryTrees;


import trees.binaryTrees.BinarySearchTree.TreeNode;

import static trees.utils.HelperUtils.binaryTreeInsertionHelper;

public class BSTDeletion {
    public BinarySearchTree.TreeNode deleteBST(TreeNode node, int key){
        if(node ==null) return null;
        if(node.val == key){
            return helper(node);
        }
        TreeNode dummy = node;
        while(node!=null){
            if(node.val>key){
                if(node.left!=null && node.left.val==key){
                     node.left = helper(node.left);
                     break ;
                }else{
                    node = node.left;
                }
            }else{
                if(node.right!=null && node.right.val==key){
                     node.right = helper(node.right);
                     break;
                }else{
                    node = node.right;
                }
            }
        }
        return dummy;
    }
    public static BinarySearchTree.TreeNode helper(BinarySearchTree.TreeNode node){
        if(node.left==null){
            return node.right;
        }
        if(node.right==null){
            return node.left;
        }
        BinarySearchTree.TreeNode rightChild= node.right;
        TreeNode rightMost = findRightMost(node.left);
        rightMost.right = rightChild;
        return node.left;
    }
    public static TreeNode findRightMost(TreeNode node){
        if(node.right!=null){
            node = node.right;
        }
        return node;
    }
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        BSTDeletion obj = new BSTDeletion();
        binaryTreeInsertionHelper(tree);
        System.out.println("Deletion");
        obj.deleteBST(tree.root,70);
        System.out.println("Iterative PreOrder After Deletion");
        IterativeDFS obj1 = new IterativeDFS();
        obj1.iterativePreOrder(tree.root);

    }
}
