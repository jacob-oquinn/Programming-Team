import java.util.*;
import java.lang.*;


public class prob7{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int endingTime = scnr.nextInt();
		int grams = scnr.nextInt();
		int flips = scnr.nextInt();

		int b = grams;
		int t = 0;

		int curTime = 0;
		while(flips--> 0){
			int nextTime = scnr.nextInt();
			int dTime = nextTime - curTime;

			int dt = Math.max(t - dTime, 0) - t;
			b += -1 * dt;
			t += dt;

			//System.out.println(t + " " + b);

			curTime = nextTime;
			int temp = b;
			b = t;
			t = temp;
		}
		int dTime = endingTime - curTime;
		int dt = Math.max(t - dTime, 0) - t;
		t += dt;

		System.out.println(t);

	}
}
