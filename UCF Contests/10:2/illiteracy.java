import java.util.*;
import java.lang.*;

class illiteracy
{
    static int n;

	static Queue<String> q;
	static HashMap<String, Integer> hm;
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

		//for(int k = 0; k < 260; k++){

			String start = scnr.next();
			String end = scnr.next();

			q = new LinkedList<String>();
			hm = new HashMap<String, Integer>();

			q.add(start);
			hm.put(start, 0);

			int oo = Integer.MAX_VALUE;
			int ans = oo;

			while(!q.isEmpty() && ans == oo){

				String s = q.remove();
				int dis = hm.get(s) + 1;

				// try to preform each rotation
				for(int i = 0; i < s.length(); i++){

					//System.out.println("dis = " + dis + ", ans = " + ans);

					String sRot = rotate(s, i);

					if(sRot.equals(end))
						ans = dis;

					// only add back into queue if it could potentially improve our ans
					// put into hashmap if the key doesn't exist OR the distance has been reduced
					if(!hm.containsKey(sRot)){
						q.add(sRot);
						hm.put(sRot, dis);
					}

				}
			}
			System.out.println((ans == oo) ? -1 : ans);
		//}

	}


	static String rotate(String s, int i){

		char c = s.charAt(i);
		char[] str = s.toCharArray();

		switch(c){
			// A: Rotates the icon immediately to the left, if there is one, and immediately to the right, if there is one.
			case 'A':
			if(i > 0)
				str[i-1] = nextChar(str[i-1]);
			if(i < s.length()-1)
				str[i+1] = nextChar(str[i+1]);
			break;

			/* B: If not on the end, changes the icon immediately to the right to be same as the one
			immediately to the left (does nothing on the ends). This is the only icon that doesn’t
			Rotate other icons. */
			case 'B':
				if(i != s.length() - 1 && i != 0)
					str[i+1] = str[i-1];
			break;

			/*C: Rotates the mirror image (when clicked in position x, Rotates 9-x. e.g. clicking 1
			Rotates 8, 2 Rotates 7, etc.)
			i = 0 -> 7
			i = 1 -> 6
			i = 2 -> 5
			...
			i = 6 -> 1
			i = 7 -> 0
			*/
			case 'C':
				str[7-i] = nextChar(str[7-i]);
			break;

			/*D: Rotates all of the icons between this one and the closest end. (e.g. clicking 3 Rotates
			1 and 2, 5 Rotates 6, 7 and 8. Clicking this icon on the end does nothing.)*/
			case 'D':
				if(i <= 3){
					for(int j = 0; j < i; j++){
						str[j] = nextChar(str[j]);
					}
				} else {
					for(int j = 7; j > i; --j){
						str[j] = nextChar(str[j]);
					}
				}
			break;

			/*E: Rotates the closest end, and also the position which is the same distance in the
			opposite direction. (e.g. clicking 1 does nothing, 2 Rotates 1 and 3, 3 Rotates 1 and 5, 5
			Rotates 8 and 2, 7 Rotates 8 and 6, etc.)*/
			case 'E':
				if(i != 0 && i <= 3){
					str[0] = nextChar(str[0]);
					str[i+i] = nextChar(str[i+i]);
				}
				if(i != 7 && i >= 4){
					str[7] = nextChar(str[7]);
					str[i-(7-i)] = nextChar(str[i-(7-i)]);
				}
			break;

			/* F: Rotates another position with this pattern: Clicking 1 Rotates 5, 2 Rotates 1, 3 Rotates
			6, 4 Rotates 2, 5 Rotates 7, 6 Rotates 3, 7 Rotates 8, and 8 Rotates 4. In other words,
			clicking an icon in an odd position Rotates (x+9)/2, even Rotates x/2. */
			case 'F':
				// 1 -> 5
				if(i == 0) str[4] = nextChar(str[4]);
				// 2 -> 1
				if(i == 1) str[0] = nextChar(str[0]);
				// 3 -> 6
				if(i == 2) str[5] = nextChar(str[5]);
				// 4 -> 2
				if(i == 3) str[1] = nextChar(str[1]);
				// 5 -> 7
				if(i == 4) str[6] = nextChar(str[6]);
				// 6 -> 3
				if(i == 5) str[2] = nextChar(str[2]);
				// 7 -> 8
				if(i == 6) str[7] = nextChar(str[7]);
				// 8 -> 4
				if(i == 7) str[3] = nextChar(str[3]);

			break;
			default:
			System.out.println("Error, default state reached");
		}
		return new String(str);
	}

	static char nextChar(char c){
		return (c == 'F') ? 'A' : ++c;
	}

}
