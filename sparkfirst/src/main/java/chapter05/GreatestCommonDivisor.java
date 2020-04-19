package chapter05;

public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int a, int b){
        int big= a > b ? a : b;
        int small=a < b ? a: b;
        if (big % small == 0) {
            return small;
        }
        for (int i =  small/2; i >1 ; i--) {
            if(big%i==0 && small%i==0){
                return i;
            }
        }
        return 1;
    }

    public static int getGreatestCommonDivisorV2(int a, int b){
        System.out.println("a="+a+" b="+b);
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if(big%small==0){
            return small;
        }
        return getGreatestCommonDivisorV2( b,a%b );
    }

    public static int getGreatestCommonDivisorV3(int a, int b){
        if(a==b){
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        return getGreatestCommonDivisorV3(big - small, small);
    }

    public static int gcd(int a, int b){
        if(a == b){
            return a;
        }
        if((a&1)==0 && (b&1)==0){
            return gcd(a >> 1, b >> 1)<<1;
        } else if((a&1)==0 && (b&1)!=0){
            return gcd(a >> 1, b);
        } else if((a&1)!=0 && (b&1)==0){
            return gcd(a, b >> 1);
        } else {
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return gcd(big - small, small);
        }
    }

    public static void main(String[] args) {
//        System.out.println(getGreatestCommonDivisorV2(25, 5));
//        System.out.println(getGreatestCommonDivisorV2(100, 80));
        System.out.println(getGreatestCommonDivisorV3(27, 16));


    }
}
