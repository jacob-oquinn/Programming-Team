import java.util.*;
import java.lang.*;

public class a {
	
	public static Team{
		int disA;
		int disB;
		int numBalloons;
		int val;
		Team(int a, int b, int balloons){
			disA = a;
			disB = b;
			numBalloons = balloons;
			val = a - b;
		}
	}
	
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		int n = scnr.nextInt();
		int A = scnr.nextInt();
		int B = scnr.nextInt();
		
		PriorityQueue<Team> pq = new PriorityQueue<Team>((a,b) -> {
			return Math.abs(a.val) - Math.abs(b.val);
		});
		
		for(int i = 0; i < n; i++){
			int numBalloonsNeeded = scnr.nextInt();
			int disA = scnr.nextInt();
			int disB = scnr.nextInt();
			Team t = new Team(disA, disB, numBalloonsNeeded);
			pq.add(t);			
		}
		
		int total = 0;
		
		while(!pq.isEmpty()){
			Team t = pq.poll();
			
			if(t.val < 0)
			
			
		}
		
	}
}











