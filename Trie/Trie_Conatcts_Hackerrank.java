import java.util.HashMap;

public class Trie_Conatcts_Hackerrank {
    public class Node{
        char ch;
        HashMap<Character,Node> child=new HashMap<>();
        boolean isTerminal=false;
        int count=0;
    }

    private Node root;

    public Trie_Conatcts_Hackerrank(){
        Node nn=new Node();
        nn.ch='*';
        this.root=nn;
    }
    public void insert(String word){
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr=curr.child.get(ch);
                curr.count++;
            }
            else
            {
                Node nn=new Node();
                nn.ch=ch;
                nn.count=1;
                curr.child.put(ch,nn);
                
                curr=nn;
                
            }
        }
        curr.isTerminal=true;
        
    }
    public int startsWith(String prefix) {
        Node curr=root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch=prefix.charAt(i);
            if(!curr.child.containsKey(ch)){
                break;
                
            }
            curr=curr.child.get(ch);
        }
        return curr.count;
    }
    
}
