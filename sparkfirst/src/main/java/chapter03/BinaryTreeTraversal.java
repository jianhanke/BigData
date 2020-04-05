package chapter03;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by weimengshu on 2018/9/22.
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4,}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraversal(treeNode);
        System.out.println("中序遍历：");
        inOrderTraversal(treeNode);
        System.out.println("后序遍历：");
        postOrderTraversal(treeNode);
    }

    public static  TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node=null;
        if(inputList ==null || inputList.isEmpty()){
            return null;
        }
        Integer data=inputList.removeFirst();
        if(data!=null){
            node=new TreeNode(data);
            node.leftChild=createBinaryTree(inputList);
            node.rightChild=createBinaryTree(inputList);
        }
        return node;
    }

    public static  void preOrderTraversal(TreeNode node){
        if(node==null){
            return ;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    public static  void inOrderTraversal(TreeNode node){
        if(node==null){
            return ;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    public static  void postOrderTraversal(TreeNode node){
        if(node==null){
            return ;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }




}
class TreeNode{
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data=data;
    }
}

