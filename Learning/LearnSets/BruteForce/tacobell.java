import java.util.*;
import java.lang.*;

public class tacobell {
	
	static String names[];
	static int max;
	
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		int c = scnr.nextInt();
		
		while(c-->0){
			int n = scnr.nextInt();
			max = scnr.nextInt();
			names = new String[n];
			for(int i = 0 ; i < n ; i++){
				names[i] = scnr.next();
			}
			Arrays.sort(names);
			for(int i = 0 ; i < names.length / 2; i ++){
				String s = names[i];
				names[i] = names[names.length - i - 1];
				names[names.length - i - 1] = s;
			}
			getList(0, new HashSet<String>(), 0);
			System.out.println();
		}
		
	}
	static void getList(int itemsUsed, HashSet<String> hs, int index){
		if(itemsUsed == max){
			Iterator it = hs.iterator();
			String[] arr = new String[max];
			int i = 0;
			while(it.hasNext()){
				arr[i++] = it.next().toString();
			}
			Arrays.sort(arr);
			for(String s : arr)
				System.out.print(s + " ");
			System.out.println();
			return;
		}
		if(itemsUsed > max) return;
		
		if(index >= names.length) return;
		
		// leave
		getList(itemsUsed, hs, index+1);
		
		// take
		hs.add(names[index]);
		getList(itemsUsed + 1, hs, index+1);
		hs.remove(names[index]);
		
	}
}











