import java.util.*;
import java.lang.*;


public class a{
	// Convert 3d coordinates to just distance from dome
	// sort and get the Kth element
	// make that element our radius
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		int k = scnr.nextInt();

		double dis[] = new double[n];
		for(int i = 0; i < n; i++){
			double x = scnr.nextDouble();
			double y = scnr.nextDouble();
			double z = scnr.nextDouble();
			dis[i] = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
		}

		Arrays.sort(dis);

		System.out.println(dis[k-1]);
	}
}
