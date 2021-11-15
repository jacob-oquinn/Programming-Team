
import java.util.*;
import java.lang.*;


class a {
	public static void main(String args[])
	{
		Scanner scnr = new Scanner(System.in);
		int T = scnr.nextInt();
		for(int caseNum = 1; caseNum <= T; caseNum++){
			int numMountains = scnr.nextInt(); // 1- 1000
			int numConnections = scnr.nextInt(); // 1 - 10000

			ArrayList<Edge> edges = new ArrayList<Edge>(numMountains);

			for(int i = 0; i < numConnections;i++){
				int src = scnr.nextInt(); // start
				int dest = scnr.nextInt(); // end
				int time = scnr.nextInt(); // time difference due to portal
				edges.add(new Edge(src, dest, time));
			}

			boolean pathExist = bellmanFord(new boolean[numMountains], numMountains, edges, 0);

			System.out.printf("Case #%d: ", caseNum);

			if(pathExist)
				System.out.println("possible");
			else
				System.out.println("not possible");
		}
	}

	public static class Edge{
		int u,v,w;
		public Edge(int uu, int vv, int ww){
			u=uu;v=vv;w=ww;
		}
	}

	static int oo = 99999999;

	public static boolean bellmanFord(boolean[] negCycles, int n, ArrayList<Edge> edges, int source){
		int[] dist = new int[n];
		Arrays.fill(dist, oo);
		dist[source] = 0;

		for(int x = 0; x < n - 1; x++){
			for(Edge e : edges){
				if(dist[e.u] + e.w < dist[e.v]){
					dist[e.v] = dist[e.u] + e.w;
				}
			}
		}
		// for(int dis : dist)
		// 	System.out.print(dis + " ");
		// System.out.println();

		// direct path from src to src that went back in time
		if(dist[0] < 0) return true;

		// If change is still occuring those nodes are part of a negative cycle
		boolean change[] = new boolean[n];
		Arrays.fill(change, false);
		for(Edge e : edges){
			//System.out.printf("(Dist[%d] = %d) + (e.w = %d) < (dist[%d] = %d)\n", e.u, dist[e.u], e.w, e.v, dist[e.v]);
			if(dist[e.u] + e.w < dist[e.v]){
				change[e.v] = true;
			}
		}

		// for(boolean c : change)
		// 	System.out.print(c + " ");
		// System.out.println();

		for (int t = 0; t < n; t++) {
			for(Edge e : edges) {
				if(change[e.u]) change[e.v] = true;
			}
		}
		return change[0];

		/*
		// check if src was part of negative cycle
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++)
			visited[i] = false;

		for(int i = 0; i < n; i++){
			if(!change[i] || visited[i]) continue;
			if(dfs(edges, visited, i, 0)) {
				// System.out.println("YYAYYAYAY");
				return true;
			}
		}
		return false;
		*/

	}
	static boolean dfs(ArrayList<Edge> edges, boolean[] visited, int src, int target){

		if(src == target) {
			// System.out.println("src==target");
			return true;
		}
		visited[src] = true;

		for (int i = 0; i < edges.size(); i++) {
  			Edge e = edges.get(i);
			// System.out.printf("Try: %d -> %d\n", src, e.v);
			if(e.u != src || visited[e.v]) continue;
			// System.out.printf("DFS: %d -> %d\n", src, e.v);
			if(dfs(edges, visited, e.v, target)) return true;
		}
		return false;
	}

}
