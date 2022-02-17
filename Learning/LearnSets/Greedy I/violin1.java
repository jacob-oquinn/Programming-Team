import java.util.*;
import java.lang.*;

public class violin1 {
	
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		int c = scnr.nextInt();
		
		while(c-->0){
			int n = scnr.nextInt();
			int count = 0;
			
			boolean pressed[] = new boolean[5];
			Arrays.fill(pressed, false);
			while(n-->0){
				int val = scnr.nextInt();
				for(int i = 4; i >= val && i > 0; i--){
					if(i == val){
						if(!pressed[i])
							count++;
						pressed[i] = true;
					} else if(pressed[i]){
						pressed[i] = false;
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
}











