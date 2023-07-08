public class Inc_Exc_Rule {
    public static void main(String[] args) {
        int n=1000;
        int arr[]={2,3,5};
        System.out.println(count(n, arr));
    }
    public static int count(int n,int[] arr) {
        int ans=0;
        for (int i = 1; i < (1<<(arr.length)); i++) {
            int c=countNumber(i,n,arr);
            if(countSetBits(i)%2==0){
                ans-=c;
            }else{
                ans+=c;
            }

        }
        return ans;
    }
    private static int countNumber(int i, int n, int[] arr) {
        int prod=1;
        int pos=0;
        while(i>0){
            if((i&1)!=0){
                prod*=arr[pos];
            }
            i>>=1;
            pos++;
        }
        return n/prod;
    }
    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            n=(n&(n-1));
            count++;
        }
        return count;
     }
}
