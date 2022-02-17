import java.util.*;
import java.lang.*;

public class a {
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		int n = scnr.nextInt();
		
		while(n-->0){
			
			int k = scnr.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			while(k-->0) pq.add(scnr.nextInt());
			long sum = 0;
			while(pq.size() > 1) {
				int a = pq.poll();
				int b = pq.poll();
				sum += a + b;
				pq.add(a + b);
			}
			System.out.println(sum);
		}
	}
}