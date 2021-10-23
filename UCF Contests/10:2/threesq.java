
import java.util.*;
import java.lang.*;

class histogram
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
		int [] h = new int [3];
		int [] w = new int [3];
		for(int i = 0; i < 3; i++){
			h[i] = scnr.nextInt();
			w[i] = scnr.nextInt();
		}
		boolean[] used = new boolean[3];
		Arrays.fill(used,false);
		System.out.print((perm(h,w) ? '1' : '0');

    }
	static boolean perm(int[] h, int[] w, boolean used[]){
		boolean finished = true;
		for(int i = 0; i < 3; i++){
			if(used[i]) continue;
			finsished = false;
			used[i] = true;
			if(perm(h,w,used)) return true;
			int temp = h[i];
			h[i] = w[i];
			w[i] = temp;
			if(perm(h,w,used)) return true;
			temp = h[i];
			h[i] = w[i];
			w[i] = temp;
			used[i] = false;
		}
		if(finished)
			return isValid(h,w);
		return false;
	}

	static boolean isValid(intp[] h, int[] w){
		int tW = 0;
		for(int k : w) tW += k;
		if(h[0] == h[1] == h[2] == tW) return true;

		if(w[0] + w[1] == h[0] + h[2] &&
		   w[2] == w[0] + w[1] &&
		   h[2] == h[1])
		   return true;

		return false;
	}

}
