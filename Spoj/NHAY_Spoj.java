import java.util.Scanner;

public class NHAY_Spoj {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
        int n=sc.nextInt();
        String pat=sc.next();
        String text=sc.next();
        
        longestPrefix(pat, text);}

    }
    public static void longestPrefix(String pat,String text) {
        String s=pat+"#"+text;
        int n=s.length();
        int dp[]=new int[n];
        int len=0;
        for (int i = 1; i < dp.length;) {
            if(s.charAt(len)==s.charAt(i)){
                len++;
                dp[i]=len;
                i++;
            }
            else{
                if(len>0){
                    len=dp[len-1];
                }else
                {
                    dp[i]=0;
                    i++;
                }
            }
        }
        for (int i = pat.length(); i < dp.length; i++) {
            if(dp[i]==pat.length()){
                System.out.println(i-2*pat.length());
            }
        }

    }
}
