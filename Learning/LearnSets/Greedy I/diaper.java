import java.util.*;
import java.lang.*;

public class diaper {
	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		
		int numCases = scnr.nextInt();
		
		for(int caseNum = 1; caseNum <= numCases; caseNum++){
			
			int numWaste = scnr.nextInt();
			int numDiapers = scnr.nextInt();
				
			Diaper arr[] = new Diaper[numDiapers];
			for(int i = 0; i < arr.length; i++){
				int quantity = scnr.nextInt();
				int price = Integer.valueOf(scnr.next().replace(".", ""));
				int capacity = scnr.nextInt();
				
				arr[i] = new Diaper(quantity, price, capacity);
			}
			ArrayList<Integer> waste = new ArrayList<Integer>();
			while(numWaste-->0)
				waste.add(scnr.nextInt());
			
			int bestPrice = Integer.MAX_VALUE;
			int bestIndex = -1;
			
			for(int i = 0; i < arr.length; i++){
				Diaper d = arr[i];
				int moneySpent = d.price;
				int capacityLeft = d.capacity;
				int diaperLeft = d.quantity;
				for(int j = 0; j < waste.size(); j++){
					int w = waste.get(j);
					if(w > d.capacity){
						moneySpent = Integer.MAX_VALUE;
						break;
					}
					capacityLeft -= w;
					if(capacityLeft < 0){
						diaperLeft--;
						capacityLeft = d.capacity - w;
					}
					if(diaperLeft <= 0){
						diaperLeft = d.quantity;
						moneySpent += d.price;
					}
				}
				if(moneySpent < bestPrice){
					bestPrice = moneySpent;
					bestIndex = i;
				}
			}
			
			String s = String.valueOf(bestPrice);
			String bestPriceStr = new String();
			if(s.length() > 2)
				bestPriceStr = s.substring(0, s.length()-2) + "." + s.substring(s.length()-2, s.length());
			else if(s.length() == 2)
				bestPriceStr = "." + s;
			else 
				bestPriceStr = ".0" + s;
			
			System.out.printf(
				"Diaper Scenario #%d: Buying box %d, you spend $%s.\n", 
				caseNum, bestIndex+1, bestPriceStr);
			
			
		}
		
	}
	
	static class Diaper {
		int quantity;
		int price;
		int capacity;
		Diaper(int q, int p, int c){
			this.quantity = q;
			this.price = p;
			this.capacity = c;
		}
		
		
	}
	
}