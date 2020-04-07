package chapter03;


import java.util.Arrays;

public class HeapOperator {

    public static void upAdjust(int[] array,int childIndex) {

        int tmp = array[childIndex];
        int parentIndex=(childIndex-1)/2;
        while( childIndex >0 && tmp<array[parentIndex] ){
            array[childIndex]=array[parentIndex];
            childIndex=parentIndex;
            parentIndex=(childIndex-1)/2;
        }
        array[childIndex]=tmp;
    }
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex]; //7
        int childIndex = 2 * parentIndex + 1;
        System.out.println("大的");
        while (childIndex < length  ) {
            System.out.println("小的");
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex])
                break;
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void myAdjust(int[] array,int par) {

        int parentIndex=par;

        while((parentIndex*2+1)<array.length && parentIndex<array.length ){
            int leftchildIndex=parentIndex*2+1;
            int rightchildIndex=parentIndex*2+2;

            if(array[leftchildIndex] > array[rightchildIndex]){
                if(array[parentIndex] > array[rightchildIndex]){
                    int temp=array[rightchildIndex];
                    array[rightchildIndex]=array[parentIndex];
                    array[parentIndex]=temp;
                    parentIndex=parentIndex*2+2;
                }else{
                    break;
                }
            }else{
                System.out.println(parentIndex);
                if(array[parentIndex]  > array[leftchildIndex] ){
                    int temp=array[leftchildIndex];
                    array[leftchildIndex]=array[parentIndex];
                    array[parentIndex]=temp;
                    parentIndex=parentIndex*2+1;
                }else{
                    break;
                }
            }
        }
    }

    public static void buildHeap(int[] array) {

        for (int i = (array.length-2)/2; i >=0 ; i--) {
            myAdjust3(array,i);
        }
    }
    public static void buildHeap2(int[] array) {

        for (int i = (array.length-1); i >=0 ; i--) {
            upAdjust(array,i);
        }
    }


    public static void myAdjust3(int[] array,int parentIndex) {
        int tmp =array[parentIndex];
        int childIndex=parentIndex*2+1;
        while((childIndex)<array.length  ){
            if( childIndex +1 < array.length && array[childIndex]>array[childIndex+1] ){
                childIndex++;
            }
            if(tmp <= array[childIndex]){
                break;
            }
            array[parentIndex]  =array[childIndex];
            parentIndex= childIndex;
            childIndex=parentIndex*2+1;
        }
        array[parentIndex]=tmp;
    }

    public static void myAdjust4(int[] array,int parentIndex) {

        int childIndex=parentIndex*2+1;
        while((childIndex)<array.length  ){
            if( childIndex +1 < array.length && array[childIndex]>array[childIndex+1] ){
                childIndex++;
            }
            if(array[parentIndex] <= array[childIndex]){
                break;
            }
            int tmp =array[parentIndex];
            array[parentIndex]  =array[childIndex];
            array[childIndex]=tmp;
            parentIndex= childIndex;
            childIndex=parentIndex*2+1;
        }

    }




    public static void main(String[] args) {

        int[]  array = new int[] {7,1,3,10,5,2,8,9,6};

        buildHeap2(array);
        System.out.println(Arrays.toString(array));



    }
}
