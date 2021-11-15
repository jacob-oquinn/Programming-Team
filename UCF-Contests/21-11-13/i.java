import java.util.*;
import java.lang.*;


public class i{
	// count number of steps up taken
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		int heros[] = new int[n];
		int villians[] = new int[n];
		for(int i = 0; i < n; i++){
			heros[i] = scnr.nextInt();
		}
		for(int i = 0; i < n; i++){
			villians[i] = scnr.nextInt();
		}
		int training = 0;
		while(sim(heros, villians, training) == false){
			training++;
		}

		System.out.println(training);
	}

	static boolean sim(int heros[], int villians[], int training){
		for(int i = 0; i < heros.length; i++){
			if(villians[i] > heros[i] + training) return false;
			if(villians[i] < heros[i] + training) return true;
		}
		return true;
	}
}
