
import java.util.*;
import java.lang.*;

class exam
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

        int numRight = scnr.nextInt();
        String s1 = scnr.next();
        String s2 = scnr.next();

        int numMatching = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)) numMatching++;
        }
        int numNonMatching = s1.length() - numMatching;
        int ret;
        if(numMatching >= numRight){
            ret = numRight + numNonMatching;
        } else {
            ret = s1.length() - numRight + numMatching;
        }
        System.out.println(ret);
    }
}
