package chapter04;

import java.util.Arrays;

public class CockTailSort {

    public static void sort(int array[])
    {
        int tmp=0;
        for (int i = 0; i < array.length/2 ; i++) {

            boolean isSorted=true;
            for (int j = 0; j < array.length-1-i ; j++) {
                if(array[j] >array[j+1]){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
             isSorted=true;
            for (int j = array.length-1-i; j>i  ; j--) {
                if( array[j-1] > array[j]){
                    tmp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=tmp;
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
        }


    }

    public static void main(String[] args){
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
