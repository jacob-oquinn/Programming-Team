import java.util.*;
import java.lang.*;

public class k {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		String [] strs = new String[n];
		while(n-->0){
			char[] str = scnr.next().toCharArray();
			for(int i = 0; i < str.length/2; i++){
				char t = str[i];
				str[i] = str[str.length-i-1];
				str[str.length-i-1] = t;
			}
			strs[n] = new String(str);
		}
		Arrays.sort(strs);
		for(String s : strs)
			System.out.println(s);
	}
}
