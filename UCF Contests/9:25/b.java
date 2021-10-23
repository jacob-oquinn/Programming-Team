
import java.util.*;
import java.lang.*;

class b
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        int T = scnr.nextInt();
        scnr.nextLine();
        for(int caseNum = 1; caseNum <= T; caseNum++){
            char[] line = scnr.nextLine().toCharArray();
            char[] transition = scnr.next().toCharArray();
            for(int i = 0; i < line.length; i++){
                if(line[i] == ' ') continue;
                int c = line[i] - 'A';

                line[i] = transition[c];
            }
            System.out.println(caseNum + " " + new String(line));
            if(caseNum != T)scnr.nextLine();
        }
    }
}
