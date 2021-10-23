import java.util.*;
import java.lang.*;

public class panoptes{

	public static void main(String[] args){

		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		int p = scnr.nextInt();

		double percents[] = new double[n];
		double avg = 0;
		for(int i = 0; i < n; i++){
			double temp = scnr.nextFloat();
			avg += temp;
			percents[i] = temp;
		}
		avg /= n;
		double threshold = avg * 0.8;

		boolean isImportant[] = new boolean[n];
		for(int i = 0; i < n; i++){
			isImportant[i] = (percents[i] < threshold);
		}

		boolean done = false;
		for(int step = p; step < n && !done; step++){
			// try each starting position
			for(int start = 0; start < step && !done; start++){
				int i = start;
				while(i < n && isImportant[i]) i+=step;
				done = (i >= n);
			}
			if(done)
				System.out.println(step);
		}
		if(!done)
			System.out.println(-1);

	}
}
