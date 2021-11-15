
import java.util.*;
import java.lang.*;

class i
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        int T = scnr.nextInt();
        for(int caseNum = 1; caseNum <= T; caseNum++){
			int numStars = scnr.nextInt(); // 1- 1000
			int numConnections = scnr.nextInt(); // 1 - 10000

			ArrayList<HashSet<Integer>> adjList = new ArrayList<HashSet<Integer>>(numStars+1);
			for(int i = 0; i < numStars+1; i++){
				adjList.add(new HashSet<Integer>());
			}

			while(numConnections --> 0){
				int a = scnr.nextInt();
				int b = scnr.nextInt();
				adjList.get(a).add(b);
				adjList.get(b).add(a);
			}

			int numCycles = 0;
			int numConstellations = 0;
			boolean visited[] = new boolean[numStars+1];

			for(int i = 1; i <= numStars; i++){
				if(visited[i]) continue;

				if(adjList.get(i).size() != 0)
					numConstellations++;
				if(isCycle(adjList, visited, i, -1))
					numCycles++;
			}
			//                 Night sky #3: 1 constellations, of which 0 need to be fixed.
			System.out.printf("Night sky #%d: %d constellations, of which %d need to be fixed.\n\n", caseNum, numConstellations, numCycles);
        }
    }

	static boolean isCycle(ArrayList<HashSet<Integer>> adjList, boolean[] visited, Integer cur, Integer prev){

		// already visited this node, cycle is present
		if(visited[cur]) return true;
		visited[cur] = true;

		Integer [] neighbors = new Integer[adjList.get(cur).size()];
		neighbors = adjList.get(cur).toArray(neighbors);

		boolean cycleFound = false;
		for(Integer neighbor : neighbors){
			// Don't go back the way we came
			if(neighbor.equals(prev)) continue;

			if(isCycle(adjList, visited, neighbor, cur)) cycleFound = true;

		}
		return cycleFound;
	}
}



















//
