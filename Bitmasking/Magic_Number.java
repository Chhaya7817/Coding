//Magic num is expressed in power of 5 or sum of unique powers  of 5.
//few magic numbers are 5 , 25 ,30,125,130...............
//find nth number 



import java.util.Scanner;

public class Magic_Number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(number(n));
    }
    public static int number(int n) {
        int ans=0;
        int mul=5;
        while(n>0){
           if((n&1)!=0) ans+=mul;
           n=n>>1;
           mul*=5;
        }
        return ans;
        
    }
}
