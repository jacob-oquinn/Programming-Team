import java.util.*;
import java.lang.*;


public class a{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		long a = scnr.nextLong();
		while(a != 0){
			// a^2 = 2*w*h-w^2
			int count = 0;
			for(long w = 1; ; w++){
				if( (a*a + w*w) % (2*w) == 0 ) {
					long h = (a*a + w*w) / (2*w);
					if( h - w <= a) break;
					// System.out.println(w);
					count++;
				}

			}
			System.out.println(count);


			a = scnr.nextInt();
		}
	}
}
