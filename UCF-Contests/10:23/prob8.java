import java.util.*;
import java.lang.*;


public class prob8{

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		while(true){
			int timeAvailable = scnr.nextInt();
			if(timeAvailable == 0) return;

			// don't need number of types of jobs
			scnr.nextInt();

			// position represents time it takes
			// jobs[i] = number of jobs of time i available
			int jobs[] = new int[100];
			Arrays.fill(jobs, 0);

			String jobString = scnr.nextLine();
			jobString = jobString.replace(", ", "-");
			String jobStringArr[] = jobString.substring(1,jobString.length()).split(" ");

			for(String jobS : jobStringArr){
				//System.out.print("jobS = " + jobS);
				jobS = jobS.replace("(", "");
				jobS = jobS.replace(")", "");
				String jobA[] = jobS.split("-");
				int numberJob = Integer.valueOf(jobA[0]);
				int timeJob = Integer.valueOf(jobA[1]);
				jobs[timeJob] += numberJob;
			}
			int jobsCompleted = 0;
			int timeUsed = 0;
			for(int i = 1; i < 100; i++){
				while(timeAvailable >= (timeUsed+i) && jobs[i] > 0){
					jobs[i]--;
					timeUsed += i;
					jobsCompleted++;
				}
			}
			System.out.println(jobsCompleted + " " + timeUsed);


		}


	}
}
