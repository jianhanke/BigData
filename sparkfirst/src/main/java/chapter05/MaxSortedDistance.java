package chapter05;

public class MaxSortedDistance {

    public static int getMaxSortedDistance(int[] array){

        //1.得到数列的最大值和最小值
        int max = array[0];
        int min = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        if(d == 0){
            return 0;
        }
        int bucketNum=array.length;
        Bucket[] buckets=new Bucket[bucketNum];
        for (int i = 0; i <buckets.length ; i++) {
            buckets[i]=new Bucket();
        }

        for (int i = 0; i <array.length ; i++) {
            int index=  (array[i]-min)*(bucketNum-1)/d;
            if(buckets[index].min==null || buckets[index].min >array[i] ){
                buckets[index].min =array[i];
            }
            if(buckets[index].max==null || buckets[index].max <array[i]){
                buckets[index].max=array[i];
            }
        }
        int leftMax=buckets[0].max;
        int maxDistance=0;
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i].min==null){
                continue;
            }
            if(buckets[i].min-leftMax >leftMax){
                leftMax=buckets[i].min-leftMax;
            }
            leftMax=buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        Integer min;
        Integer max;
    }

     static  class Student{
        String name;
        Integer age;
    }



    public static void main(String[] args) {
        int[] array = new int[] {2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance(array));

    }
}
