import java.util.*;
import java.lang.*;


public class j {

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		HashSet<Integer> noIncoming = new HashSet<Integer>(2*n);
		HashMap<Integer, Integer> adj = new HashMap<Integer, Integer>(2*n);

		for(int i = 1; i <= 2*n; i++)
			noIncoming.add(i);

		for(int i = 1; i <= 2*n; i++){
			int s = i;
			int d = scnr.nextInt();
			noIncoming.remove(d);
			adj.put(s, d);
		}

		// true => in kernel
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>(4*n);
		Queue<Integer> q = new LinkedList<Integer>();

		noIncoming.forEach((s) -> {
			hm.put(s, true);
			q.add(s);
		});

		int i = 1;
		while(hm.size() != 2*n){

			// get the next subgraph
			if(q.isEmpty()){
				for(; i <= 2*n; i++){
					if(adj.containsKey(i)){
						// go to this knights root
						while(){
							
						}

					}
				}
			}

			while(!q.isEmpty()){
				int s = q.poll();
				int d = adj.get(s);
				hm.put(d, false);
				// remove this edge
				adj.remove(s);
				// remove outgoing edges from false node
				adj.remove(d);
			}

		}

		for(i = 1; i <= 2*n; i++){
			System.out.print((hm.get(i)) ? i + " " : "");
		}


	}
}
