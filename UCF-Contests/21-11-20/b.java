import java.util.*;
import java.lang.*;


public class b{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		while(n != 0){
			System.out.print(n + " ");
			while(n >= 10){
				int prod = 1;
				while(n != 0){
					prod *= n % 10;
					n /= 10;

				}
				n = prod;
				System.out.print(n + " ");
			}
			System.out.println();
			n = scnr.nextInt();
		}
	}
}
