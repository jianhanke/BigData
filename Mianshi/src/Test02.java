import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            ArrayList<Integer> right = new ArrayList<>();
            for (int i = m; i <=n ; i++) {
                int one= (int) (i/100);
                int two= (int) ( (i-one*100 )/10 );
                int three= (int) (  (i-one*100-two*10));
//                System.out.println(one);
//                System.out.println(two);
//                System.out.println(three);
                if(i == Math.pow(one,3)+Math.pow(two,3)+Math.pow(three,3) ){
//                    System.out.println(Math.pow(one,3)+Math.pow(two,3)+Math.pow(three,3));

                    right.add(i);
                }
            }

            if(right.isEmpty()){
                System.out.println("no");
            }
            for ( Integer i:right){
                System.out.printf(i+" ");
            }


        }

    }
}