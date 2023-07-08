import java.util.HashMap;

public class DisjointSet {
    class Node{
        int val;
        int rank;
        Node parent;
        
    }
    public HashMap<Integer,Node> map=new HashMap<>();
    public void Create(int v)
    {
        Node nn=new Node();
        nn.val=v;
        nn.rank=0;
        nn.parent=nn;
        map.put(v,nn);
    }
    public int find(int v)
    {
        Node nn=map.get(v);
        return find(nn).val;
    }
    private Node find(Node nn)
    {
        if(nn.parent==nn)
            return nn;
        return find(nn.parent);
    }
    public void Union(int v1,int v2)
    {
        Node n1=map.get(v1);
        Node n2=map.get(v2);
        Node rn1=find(n1);
        Node rn2=find(n2);
        if(rn1.rank==rn2.rank)
        {
            rn1.parent=rn2;
            rn2.rank++;
        }
        else if(rn1.rank<rn2.rank)
        {
            rn1.parent=rn2;
        }
        else 
        {
            rn2.parent=rn1;
        }
    }
    
}
