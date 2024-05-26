package trees.binaryTrees;

import trees.binaryTrees.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

import static trees.utils.HelperUtils.binaryTreeInsertionHelper;

public class IterativeDFS {

    public void iterativeInOrder(BinarySearchTree.TreeNode node) {
        Stack<BinarySearchTree.TreeNode> st = new Stack<>();
        while (true) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            if (st.isEmpty()) {
                break;
            }
            node = st.pop();
            System.out.print(node.val + " ");
            node = node.right;
        }
    }

    public void iterativePreOrder(BinarySearchTree.TreeNode node) {
        Stack<BinarySearchTree.TreeNode> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty()){
            node = st.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
        }
        System.out.println();
    }
    public void iterativePostOrder(TreeNode node){
        Stack<BinarySearchTree.TreeNode> st1 = new Stack<>();
        Stack<BinarySearchTree.TreeNode> st2 = new Stack<>();
        if(node == null) return ;
        st1.push(node);
        while(!st1.isEmpty()){
            node = st1.pop();
            st2.push(node);
            if(node.left!=null){
                st1.push(node.left);
            }
            if(node.right!=null){
                st1.push(node.right);
            }
        }
        while(!st2.isEmpty()){
            node=st2.pop();
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
    class Pair{
        TreeNode val;
        int count;

        public Pair(TreeNode val,int count) {
            this.val = val;
            this.count = count;
        }
    }
    public  void PrePostInOrderTraversal(TreeNode root){
        if(root==null)return ;
        ArrayList<TreeNode> inOrder=new ArrayList<>();
        ArrayList<TreeNode> preOrder=new ArrayList<>();
        ArrayList<TreeNode> postOrder=new ArrayList<>();
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair it = st.pop();
            if(it.count == 1){
                inOrder.add(it.val);
                it.count++;
                st.push(it);
                if(it.val.left!=null){
                    st.push(new Pair(it.val.left,1));
                }
            }
            else if(it.count ==2){
                preOrder.add(it.val);
                it.count++;
                st.push(it);
                if(it.val.right!=null){
                    st.push(new Pair(it.val.right,1));
                }
            }
            else{
                postOrder.add(it.val);
            }
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        IterativeDFS obj = new IterativeDFS();
        binaryTreeInsertionHelper(tree);
        System.out.println("Iterative InOrder");
        obj.iterativeInOrder(tree.root);
        System.out.println("Iterative PreOrder");
        obj.iterativePreOrder(tree.root);
        System.out.println("Iterative PostOrder");
        obj.iterativePostOrder(tree.root);
    }
}
