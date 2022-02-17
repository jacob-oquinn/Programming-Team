import java.util.*;
import java.lang.*;

public class g {
	
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int k = scnr.nextInt();
		int m = 4;
		while(true){
			if(k%m == 3) break;
			m++;
		}
		System.out.println(m);
	}
}
