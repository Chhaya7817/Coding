import java.util.ArrayList;

public class Heap<T extends Comparable<T> > {
    private ArrayList<Integer> list=new ArrayList<>();
    public void add(int item)
    {
        list.add(item);
        upheapify(list.size()-1);
    }
    private void upheapify(int ci)
    {
        int pi=(ci -1)/2;
        
        if(islarger(list.get(pi),list.get(ci))>0)
        {
            swap(pi,ci);
            upheapify(pi);
        }
    }
    public void swap(int i,int j)
    {
        int ith=list.get(i);
        int jth=list.get(j);
        list.set(i,jth);
        list.set(j,ith);


    }

    public int max()
    {
        swap(0, list.size()-1);
        int rv=list.remove();
        downheapify(0);
        return rv;
    }
    private void downheapify(int pi) {
        int lci=2* pi +1; //left child index
        int rci=2* pi +2; //right child index
        int mini=pi;
        if(list.get(mini)>list.get(lci))
        {
            mini=lci;
        }
        if(list.get(mini)>list.get(rci))
        {
            mini=rci;
        }
        if(mini!=pi)
            swap(pi, mini);
        downheapify(mini);
    }
    public int min()
    {
        return list.get(0);
    }
    public void display()
    {
        System.out.println(list);
    }
    public int islarger(T o1,T o2)
    {
        return o1.compareTo(o2);
    }
    
}
