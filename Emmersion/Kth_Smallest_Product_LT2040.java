public class Kth_Smallest_Product_LT2040 {
    public static void main(String[] args) {
        int[] arr1={};
        int[] arr2={};
        long k;
        
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long si=-1000_000_0000l;
        long ei=1000_000_0000l;
        long ans=0;
        while(si<=ei)
        {
            long mid=si+(ei-si)/2;

            if(countOfProduct(nums1,nums2,mid)>=k)
            {
                ans=mid;
                ei=mid-1;

            }
            else si=mid+1;
        }
        return ans;
    }

    private long countOfProduct(int[] nums1, int[] nums2, long prod) {

        long ans=0;
        for (int e1 : nums1) {
            if(e1>=0)
            {
                long count=0;
                int lo=0;
                int hi=nums2.length-1;
                while(lo<=hi)
                {
                    int mid=(lo+hi)/2;
                    if((long)(e1)*nums2[mid]<=prod)
                    {
                        count=mid+1;
                        lo=mid-1;
                    }
                    else hi=mid+1;
                }
                ans+=count;

            }
            else{
                long count=0;
                int lo=0;
                int hi=nums2.length-1;
                while(lo<=hi)
                {
                    int mid=(lo+hi)/2;
                    if((long)(e1)*nums2[mid]<=prod)
                    {
                        count=nums2.length-mid;
                        hi=mid-1;
                    }
                    else lo=mid+1;
                }
                ans+=count;
            }
            
        }

        return ans;
    }
}
