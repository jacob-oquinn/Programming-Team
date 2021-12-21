import java.util.*;
import java.lang.*;

public class polling {
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		
		int n = scnr.nextInt();
		String arr1[] = new String[n];
		String arr2[] = new String[n];
		for(int i = 0; i < n; i++)
			arr1[i] = scnr.next();
		for(int i = 0; i < n; i++)
			arr2[i] = scnr.next();
		
		HashSet<String> hs = new HashSet<String>();
		
		int count = 0;
		
		for(int i = 0; i < n; i++){	
			count++;
			
			if(!hs.contains(arr1[i]))
				hs.add(arr1[i]);
			else
				hs.remove(arr1[i]);
			
			if(!hs.contains(arr2[i]))
				hs.add(arr2[i]);
			else
				hs.remove(arr2[i]);
			
			if(hs.size() == 0){
				System.out.println(count);
				count = 0;
			}
		}
		
	}
}