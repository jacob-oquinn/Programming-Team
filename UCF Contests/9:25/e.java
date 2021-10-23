
import java.util.*;
import java.lang.*;

class e
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        int T = scnr.nextInt();
        while(T-->0){
			int numBoxes = scnr.nextInt();
			int boxes[] = new int[numBoxes];
			for(int i = 0; i < numBoxes; i++){
				boxes[i] = scnr.nextInt();
			}
			int upJump = scnr.nextInt();
			int downJump = scnr.nextInt();

			int n = 0;
			// insert each box at the first position
			for(int i = 0; i < boxes.length; i++){
				boolean[] used = new boolean[numBoxes];
				used[i] = true;
				int[] path = new int[numBoxes];
				path[0] = boxes[i];
				n += permute(path, boxes, 1, used, upJump, downJump);
			}
			System.out.println(n);
		}

    }
	static int permute(int[] path, int[] boxes, int p, boolean used[], int upJump, int downJump){

		// found a valid permutation
		if(p == boxes.length){
			return 1;
		}
		int n = 0;
		for(int i = 0; i < boxes.length; i++){
			if(used[i]) continue;
			// going up
			if(boxes[i] > path[p - 1]){
				if(boxes[i] - path[p - 1] > upJump) continue;
			}
			// going down
			if(boxes[i] < path[p - 1]){
				if(path[p - 1] - boxes[i] > downJump) continue;
			}
			path[p] = boxes[i];
			used[i] = true;
			n += permute(path, boxes, p+1, used, upJump, downJump);
			used[i] = false;
		}

		return n;

	}
}










//
