package chapter04;

/**
 * Created by weimengshu on 2018/7/13.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    public static double[] bucketSort(double[] array){

        double max=array[0];
        double min=array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        int bucketNum=array.length;
        double d=max-min;
        System.out.println(d);
        ArrayList<LinkedList<Double>> buckList = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum ; i++) {
            buckList.add(new LinkedList<Double>());
        }
        for (int i = 0; i <array.length ; i++) {
            int index= (int) ((array[i]-min)*(bucketNum-1)/d);
            buckList.get(index).add(array[i]);
        }
        for (int i = 0; i <buckList.size() ; i++) {
            Collections.sort(buckList.get(i));
        }
        double[] sortedArray = new double[array.length];
        int index=0;
        for (int i = 0; i <buckList.size() ; i++) {
            for(double element : buckList.get(i)){
                sortedArray[index]=element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[] {2,2,2};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));


    }
}
