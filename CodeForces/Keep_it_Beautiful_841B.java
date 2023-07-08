import java.util.Scanner;

public class Keep_it_Beautiful_841B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }

            String ans="1";
            for (int i = 1; i < arr.length; i++) {
                if(arr[i]>=arr[i-1]) ans+="1";
                else if(arr[i]<=arr[0]) ans+="1";
                else ans+="0";
            }
            System.out.println(ans);
        }
    }
}
