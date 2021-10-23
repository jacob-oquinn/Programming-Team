
import java.util.*;
import java.lang.*;

class a
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        while(n-->0){
            int max = -1;
            int[] votes = new int [3];

            for(int i = 0; i < 3; i++){
                votes[i] = scnr.nextInt();
                max = Math.max(max, votes[i]);
            }

            int maxCount = 0;
            for(int i = 0 ; i< 3; i++){
                if(votes[i] == max) maxCount++;
            }

            for(int i = 0; i < 3; i++){
                if(votes[i] == max) {
                    System.out.print(((maxCount > 1) ? 1 : 0) + " ");
                    continue;
                }
                System.out.print(max-votes[i]+1 + " ");
            }System.out.println();

        }
    }
}
