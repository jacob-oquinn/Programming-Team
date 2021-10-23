
import java.util.*;
import java.lang.*;

class j
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        int T = scnr.nextInt();
        scnr.nextLine();
        for(int caseNum = 1; caseNum <= T; caseNum++){
			System.out.printf("Case #%d: ", caseNum);

			int input = getInt(scnr.next());
			int goal = getInt(scnr.next());

			// System.out.println("input == " + Integer.toBinaryString(input));
			// System.out.println("goal == " + Integer.toBinaryString(goal));

			int left = getLeftDistance(input, goal, 0);
			int right = getRightDistance(input, goal, 0);

			if(left == -1){
				System.out.println("Not possible");
				continue;
			}
			if(left < right){
				System.out.println(left + " Left");
			}
			else if(left > right){
				System.out.println(right + " Right");
			} else {
				System.out.println(left + " Any");
			}

        }
    }

	static int getInt(String s){
		int ret = 0;
		for(char c : s.toCharArray()){
			ret = ret << 4;
			if(Character.isAlphabetic(c)) ret += c - 'A' + 10;
			else ret += c - '0';
		}
		//System.out.println(s + " -> " + Integer.toBinaryString(ret));
		return ret;
	}

	static int getLeftDistance(int n1, int n2, int d){
		if(d > 33) return -1;
		if(n1 == n2) return d;
		int head = (n1 >> 31) & 1;
		n1 *= 2;
		n1 += head;

		//System.out.println((long)n1 + " == " + Integer.toBinaryString(n1));
		return getLeftDistance(n1, n2, d+1);
	}
	static int getRightDistance(int n1, int n2, int d){

		if(d > 33) {
			return -1;
		}
		if(n1 == n2) {
			return d;
		}
		int head = n1 & 1;
		n1 = n1 >>> 1;
		if(head == 1)
			n1 += 1 << 31;


		// System.out.println("n1 == " + Integer.toBinaryString(n1));
		// System.out.println("n2 == " + Integer.toBinaryString(n2));

		return getRightDistance(n1, n2, d+1);
	}
}
