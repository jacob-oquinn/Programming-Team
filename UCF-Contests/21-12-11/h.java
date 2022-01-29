import java.util.*;
import java.lang.*;

public class h {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		long a = scnr.nextLong();
		long ret = 0;
		while(a/10 > 0){
			ret++;
			long newA = 1;
			while(a != 0){
				newA*=a%10;
				a/=10;
			}
			a= newA;
		}
		System.out.println(ret);
	}
}
