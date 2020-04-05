package chapter02;



/**
 * Created by weimengshu on 2018/8/24.
 */
public class MyLinkTable {

    private Node head;
    private Node last;
    private int size;
    public static void main(String[] args) throws Exception {
        MyLinkTable myLinkedList = new MyLinkTable();
        myLinkedList.insert(0,3);
        myLinkedList.insert(0,4);
        myLinkedList.insert(2,9);
        myLinkedList.insert(3,5);
        myLinkedList.insert(1,6);
        myLinkedList.remove(0);
        myLinkedList.output();
    }
    public void output(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void insert(int index,int data){
        if(index<0 || index >size){
            throw new IndexOutOfBoundsException("超出范围");
        }
        Node insertNode=new Node(data);
        if(size==0){
            head=insertNode;
            last=insertNode;
        } else if(index==0){
            insertNode.next=head;
            head=insertNode;
        }else if (index==size){
            insertNode.next=null;
            Node prevNode = get(size - 1);
            prevNode.next=insertNode;
        } else{
                insertNode.next=get(index);
                Node prevNode=get(index-1);
                prevNode.next=insertNode;
        }
        size++;
    }

    public Node remove(int index){
        if(index<0 || index >0){
            throw new IndexOutOfBoundsException("超出范围");
        }
        Node removedNode=null;
        if(index==0){
            removedNode=head;
            head=head.next;
        }else if (index==size-1){
            Node prevNode= get(index-1) ;
            prevNode.next=null;
        }else{
            removedNode=get(index);
            Node prevNode=get(index-1);
            Node nextNode=get(index+1);
            prevNode.next=nextNode;
        }
        size--;
        return removedNode;
    }

    public Node get(int index){
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp=head;
        for (int i = 0; i <index ; i++) {
            temp=temp.next;
        }
        return temp;
    }

}

class Node{
     int data;
     Node next;
    public Node(int data){
        this.data=data;
    }
}

