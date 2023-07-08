import java.util.ArrayList;
import java.util.Scanner;

public class PatternFinder_Spoj {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String s=sc.next();
            String t=sc.next();
        }
    }
    public static void Rabinkarp(String s,String t) {

        long mod=1000_000_007;
        long pow=1;
        long hv=0;
        int pr=31;
        for (int i = 0; i < t.length(); i++) {
            char ch=t.charAt(i);
            hv=(hv+((ch-'a'+1)*pow)%mod)%mod;
            hv=(hv+mod)%mod;
            pow=(pow*pr)%mod;
        }

        //Rabin Karp Algo 

        long dp[]=new long[s.length()];
        long pa[]=new long[s.length()];
        pa[0]=1;
        pow=pr;
        for (int i = 0; i < pa.length; i++) {
            char ch=t.charAt(i);
            dp[i]=dp[i-1]+((ch-'a'+1)*(pow%mod))%mod;
            pa[i]=pow;
            pow=(pow*pr)%mod;
        }

        ArrayList<Integer> ll=new ArrayList<>();
        if(dp[t.length()-1]==hv){
            ll.add(1);
        }
        for (int ei = t.length(),si=1;ei<pa.length; ei++,si++) {
            long hvalue=dp[ei]-dp[si-1];
            if(hvalue==hv) ll.add(si);
            
            
        }
        
    }
}
