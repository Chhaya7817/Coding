import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int [] arr={10,2,03,0,5,0,5,06,05};

    }
    public static int lis(int[] arr) {
        int[] dp=new int[arr.length];
        Arrays.fill(arr,-1);
        for (int i = 1; i < dp.length; i++) {
            for(int j=i-1;j>=0;j--)
            {
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int max=dp[0];
        for (int i = 0; i < dp.length; i++) {
            max=Math.max(dp[i],max);
        }
        return max;
        
    }
    //O(nlogn)
    //using Binary Search
    public static int lis_nlogn(int arr[]) {
        int dp[]=new int[arr.length];
        dp[0]=arr[0];
        int len=1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>dp[len-1])
            {
                dp[len]=arr[i];
                len++;
            }
            else
            {
                int replace_index=binarySearch(dp, 0, len-1,arr[i]);
                dp[replace_index]=arr[i];
            }
        }
        return len;
    }
    public static int binarySearch(int[] dp,int low,int high,int item)
    {
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(dp[mid]>=item){
                ans=mid;
                high=mid+1;
            }
            else if(dp[mid]<item)
                low=high+1;

        }
        return ans;
    }
}
