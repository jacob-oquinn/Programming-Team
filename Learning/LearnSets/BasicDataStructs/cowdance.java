import java.util.*;
import java.lang.*;

public class cowdance {
	
	static int n;
	static int tMax;
	static int times[];
	
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		n = scnr.nextInt();
		tMax = scnr.nextInt();
		times = new int[n];
		
		for(int i = 0 ; i < n; i++){
			times[i] = scnr.nextInt();
		}
		
		System.out.println(search(1, n));
		
		
	}
	
	static int search(int l, int h){
		
		int m = (h - l) / 2 + l;
		
		// return the first value that works
		if(l == h) 
			return sim(l) ? l : l+1;
		
		return sim(m) ? search(l, m) : search(m+1, h);
		
	}
	
	static boolean sim(int k){
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		int ind = 0;
		// add in initial k elements
		for(ind = 0; ind < k; ind++){
			heap.add(times[ind]);
		}
		int curTime;
		// jump to next time cow finishes and add next available cow
		while(!heap.isEmpty()){
			curTime = heap.poll();
			
			if(curTime > tMax) return false;
			
			if(ind < times.length)
				heap.add(times[ind++] + curTime);
		}
		
		return true;
		
	}
	
	
	
}