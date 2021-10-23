
import java.util.*;
import java.lang.*;

class d
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

        int T = scnr.nextInt();
        for(int i = 1; i <= T; i++){
          int cents = scnr.nextInt();
          int nQ = subtract(cents, 25); cents %= 25;
          int nD = subtract(cents, 10); cents %= 10;
          int nN = subtract(cents, 5); cents %= 5;
          int nP = subtract(cents, 1);

          System.out.println(i + " " + nQ + " QUARTER(S), " + nD + " DIME(S), "+nN+" NICKEL(S), "+nP+" PENNY(S)");
        }
    }

    public static int subtract(int cents, int value){
      int ret = 0;
      while(cents >= value){
        ret++;
        cents -= value;
      }
      return ret;
    }
}
