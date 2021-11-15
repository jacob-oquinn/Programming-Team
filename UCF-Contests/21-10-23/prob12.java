


// All pairs shortest path

import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;

public class prob12{

	List<List<String>> fun(List<String> words){

		Set<ArrayList<String>> hm = new HashSet<ArrayList<String>>();

		for(String word : words){
			int[] freq = new int[26];
			for(char c : word.toCharArray()){
				c -= 'a';
				freq[c]++;
			}

			StringBuilder sb = new StringBuilder();
			for(int val : freq){
				sb.append(val);
				sb.append("/");
			}

			String key = sb.toString();
			if(!hm.contains(key)){
				ArrayList<String> al = new ArryaList<String>();
				al.add(word);
				hm.add(key, al);
			} else {
				hm.get(key).add(word);
			}
		}

		List<List<String>> ret = new ArrayList<ArrayList<String>>();
		hm.forEach((al) -> {
			ret.add(al);
		});

		return ret;

	}


	static int disMatrix[][];
	static final boolean DEBUG = false;
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int totalCases = scnr.nextInt();
		for(int caseNum = 1; caseNum <= totalCases; caseNum++){
			int n = scnr.nextInt();
			int elevation[] = new int[n];

			disMatrix = new int[n][n];
			for(int i = 0; i < disMatrix.length; i++)
				Arrays.fill(disMatrix[i], (int)1e8);
			for(int i = 0; i < disMatrix.length; i++)
				disMatrix[i][i] = 0;



			for(int i = 0; i < n; i++)
				elevation[i] = scnr.nextInt();


			int numEdges = scnr.nextInt(); scnr.nextLine();
			for(int i = 0; i < numEdges; i++){
				String s = scnr.nextLine();
				if(DEBUG)System.out.println("s = " + s);
				s = s.replace("(", "");
				s = s.replace(")", "");
				s = s.replace(",", "");

				if(DEBUG)System.out.println("s = " + s);

				String sArr[] = s.split(" ");
				// "-1" to account for 1 to 0 indexing
				int a = Integer.valueOf(sArr[0]) - 1;
				int b = Integer.valueOf(sArr[1]) - 1;

				int dis = Math.abs(elevation[a] - elevation[b]);
				disMatrix[a][b] = dis;
				disMatrix[b][a] = dis;
			}
			if(DEBUG){
				for(int i = 0; i < disMatrix.length; i++){
					for(int k : disMatrix[i])
						System.out.printf("%7d", k);
					System.out.println();
				}System.out.println();
			}
			// now calculate all pairs shortest path
			for(int k = 0; k < n; k++){
				for(int s = 0; s < n; s++){
					for(int e = 0; e < n; e++){
						// new shortest path found
						if(disMatrix[s][e] > disMatrix[s][k] + disMatrix[k][e]){
							int newDis = disMatrix[s][k] + disMatrix[k][e];
							disMatrix[s][e] = newDis;
							disMatrix[e][s] = newDis;
						}
					}
				}
			}




			// calculate distance couple travels using shortest path
			int totalDis = 0;
			int numStops = scnr.nextInt();
			int curPos = scnr.nextInt() - 1; // we always start at 1
			for(int t = 1; t < numStops; t++){
				int nextPos = scnr.nextInt() - 1;
				totalDis += disMatrix[curPos][nextPos];
				curPos = nextPos;
			}
			if(DEBUG){
				for(int i = 0; i < disMatrix.length; i++){
					for(int k : disMatrix[i])
						System.out.printf("%4d", k);
					System.out.println();
				}System.out.println();
			}

			System.out.printf("The least amount of work on trip %d is: %d\n", caseNum, totalDis);
		}
	}
}
