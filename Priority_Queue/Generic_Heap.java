public class Generic_Heap<T extends Comparable<T>> {
    private ArrayList<T> list=new ArrayList<T>();
    public void add(T item)
    {
        list.add(item);
        upheapify(list.size()-1);
    }
    private void upheapify(int ci)
    {
        int pi=(ci -1)/2;
        
        if(list.get(pi)>list.get(ci))
        {
            swap(pi,ci);
            upheapify(pi);
        }
    }
    public void swap(int i,int j)
    {
        T ith=list.get(i);
        T jth=list.get(j);
        list.set(i,jth);
        list.set(j,ith);


    }

    public T remove()
    {
        swap(0, list.size()-1);
        T rv=list.remove();
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
    public T min()
    {
        return list.get(0);
    }
    public void display()
    {
        System.out.println(list);
    }
}


