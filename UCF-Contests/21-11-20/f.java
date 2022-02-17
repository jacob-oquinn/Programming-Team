import java.util.*;
import java.lang.*;


public class f{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int cap = scnr.nextInt();
		int counter = 0;
		while(cap > 0){
			counter++;
			System.out.println("Simulation " + counter);

			String instructions = scnr.next();

			char cache[] = new char[cap];
			Queue<Character> q = new LinkedList<Character>();
			int size = 0;

			for(int i = 0 ; i < instructions.length(); i++){
				char val = instructions.charAt(i);

				if(val == '!') {
					q.forEach((c) -> {
						System.out.print(c);
					});
					System.out.println();
				}
				else if(size < cap){
					if(!q.remove(val)) size++;
					q.add(val);
				}
				else {
					// if val is already in the cache just update it to back
					if(q.remove(val)){
						q.add(val);
					} else{
						// lets replace the element at the front of the queue
						q.poll();
						q.add(val);
					}
				}
			}



			cap = scnr.nextInt();
		}
	}
}
