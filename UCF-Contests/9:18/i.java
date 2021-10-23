
import java.util.*;
import java.lang.*;

class i
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

        int T = scnr.nextInt();
        while(T-->0){

            int wordLen = scnr.nextInt();

            ArrayList<ArrayList<Character>> letters = new ArrayList<ArrayList<Character>>();

            for(int i = 0; i < wordLen; i++){
                String temp = scnr.next();
                ArrayList<Character> newArr = new ArrayList<Character>();
                for(Character c : temp.toCharArray()){
                    newArr.add(c);
                }
                letters.add(newArr);
            }

            int pos = scnr.nextInt();

            char[] ans = new char[wordLen];

            for(int i = 0; i < wordLen; i++){

                // How passcode are skipped for each letter we shift at i
                int numPossibilities = 1;
                for(int j = i+1; j < wordLen; j++){
                    numPossibilities *= letters.get(j).size();
                }

                int index = 0;
                while(pos > numPossibilities){
                    index++;
                    pos -= numPossibilities;
                }
                ans[i] = letters.get(i).get(index);
            }

            System.out.println(new String(ans));


        }
    }

}
