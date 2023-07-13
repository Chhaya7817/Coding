import java.util.ArrayList;
import java.util.List;

public class Word_Search2_LT{
    public static void main(String[] args) {
        
    }
    public class Node{
        char ch;
        int end=0;
        Node[] children=new Node[26];
        String word="";
    }
    public Node getNode(char ch)
    {
        Node nn=new Node();
        nn.ch=ch;
        for(int i=0;i<26;i++)
        {
            nn.children[i]=null;

        }
        return nn;
    }
    public Node root=getNode('/');
    public void insert(String word)
    {
        Node curr=root;
        for (char c : word.toCharArray()) {
            int index=c-'a';
            
            if(curr.children[index]==null)
            {
                curr.children[index]=getNode(c);
            }
            curr=curr.children[index];
        
            
        }
        curr.end=1;
        curr.word=word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words)
        {
            insert(null);
        }

        List<String> ans=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                traverseBoard(board, i, j, i, j, ans, root);
            }
            
        }
        return ans;


    }

    public void traverseBoard(char[][] board,int i,int j,int r,int c,List<String> ans,Node curr)
    {
        if(board[i][j]=='#') return;

        if(curr.end>0)
        {
            ans.add(curr.word);
            curr.end--;
            return;
        }

        char ch=board[i][j];
        board[i][j]='#';
//tp
        if(i>0)
            traverseBoard(board, i-1, j, r, c, ans, curr);
        if(i<r-1)
            traverseBoard(board, i+1, j, r, ch, ans, curr);
        
        if(j>0)
            traverseBoard(board, i, j-1, r, c, ans, curr);
        if(j<c-1)
            traverseBoard(board, i, j+1, r, ch, ans, curr);
        

    }
}