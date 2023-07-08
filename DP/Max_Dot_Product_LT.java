import java.util.Arrays;

public class Max_Dot_Product_LT {
    public static void main(String[] args) {
        int[] nums1={1,2,3,4,5};
        int[] nums2={1,3,5,2};
        int[][] dp=new int[nums1.length][nums2.length];
        for(int[] a:dp)
        {
            Arrays.fill(a,-1000000);
        }
    }
   
    public static int Product(int[] nums1, int[] nums2,int i,int j,boolean flag) {
        if(i==nums1.length ||j==nums2.length) {
            if(flag)
                return 0;
            else{
                return -100000;
            }
        }
        int d = nums1[i]*nums2[j] + Product(nums1, nums2, i+1, j+1,true);
        //non empty subset not handeled take extra boolean value in fun
        int fd=Product(nums1, nums2, i+1, j,false);
        int sd=Product(nums1, nums2, i, j+1,false);
        return Math.max(nums1[i]*nums2[j],Math.max(fd,Math.max(d,sd)));
    }
    public static int Product(int[] nums1, int[] nums2,int i,int j,boolean flag,int[][] dp) {
        if(i==nums1.length ||j==nums2.length) {
            if(flag)
                return 0;
            else{
                return -100000;
            }
        }
        if(dp[i][j]!=-100000)
            return dp[i][j];
        int d = nums1[i]*nums2[j] + Product(nums1, nums2, i+1, j+1,true);
        //non empty subset not handeled take extra boolean value in fun
        int fd=Product(nums1, nums2, i+1, j,false,dp);
        int sd=Product(nums1, nums2, i, j+1,false,dp);
        return dp[i][j]=Math.max(nums1[i]*nums2[j],Math.max(fd,Math.max(d,sd)));
    }

    public static int Product(int[] nums1,int [] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int sp=Integer.MIN_VALUE;//special case
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int dot=nums1[i-1]*nums2[j-1]+dp[i-1][j-1];
                int fs=dp[i-1][j];
                int sd=dp[i][j-1];
                dp[i][j]=Math.max(nums1[i-1]*nums2[j-1],Math.max(dot,Math.max(sd,fs)));
                sp=Math.max(sp,nums1[i-1]*nums2[j-1]);
            }
        }
        if(dp[dp.length-1][dp[0].length-1]==0)
        return sp;
        return dp[dp.length-1][dp[0].length-1];
    }
}
