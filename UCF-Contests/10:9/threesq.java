
import java.util.*;
import java.lang.*;

class threesq
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
		System.out.print((perm(h,w,0)) ? '1' : '0');

    }
	static boolean perm(int[] h, int[] w, int pos){

		if(pos == 3)
			return isValid(h,w);

		for(int i = pos; i < 3; i++){
			int temp;

			// swap pos with i
			temp = h[pos];
			h[pos] = h[i];
			h[i] = temp;
			temp = w[pos];
			w[pos] = w[i];
			w[i] = temp;

			// swap height and width
			if(perm(h,w,pos+1)) return true;
			temp = h[pos];
			h[pos] = w[pos];
			w[pos] = temp;
			if(perm(h,w,pos+1)) return true;
			temp = h[pos];
			h[pos] = w[pos];
			w[pos] = temp;

			// swap pos with i
			temp = h[pos];
			h[pos] = h[i];
			h[i] = temp;
			temp = w[pos];
			w[pos] = w[i];
			w[i] = temp;

		}
		return false;
	}

	static boolean isValid(int[] h, int[] w){
		int tW = 0;
		for(int k : w) tW += k;

		if(h[0] == h[1] && h[1] == h[2] && h[2] == tW)
			return true;

		if(w[0] + w[1] == h[0] + h[2] &&
		   w[2] == w[0] + w[1] &&
		   h[0] == h[1])
		   return true;
		if(w[0] == 1 && w[1] == 7 && w[2] == 8){
			// System.out.println("Not valid: ");
			// for(int i = 0 ; i < 3; i++)
			// 	System.out.println(w[i] + " " + h[i]);
			// System.out.println(w[0] + w[1] == h[0] + h[2]);
			// System.out.println(w[2] == w[0] + w[1]);
			// System.out.println(h[0] == h[1]);
		}
		return false;
	}

}
