import java.util.Scanner;

public class Preparing_Olympiad_CF {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=sc.nextInt();
        int r=sc.nextInt();
        int x=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(countcontest(arr, l, r, x));
     }
     public static int countcontest (int[] arr,int l,int r,int x) {
        int n=arr.length;
        int ans=0;
        for (int i = 0; i < (1<<n); i++) {
            if(countSetBits(i)>=2){
                if(isitpossible(arr,l,r,x,i)){
                    ans++;
                }
            }
        }
        return ans;
        
     }
     private static boolean isitpossible(int[] arr, int l, int r, int x, int i) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,sum=0;
        int pos=0;
        while(i>0){
            if((i&1)!=0){
                sum+=arr[pos];
                min=Math.min(min,arr[pos]);
                max=Math.max(max,arr[pos]);
            }
            i>>=1;
            pos++;
        }
        if(sum>=l && sum<=r && max-min>=x) //can use bitwise and also
            return true;

        return false;
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
