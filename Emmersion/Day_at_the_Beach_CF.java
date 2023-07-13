import java.util.Arrays;
import java.util.Scanner;

public class Day_at_the_Beach_CF {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(partition(n,arr));

    }
    public static int partition(int n,int[] arr)
    {
        int[] leftMax=new int[n+1];
        int rightMin[]=new int[n+1];
        leftMax[0]=Integer.MIN_VALUE;
        rightMin[n]=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            leftMax[i+1]=Math.max(leftMax[i],arr[i]);
        }
        for(int i=n-1;i>=0;i--)
        {
            rightMin[i]=Math.min(rightMin[i+1],arr[i]);
        }
        // System.out.println(Arrays.toString(leftMax));
        // System.out.println(Arrays.toString(rightMin));

        int ans=1;
        for(int i=1;i<n;i++)
        {
            if(leftMax[i]<=rightMin[i])
                ans++;
        }

        return ans;
    }
}
