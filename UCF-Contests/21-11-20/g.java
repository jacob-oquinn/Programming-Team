import java.util.*;
import java.lang.*;


public class g {

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int numBalls = scnr.nextInt();
		while(numBalls != 0){
			int [] toss = new int[numBalls];
			int ballsUsed = 0;
			char [] sim = new char[20];
			Arrays.fill(sim, '-');
			for(int i = 0 ; i < numBalls; i++){
				toss[i] = scnr.nextInt();
			}

			boolean crash = false;
			for(int i = 0; i < 20; i++){
				if(sim[i] == '-') sim[i] = (char)('A' + ballsUsed++);
				int nextPos = i + toss[i % numBalls];
				if(nextPos < 20 && sim[nextPos] != '-') crash = true;
				if(nextPos < 20){
					sim[nextPos] = sim[i];
				}
			}

			if(crash) System.out.println("CRASH");
			else{
				for(char c : sim)
					System.out.print(c);
				System.out.println();
			}




			numBalls = scnr.nextInt();
		}
	}
}
