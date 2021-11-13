import java.util.*;
import java.lang.*;


public class b{
	// count number of steps up taken
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int caseNum = scnr.nextInt();
		for(int curCase = 1; curCase <= caseNum; curCase++){
			double ret = 0;
			scnr.next(); // case num
			double distance = scnr.nextDouble();
			double speedA = scnr.nextDouble();
			double speedB = scnr.nextDouble();
			double speedFly = scnr.nextDouble();

			for(int i = 0; i < 1000; i++){
				double time = distance / (speedA + speedFly);
				ret += speedFly * time;

				distance -= (time * speedA) + (time * speedB);

				double t = speedA;
				speedA = speedB;
				speedB = t;
			}


			System.out.printf("%d %.2f\n",curCase, (float)ret);
		}
	}
}
