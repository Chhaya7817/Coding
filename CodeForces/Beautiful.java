import java.util.Scanner;

public class Beautiful {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {

            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            int orr=0,err=0;
            for(int i=0;i<n;i++){
                if(a[i]%2==1) orr++;
                else err++;

            }
            if(a[0]%2!=0) {System.out.println("NO");}
            else {
                if(orr>=1) {System.out.println("NO");}
                else {System.out.println("YES");}
            }
        }
    }

}
