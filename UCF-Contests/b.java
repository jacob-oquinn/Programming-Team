import java.util.*;
import java.lang.*;


public class a{
	// count number of steps up taken
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int caseNum = scnr.nextInt();
		for(int curCase = 1; curCase <= caseNum; curCase++){
			double ret = 0;
			scnr.next(); // case num
			double distance = scnr.nextDouble();
			double speedA = scrn.nextDouble();
			double speedB = scrn.nextDouble();
			double speedFly = scrn.nextDouble();

			for(int i = 0; i < 1000; i++){
				int time = distance / (speedA / speedFly);
				ret += speedFly * time;

				distance -= (time * speedA) + (time * speedB);
				Collections.swap(speedA, speedB);
			}


			System.out.println(curCase + " " + ret);
		}
	}
}
