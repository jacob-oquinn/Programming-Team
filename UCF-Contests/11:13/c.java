import java.util.*;
import java.lang.*;


public class c{

	static class Edge{
		int v;
		int u;
		Edge(int uu, int vv){
			u = uu;
			v = vv;
		}
	}

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int numCases = scnr.nextInt();
		for(int caseNum = 1; caseNum <= numCases; caseNum++){
			scnr.nextInt(); // get rid of case num
			int numNodes = scnr.nextInt();
			int numEdges = scnr.nextInt();
			Edge edges[] = new Edge[numEdges];
			for(int i = 0; i < numEdges; i++){
				edges[i] = new Edge(scnr.nextInt()-1, scnr.nextInt()-1);
			}



			// srcNodes starts off as the source nodes (no incoming edges)
			boolean srcNodes[] = new boolean[numNodes];
			Arrays.fill(srcNodes, true);
			for(Edge e : edges){
				srcNodes[e.v] = false;
			}
			Queue<Integer> q = new LinkedList<Integer>();

			int order[] = new int[numNodes];
			Arrays.fill(order, 0);

			for(int i = 0 ; i < numNodes; i++){
				if(srcNodes[i]) {
					q.add(i);
					order[i] = 1;
				}
			}

			boolean visited[] = new boolean[numNodes];
			Arrays.fill(visited, false);

			while(!q.isEmpty()){
				int src = q.poll();
				if(visited[src]) continue;
				// for(int k : order)
				// 	System.out.print(k + " ");
				// System.out.println();
				for(Edge e : edges){
					if(e.u == src){
						// big river leading into smaller river
						if(order[e.v] < order[src]) {
							order[e.v] = order[src];
							q.add(e.v);
						}
						// two equal rivers combine
						else if(order[e.v] == order[src]){
							order[e.v]++;
							q.add(e.v);
						}
						// small river leading into big river
						else{}
					}
				}
				visited[src] = true;
			}

			//
			// for(int k = 0; k < numNodes; k++){
			// 	for(int i = 0; i < numEdges; i++){
			// 		for(int j = 0; j < numEdges; j++){
			// 			if(i == j) continue;
			// 			if(edges[i].v == edges[i].v){
			// 				int srcA = edges[i].u;
			// 				int srcB = edges[j].u;
			// 				int comb = (order[srcA] == order[srcB]) ? order[srcA] + 1 : Math.min(order[srcA], order[srcB]);
			// 				order[edges[srcA].v] = Math.max(order[edges[srcA].v], comb);
			// 			}
			// 		}
			// 	}
			// }

			int ans = -1;
			for(int k : order) {
				ans = Math.max(k, ans);
			}
			System.out.println(caseNum + " " + ans);
		}

	}
}
