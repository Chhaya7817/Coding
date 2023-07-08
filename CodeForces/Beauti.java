import java.util.Scanner;

public class Beauti {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {

            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[n];
            arr[1]=1;
            for(int p=2;p<n;p++) {
                if(p%k==1) arr[p]=1;

            }
            arr[n]=1;
            int check=1;
            for(int i=n-1,j=2;i>=1;i--,j++)
            {
                check+=arr[i];
                if(check<((j-1)/(k+1))) {arr[i]=1;check++;}
            }
            int out=0;
            for(int i=0;i<n+1;i++){
                if(arr[i]==1) out++;
            }
            System.out.println(out);
        }
    }
}
