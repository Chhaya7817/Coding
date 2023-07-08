import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class Musical {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {

            int n=sc.nextInt();
            HashSet<String> set=new HashSet<String>();
            String str=sc.next();
            for (int i = 1; i < n; i++) {
                set.add(str.charAt(i-1)+""+str.charAt(i));
                
            }
            System.out.println(set.size() );
        }
        
    }
}
