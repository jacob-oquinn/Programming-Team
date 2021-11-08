import java.util.*;
import java.lang.*;


public class e{
	// sort weights Array
	// take the largest buckets available and the smallest if possible
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int numCases = scnr.nextInt();
		while(numCases-->0){
			int caseNum = scnr.nextInt();
			String s = scnr.next();
			String arr[] = s.split("/");
			int p = Integer.parseInt(arr[0]);
			int q = Integer.parseInt(arr[1]);

			Stack<Character> st = new Stack<Character>();
			while(p != 1 || q != 1){
				if(p > q){
					st.push('R');
					p -= q;
				}else {
					st.push('L');
					q -= p;
				}
			}
			int ret = 1;
			while(!st.empty()){
				ret *= 2;
				if(st.pop() == 'R') ret++;
			}

			System.out.println(caseNum + " " + ret);
		}

	}
}
