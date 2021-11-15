import java.util.*;
import java.lang.*;


public class prob5{

	static class Racer implements Comparable<Racer> {
		double time;
		String name;
		Racer(double time, String name){
			this.time = time;
			this.name = name;
		}
		@Override
		public int compareTo(Racer o){
			if(this.time < o.time) return 1;
			return 0;
		}
	}
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int numTris = scnr.nextInt();

		for(int TriNum = 1; TriNum <= numTris; TriNum++){
			System.out.println("Triathlon #" + TriNum);

			int numPeople = scnr.nextInt();
			int d1 = scnr.nextInt();
			int d2 = scnr.nextInt();
			int d3 = scnr.nextInt();

			Racer[] racers = new Racer[numPeople];
			for(int i = 0 ; i < numPeople; i++){
				String name = scnr.next();
				double s1 = scnr.nextDouble();
				double s2 = scnr.nextDouble();
				double s3 = scnr.nextDouble();

				double time = d1 / s1 + d2 / s2 + d3 / s3;
				racers[i] = new Racer(time, name);

			}

			for(int i = numPeople; i >= 0; i--){
				for(int j = 1; j < i; j++){
					if(racers[j].compareTo(racers[j-1]) == 1){
						Racer temp = racers[j];
						racers[j] = racers[j-1];
						racers[j-1] = temp;
					}
				}
			}


			for(int i = 0 ; i < numPeople; i++){
				int hours = (int)racers[i].time / 3600;
				int mins = (int)racers[i].time / 60 % 60;
				int secs = (int)(racers[i].time) % 60;
				System.out.printf("%s %d hour(s) %d minute(s) %d second(s)\n", racers[i].name, hours, mins, secs);

			}

		}
	}
}
