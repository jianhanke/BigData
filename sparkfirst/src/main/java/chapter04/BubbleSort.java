package chapter04;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int array[])
    {
        int tmp=0;
        for (int i = 0; i < array.length-1 ; i++) {
            for (int j = 0; j <array.length-1 ; j++) {
                if(array[j] >array[j+1] ){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }

    public static void sort2(int array[])
    {
        int tmp=0;
        int lastExchangeIndex=0;
        int sortBorder=array.length-1;
        for (int i = 0; i < array.length-1 ; i++) {
            boolean isSorted=true;
            System.out.println(sortBorder);
            for (int j = 0; j < sortBorder ; j++) {
                if(array[j] >array[j+1] ){
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    isSorted=false;
                    lastExchangeIndex=j;
                }
            }
            sortBorder=lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }



    public static void main(String[] args){
        int[] array = new int[]{2,2,2};
        int[] arr2=new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        sort2(array);
        System.out.println(Arrays.toString(array));
    }
}
