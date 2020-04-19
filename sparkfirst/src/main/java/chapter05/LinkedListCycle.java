package chapter05;

/**
 * Created by weimengshu on 2018/8/24.
 */
public class LinkedListCycle {

    public static boolean isCycle(Node head) {
        Node p1=head;
        Node p2=head;
        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                countCycleLength(p1);
                getEnterNode(head,p1);
                return true;
            }
        }
        return false;
    }

    public static void getEnterNode(Node head,Node meetNode){
        Node p1=head;
        Node p2=meetNode;
        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            if(p1==p2){
                System.out.println("入口点"+p1.data);
                break;
            }
        }

    }

    public static void countCycleLength(Node meetNode){
        Node p1=meetNode;
        Node p2=meetNode;
        int p1Num=0;
        int p2Num=0;
        do{

            p1=p1.next;
            p2=p2.next.next;
            ++p1Num;
            p2Num+=2;

            if(p1==p2){
                System.out.println("步长未:"+(p2Num-p1Num));
                break;
            }
        }while(p2!=null && p2.next!=null);

    }

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next =node7;
        node7.next = node4;

        System.out.println(isCycle(node1));
    }
}
