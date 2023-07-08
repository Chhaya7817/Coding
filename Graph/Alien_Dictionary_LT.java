import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.DocFlavor.STRING;

/*There is a new alien language which uses the latin alphabet. However, the order among letters are 
unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted 
lexicographically by the rules of this new language. Derive the order of letters in this language. */

/*
        Input：["wrt","wrf","er","ett","rftt"]
        Output："wertf"
        Explanation：
        from "wrt"and"wrf" ,we can get 't'<'f'
        from "wrt"and"er" ,we can get 'w'<'e'
        from "er"and"ett" ,we can get 'r'<'t'
        from "ett"and"rftt" ,we can get 'e'<'r'
        So return "wertf"
 */


 /*baa,abcd,abcae,cab,cad
  * b<a,d<a,a<c,b<d
        b--->d
        |   /
        a
        |
        
        c
  */
public class Alien_Dictionary_LT {
    public String alienOrder(String[] words) {
        // Write your code here
        HashMap<Character,ArrayList<Character>> map=new HashMap<>();
        int[] in=new int[26];
        for (int i = 0; i < words.length; i++) {
            for (char w : words[i].toCharArray()) {
                map.put(w, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            String word1=words[i];
            String word2=words[i+1];
            if(word1.startsWith(word2) && word2.length()<word1.length())
                return "";
            for (int j = 0; j < Math.min(word1.length(),word2.length()); j++) {
                if(word1.charAt(j)!=word2.charAt(j))
                {
                    map.get(word1.charAt(j)).add(word2.charAt(j));
                    in[word2.charAt(j)-'a']++;
                    break;
                }
                
            }
        }
        System.out.println(map);
        
        System.out.println(Arrays.toString(in));


        return TopologicalSort(map, in);
        
    }
    public String TopologicalSort(HashMap<Character,ArrayList<Character>> map,int[] in)
    {
        StringBuilder ans=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        for(char key:map.keySet())
        {
            if(in[key-'a']==0)
            {
                q.add(key);
            }
        }
        while(!q.isEmpty())
        {
            char rv=q.poll();
            ans.append(rv);
            for(char nbrs:map.get(rv))
            {
                in[nbrs-'a']--;
                if(in[nbrs-'a']==0)
                    q.add(nbrs);
            }
        }
        return ans.length()==map.size() ? ans.toString() : "";
    }
    public char[] indegree(HashMap<Character,ArrayList<Character>> map)
    {
        char[] in=new char[26];

        return in;
        
    }
    public static void main(String[] args) {
        // String[] word={"wrt","wrf","er","ett","rftt"};
        // String[] word={"z","x"};
        String[] word={"abc","ab"};
        // String[] word={"z","x","z"};
        // String[] word={"ac","ab","zc","zb"};
        Alien_Dictionary_LT ad=new Alien_Dictionary_LT();
        System.out.println(ad.alienOrder(word));
    }
}
