import java.util.Scanner;

public class Is_Palindrome{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        if(isPalindrome(str))
            System.out.println(str+" is Palindrome");
        else{
            System.out.println(str+" is Not Palindrome");
        } 
        

    }
    public static boolean isPalindrome(String str)
    {
        int i=0;
        int j=str.length()-1;
        while(i<=j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
}