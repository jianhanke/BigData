package chapter04;

/**
 * Created by weimengshu on 2018/7/13.
 */
import java.util.Arrays;

public class CountSort {

    public static int[] countSort(int[] array) {

        int max=array[0];
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        int[] countArray = new int[max + 1];
        for (int i = 0; i < array.length ; i++) {
            countArray[array[i]]++;
        }

        int index=0;
        int[] sortArray = new int[array.length];

        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i] ; j++) {
                sortArray[index++]=i;
            }
        }
        return sortArray;


    }

    public static int[] countSortV2(int[] array) {

        int max=array[0];
        int min=array[0];
        for (int i = 0; i < array.length ; i++) {
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }

        int[] countArray = new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            countArray[ array[i]-min ]++;
        }
        for (int i = 0; i <countArray.length ; i++) {
            countArray[i]+=countArray[i-1];
        }

        int[] sortedArray=new int[array.length];
        for (int i = array.length; i >=0 ; i++) {

            sortedArray[countArray[array[i]-min] -1]=array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,2,8,1,7,5,6,0,10};

        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));

        array = new int[] {95,94,91,98,99,90,99,93,91,92};
        sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
