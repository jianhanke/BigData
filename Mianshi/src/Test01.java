import java.util.*;
class Test01{
    public static void main(String args[]){
        int m;
        double sum,n;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
             n = scanner.nextDouble();
             m = scanner.nextInt();
            sum=0;
            for (int i = 0; i < m; i++) {
                sum =sum+n;
                n=Math.sqrt(n);
            }
            System.out.printf("%.2f",sum);
            System.out.println();
        }




    }
}