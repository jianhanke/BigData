package chapter03;


import java.util.Arrays;

public class PriorityQueue {

    private int[] array;
    int size;
    public PriorityQueue(){
        array=new int[32];
    }

    public void enQueue(int key) {
        System.out.println(size);
        if(size==array.length) {
            resize();
        }
        array[size]=key;
        ++size;
        upAdjust();
    }

    public int deQueue() throws Exception {
        if(size<=0){
            throw new IndexOutOfBoundsException("队列为空");
        }
        int head = array[0];
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    private void upAdjust() {
        int childrenIndx=size-1;
        int parentIndex= (childrenIndx-1)/2;
        int tmp=array[childrenIndx];
        while( childrenIndx>0 &&  tmp>array[parentIndex]){
            array[childrenIndx]=array[parentIndex];
            childrenIndx=parentIndex;
            parentIndex= (childrenIndx-1)/2;
        }
        array[childrenIndx]=tmp;
    }

    private void downAdjust() {
        int parentIndex=0;
        int childrenIndex=parentIndex*2+1;
        int tmp = array[parentIndex];
        while( childrenIndex < size ){
            if(   array[childrenIndex+1]>array[childrenIndex] &&  childrenIndex+1<size  ) {
                childrenIndex++;
            }
            if( tmp >= array[childrenIndex] ){
                break;
            }
            array[parentIndex]=array[childrenIndex];
            parentIndex=childrenIndex;
            childrenIndex=parentIndex*2+1;
        }
        array[parentIndex]=tmp;
    }

    private void resize() {
        Arrays.copyOf(array,array.length*2);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素：" + priorityQueue.deQueue());

        int i=2;
        System.out.println(i+1);
        System.out.println(i);

    }
}
