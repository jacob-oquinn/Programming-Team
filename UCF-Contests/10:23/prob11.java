import java.util.*;
import java.lang.*;


public class prob11{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		for(int i = 1; i <= n; i++){
			int pow = scnr.nextInt();
			System.out.print("1");
			System.out.printf("%03d", i);
			while(pow-->0)
				System.out.print("0");
			System.out.print(" ");
		}

	}
}
