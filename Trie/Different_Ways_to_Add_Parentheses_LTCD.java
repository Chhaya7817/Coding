import java.util.ArrayList;
import java.util.List;

public class Different_Ways_to_Add_Parentheses_LTCD {
    public static void main(String[] args) {
        String s="2*3-4*5";

    }
    public List<Integer> diffWaysToCompute(String expression) {

        if(expression.indexOf('+')==-1 && expression.indexOf('-')==-1 && expression.indexOf('*')==-1)
        {
            List<Integer> ll=new ArrayList<>();
            ll.add(Integer.parseInt(expression));
            return ll;

        }
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch=expression.charAt(i);
            if(isOperator(ch)){
                List<Integer> left=diffWaysToCompute(expression.substring(0,i));
                List<Integer> right=diffWaysToCompute(expression.substring(i+1));
                for (int a : left) {
                    for (int b : right) {
                        int val=calculate(a, b, ch);
                        ans.add(val);                     
                    }
                    
                }
            }
        }
        return ans;

    }
    public static boolean isOperator(char ch)
    {
        if(ch=='*' ||ch=='-' || ch=='+') return true;
        return false;
    }
    public static int calculate(int a , int b,char ch)
    {
        if(ch=='+') return a+b;
        if(ch=='-') return a-b;
        return a*b;
    }
}
