
import java.util.*;
import java.lang.*;

class truth
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		int [][] vals = new int[n][2];
		for(int i = 0 ; i < n ; i++){
			vals[i][0] = scnr.nextInt();
			vals[i][1] = scnr.nextInt();
		}

		for(int k = n; k >= 0; k--){

			int truths = 0;
			for(int i = 0 ; i < n; i++){
				if(k >= vals[i][0] && k <= vals[i][1]) truths++;
			}
			if(truths == k){
				System.out.print(k);
				return;
			}

		}
		System.out.print("-1");
	}


}
