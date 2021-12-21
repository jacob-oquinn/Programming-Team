import java.util.*;
import java.lang.*;

public class politics {
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		
		while(true){
			int n = scnr.nextInt();
			int m = scnr.nextInt();
			if(n == 0 || m == 0) break;
			
			ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			
			for(int i = 0; i < n; i++){
				hm.put(scnr.next(), i);
				a.add(new ArrayList<String>());
			}
			
			for(int i = 0; i < m; i++){
				String name = scnr.next();
				String canidate = scnr.next();
				
				if(!hm.containsKey(canidate)){
					hm.put(canidate, hm.size());
					a.add(new ArrayList<String>());
				}
				
				a.get(hm.get(canidate)).add(name);
				
			}
			
			a.forEach((arr) -> {
				arr.forEach((name) -> {
					System.out.println(name);
				});
			});
			
			
		}

		
		
	}
}