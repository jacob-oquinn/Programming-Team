import java.util.*;
import java.lang.*;


public class i {
	// Assume all leaf nodes are 1
	// if sum > target return false
	// add difference all to the left most node
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int depth = scnr.nextInt();
		int target = scnr.nextInt();
		// get sum of elements on kth pascal layer
		int sum = 0;
		ArrayList<Integer> curLayer = new ArrayList<Integer>();
		curLayer.add(1);
		for(int i = 1; i < depth; i++){
			ArrayList<Integer> prevLayer = curLayer;
			curLayer = new ArrayList<Integer>();
			curLayer.add(1);
			for(int j = 1; j < i; j++){
				curLayer.add(prevLayer.get(j-1) + prevLayer.get(j));
			}
		}
		int sum = 0;
		curLayer.forEach((k) -> {sum += k});
	}

}
