import java.util.*;
import java.lang.*;

public class sqfree {
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		int arr[] = new int[(int)1e6 + 3];
		
		int s = 1; // which square we are currently on
		int cnt = 0; // how many non squares seen so far
		for(int i = 1; i < arr.length; i++){
			if(i == s*s){
				arr[i] = cnt;
				s++;
			} else 
				arr[i] = ++cnt;
		}
		
		
		int n = scnr.nextInt();
		while(n-->0){
			int a = scnr.nextInt();
			int b = scnr.nextInt();
			System.out.println(arr[b] - arr[a-1]);
		}
		
	}
}