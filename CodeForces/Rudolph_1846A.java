import java.util.Scanner;

public class Rudolph_1846A{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int ans=0;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                if(b-a<0) ans++;
            }
            System.out.println(ans);
        }
    }

}