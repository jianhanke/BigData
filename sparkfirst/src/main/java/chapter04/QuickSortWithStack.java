package chapter04;

/**
 * Created by weimengshu on 2018/7/13.
 */
import java.util.*;

public class QuickSortWithStack {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {

        Stack<Map<String,Integer>> quickSortStack=new Stack<Map<String,Integer>>();
        HashMap rootParam= new HashMap();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);
        while(!quickSortStack.isEmpty()){
            Map<String, Integer>  param= quickSortStack.pop();
            int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));

            if ( param.get("startIndex") <pivotIndex-1 ){
                HashMap<String, Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if(pivotIndex+1<param.get("endIndex")){
                HashMap<String, Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",param.get("startIndex"));
                quickSortStack.push(rightParam);
            }

        }

    }



    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int mark = startIndex;

        for(int i=startIndex+1; i<=endIndex; i++){
            if(arr[i]<pivot){
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        System.out.println(   (int) (2.18-0.5) * 4/4 );
        LinkedList<Integer> integers = new LinkedList<Integer>();
        integers.add(6);
        integers.add(3);
        integers.add(2);
        integers.add(5);
        Collections.sort(integers);
        System.out.println(Arrays.toString(integers.toArray()) );
    }

}
