package chapter04;


import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {

        while(startIndex >= endIndex){
            return ;
        }
        int pivot = partitionV2(arr, startIndex, endIndex);
        quickSort(arr,startIndex,pivot-1);
        quickSort(arr,pivot+1,endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot=arr[startIndex];
        int left=startIndex;
        int right=endIndex;
        int tmp;
        while(left!=right ){
            while(right>left && arr[right] >pivot){
                right--;
            }
            while(right>left && arr[left]<=pivot){
                left++;
            }
            if(left<right){
                tmp=arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;
            }
        }
       arr[startIndex]=arr[left];
        arr[left]=pivot;
        return left;
    }

    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        int prvot=arr[startIndex];
        int mark =startIndex;
        int tmp;
        for (int i = startIndex+1; i <=endIndex ; i++) {
            if(arr[i] <prvot ){
                mark++;
                tmp=arr[mark];
                arr[mark]=arr[i];
                arr[i]=tmp;
            }
        }
        arr[startIndex]=arr[mark];
        arr[mark]=prvot;
        return mark;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,4,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
