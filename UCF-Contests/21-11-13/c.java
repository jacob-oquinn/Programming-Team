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

	static int order[];
	static Edge edges[];
	static int numNodes;
	static int numEdges;

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int numCases = scnr.nextInt();
		for(int caseNum = 1; caseNum <= numCases; caseNum++){
			scnr.nextInt(); // get rid of case num
			numNodes = scnr.nextInt();
			numEdges = scnr.nextInt();
			edges = new Edge[numEdges];
			for(int i = 0; i < numEdges; i++){
				edges[i] = new Edge(scnr.nextInt()-1, scnr.nextInt()-1);
			}



			// srcNodes starts off as the source nodes (no incoming edges)
			boolean srcNodes[] = new boolean[numNodes];
			Arrays.fill(srcNodes, true);
			for(Edge e : edges){
				srcNodes[e.v] = false;
			}
			order = new int[numNodes];
			Arrays.fill(order, -1);
			for(int i = 0; i < numNodes; i++)
				if(srcNodes[i]) order[i] = 1;


			for(int i = 0; i < numNodes; i++){
				getOrder(i);
			}
			// for(int k : order) System.out.print(k + " ");
			// System.out.println();
			System.out.println(caseNum + " " + getOrder(numNodes-1));
		}

	}
	static int getOrder(int cur){
		if(order[cur] != -1) return order[cur];

		int freq[] = new int[numNodes+1];
		boolean srcVisited[] = new boolean [numNodes];
		Arrays.fill(srcVisited, false);

		int highestOrder = -1;
		for(Edge e : edges){
			if(e.v == cur){
				if(!srcVisited[e.u]) freq[getOrder(e.u)]++;
				srcVisited[e.u] = true;
			}
		}
		// check if 2+ incoming edges of had equal order
		for(int i = 0; i < freq.length; i++){
			if(freq[i] == 1) highestOrder = Math.max(highestOrder, i  );
			if(freq[i] >= 2) highestOrder = Math.max(highestOrder, i+1);
		}

		order[cur] = highestOrder;
		return order[cur];
	}
}
