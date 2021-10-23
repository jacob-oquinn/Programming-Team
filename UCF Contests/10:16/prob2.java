import java.util.*;
import java.lang.*;


public class prob2{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		while(n-->0){
			int inSnow = scnr.nextInt();

			int inRain = inSnow / 10;

			int ftSnow = inSnow /  12;
			inSnow -= ftSnow * 12;

			System.out.printf("%d feet, %d inches of snow is the equivalent of %d inches of rain\n", ftSnow, inSnow, inRain);
		}

	}
}
