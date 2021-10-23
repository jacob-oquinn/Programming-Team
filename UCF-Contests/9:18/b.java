
import java.util.*;
import java.lang.*;

class b
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

        int num = scnr.nextInt();
        while(num != 0){

          while(num >= 10){
            System.out.print(num+" ");
            num = multiplyDigits(num);
          }System.out.println(num);

          num = scnr.nextInt();

        }
    }

    public static int multiplyDigits(int num){
        int prod = 1;
        while(num > 0){
          prod *= num % 10;
          num /= 10;
        }
        return prod;
    }
}
