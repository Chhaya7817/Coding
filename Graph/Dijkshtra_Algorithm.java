import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkshtra_Algorithm {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Dijkshtra_Algorithm(int v)
    {
        for (int i = 1; i <=v; i++) {
            map.put(i,new HashMap<>());
        }
        
    }
    public void AddEdge(int v1,int v2,int cost)
    {
        map.get(v1).put(v2,cost); //v1---->v2
        map.get(v2).put(v1,cost);//v2 --->v1
    }
    public class DijktraPair {
		int vtx;
		String path; 
		int cost;

		public DijktraPair(int vtx, int cost) {
			// TODO Auto-generated constructor stub
			this.vtx = vtx;

			this.cost = cost;

		}

		@Override
		public String toString() {
			return this.vtx + " " +"  @ " + this.cost;
		}
	}
    
    
}
