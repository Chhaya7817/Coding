import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Longest_Duplicate_Substring_LT {
    public static void main(String[] args) {
        String s="banana";
        int lo=0;
        int hi=s.length();
        String ans="";
        while(lo<=hi){
            int mid=(lo+hi)/2;
            ans=Solve(s,mid);
            if(ans.length()>0){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
    }

    private static String Solve(String s, int mid) {
        long mod=1000_000_007;
        long pow=1;
        long hv=0;
        long ans=0;
        int pr=31;
        for(int ei=mid-1;ei>=0;ei--){
            ans=(ans+((s.charAt(ei)-'a'+1)*pow)%mod)%mod;
            if(ei>0){
                pow=(pow*pr)%mod;

            }
        }
        HashMap<Long,List<Integer>> map=new HashMap<>();
        map.put(hv,new ArrayList<>());
        map.get(hv).add(0);
        for(int ei=mid,si)
        return null;
    }
}
