import java.util.*;
import java.lang.*;


public class f{

	static class Edge{
		int v;
		int u;
		int w;
		Edge(int uu, int vv, int ww){
			u = uu;
			v = vv;
			w = ww;
		}
	}

	static int cool[];
	static Edge edges[];

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int numNodes = scnr.nextInt();
		int numEdges = scnr.nextInt();
		edges = new Edge[numEdges];
		cool = new int[numNodes];
		Arrays.fill(cool, -1);
		for(int i = 0; i < numEdges; i++){
			edges[i] = new Edge(scnr.nextInt()-1, scnr.nextInt()-1, scnr.nextInt());
		}

		int bestRoute = -1;
		for(int src = 0; src < numNodes; src++){
			bestRoute = Math.max(bestRoute, getCool(src));
		}
		// for(int k : cool) System.out.print(k + " ");
		// System.out.println();
		System.out.println(bestRoute);
	}

	static int getCool(int src){

		if(cool[src] != -1) return cool[src];

		int bestRoute = 0;
		for(Edge e : edges){
			if(e.u == src){
				bestRoute = Math.max(bestRoute, e.w + getCool(e.v));
			}
		}

		cool[src] = bestRoute;
		return cool[src];
	}
}
