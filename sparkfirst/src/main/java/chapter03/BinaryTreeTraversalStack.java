package chapter03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeTraversalStack {


    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();

        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }


    public static void preOrderTraveralWithStack(TreeNode root){
            Stack<TreeNode> stack=new Stack<TreeNode>();
            TreeNode treeNode=root;
            while(  treeNode!=null || !stack.isEmpty()){
                while(treeNode!=null){
                    System.out.println(treeNode.data);
                    stack.push(treeNode);
                    treeNode=treeNode.leftChild;
                }
                if(!stack.isEmpty()){
                    treeNode=stack.pop();
                    treeNode=treeNode.rightChild;
                }

            }


    }

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4,}));
        TreeNode treeNode = createBinaryTree(inputList);
        preOrderTraveralWithStack(treeNode);

        System.out.println(inputList.poll());
    }


}
