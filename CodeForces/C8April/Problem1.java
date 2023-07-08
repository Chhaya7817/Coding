package C8April;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a1=sc.nextInt();
            int b1=sc.nextInt();
            int a2=sc.nextInt();
            int b2=sc.nextInt();
            if((a1==1 && (b1==1|| b1==m)) || (a1==n && (b1==1 || b1==m) )||(a2==1 && (b2==1|| b2==m)) || (a2==n && (b2==1 || b2==m) ))
            System.out.println("2");
            else if(b1==1||b1==m||b2==1||b2==m||a1==1||a2==1||a1==n||a2==n)
                System.out.println("3");
            else
                System.out.println("4");
            
        }
    }
}
