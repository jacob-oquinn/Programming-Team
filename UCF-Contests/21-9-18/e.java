import java.util.*;
import java.lang.*;

class e {

	static class Time{
		int h;
		int m;

		Time(String s){
			int[] vals = strToHMM(s);
			h = vals[0];
			m = vals[1];
		}
		Time(int hh, int mm){
			h = hh; m = mm;
		}

		Time(Time otherT){
			this.h = otherT.h;
			this.m = otherT.m;
		}

		boolean equals(Time otherT){
			return (this.h == otherT.h && this.m == otherT.m);
		}

		int[] strToHMM(String s){
			String strs[] = s.split(":");

			int[] ret = new int[2];

			ret[0] = Integer.valueOf(strs[0]);
			ret[1] = Integer.valueOf(strs[1]);
			return ret;
		}

		void update(String s){
			// if a '+' is present we need to shift the clock back
			boolean goBack = (s.charAt(0) == '+');

			int[] vals = strToHMM(s);
			int hh = vals[0];
			int mm = vals[1];

			if(goBack){
				m += mm;
				while(m > 59){
					m -= 60;
					h += 1;
				}
				hh %= 12;
				h += hh;
				while(h > 12){
					h -= 12;
				}
			} else {
				m -= mm;
				while(m < 0){
					m += 60;
					h -= 1;
				}
				hh %= 12;
				h -= hh;
				while(h < 1){
					h = 12 - h;
				}
			}
		}
		public String toString(){
			StringBuilder s = new StringBuilder();
			s.append(h);
			s.append(':');
			s.append(String.format("%02d", m));
			return new String(s);
		}
	}

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int numCases = scnr.nextInt();
		while(numCases-->0){
			// Throwing a number back at the judge
			System.out.print(scnr.nextInt() + " ");

			int n = scnr.nextInt();

			Time times[] = new Time[n];
			String diffs[] = new String[n];

			for(int i = 0; i < n; i++){
				String s = scnr.next();
				times[i] = new Time(s);
			}

			for(int i = 0; i < n; i++){
				diffs[i] = scnr.next();
			}

			boolean usedDiffs[] = new boolean[n];
			Arrays.fill(usedDiffs, false);

			int numSolutions = 0;
			for(int i = 0; i < n; i++){
				Time t = new Time(times[0]);

				System.out.print(t + " + " + diffs[i] + " => ");
				t.update(diffs[i]);
				System.out.println(t);


				usedDiffs[i] = true;
				numSolutions += perm(times, diffs, usedDiffs, 1, t);
				usedDiffs[i] = false;
			}
			System.out.println((numSolutions == 0) ? "-1" : numSolutions);
		}
	}


	static int perm(Time[] times, String[] diffs, boolean[] usedDiffs, int pos, Time prevTime){

		// We reached the end of the array with everything matching
		if(pos == times.length){
			return 1;
		}

		int numSolutions = 0;
		for(int i = 0; i < times.length; i++){

			// Already used this value
			if(usedDiffs[i]) continue;
			Time t = new Time(times[pos]);
			t.update(diffs[i]);

			// Times Don't match
			if(!t.equals(prevTime)) continue;

			usedDiffs[i] = true;
			numSolutions += perm(times, diffs, usedDiffs, pos + 1, t);
			usedDiffs[i] = false;
		}
		return numSolutions;
	}


}
















//
