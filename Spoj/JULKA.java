import java.math.BigInteger;
import java.util.Scanner;

public class JULKA {

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
        int t=10;
        while(t-->0){

            BigInteger n=sc.nextBigInteger();
            BigInteger more=sc.nextBigInteger();
      
            solve(n, more);
           

        }
    }
    public static void solve(BigInteger n,BigInteger m){
            BigInteger nat;
            nat=n.subtract(m);
            nat=nat.divide(BigInteger.valueOf(2));
            System.out.println(n.subtract(nat));
            System.out.println(nat);
    }
}