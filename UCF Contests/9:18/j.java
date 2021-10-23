
// Also need to add a check for given values
//    if all their neightbors are full then we should make sure its proper size

import java.util.*;
import java.lang.*;

class j
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);

        int T = scnr.nextInt();
        while(T-->0){
            int caseNum = scnr.nextInt();
            int[][] arr = new int[10][10];
            boolean[][] isGiven = new boolean[10][10];

            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    arr[i][j] = scnr.nextInt();
                    isGiven[i][j] = !(arr[i][j] == -1);
                }
            }

            rec(arr, 0, 0, isGiven);

            System.out.println(caseNum);
            printOutput(arr);


        }
    }
    static void printOutput(int[][] arr){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.printf("%4d", arr[i][j]);
            }System.out.println();
        }
    }
    public static boolean rec(int[][] arr, int x, int y, boolean[][] isGiven){


        int i = x, j = y;

        // find next empty spot
        boolean foundEmpty = false;
        for(; i < 10; i++){

            for(; j < 10; j++){
                if(arr[i][j] == -1) {
                    foundEmpty = true;
                    break;
                }
            }
            if(foundEmpty) break;
            j = 0;
        }

        // solution found
        // eventually check all given values match
        if(!foundEmpty) {
          System.out.println("All spots filled");

          return true;
        }

        for(int val = 1; val <= 3; val++){
            arr[i][j] = val;
            if(isValid(arr, i, j, isGiven) && rec(arr, i, j, isGiven)){
                return true;
            }
        }
        return false;
    }
    // check surrounding squares if they have gone over capacity
    static boolean isValid(int[][] arr, int x, int y, boolean[][] isGiven){

        // check if we've gone over vertically or horozontally
        if(isOverCapacityCol(arr, y, isGiven) || isOverCapacityRow(arr, x, isGiven)) return false;

        // left, topleft, topmid, topright...
        int[]dx = {-1,-1,0,1,1,1,0,-1};
        int[]dy = {0,1,1,1,0,-1,-1,-1};
        for(int i = 0; i < 8; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            // check if we are OOB or we are on a square WE fill
            if(!isInbounds(newX, newY) || !isGiven[newX][newY]) continue;
            if(isOverCapacity(arr, newX, newY, isGiven) || isUnderCapacity(arr, newX, newY, isGiven)){
                return false;
            }
        }
        return true;
    }
    static boolean isOverCapacity(int[][] arr, int x, int y, boolean[][] isGiven){
      int cap = arr[x][y];
      // left, topleft, topmid, topright...
      int[]dx = {-1,-1,0,1,1,1,0,-1};
      int[]dy = {0,1,1,1,0,-1,-1,-1};
      int sum = 0;
      for(int i = 0; i < 8; i++){
          int newX = x+dx[i];
          int newY = y+dy[i];
          if(!isInbounds(newX, newY)) continue;
          if(!isGiven[newX][newY] && arr[newX][newY] != -1){
              sum += arr[newX][newY];
          }
      }
      return cap < sum;
    }
    static boolean isUnderCapacity(int[][] arr, int x, int y, boolean[][] isGiven){
      int cap = arr[x][y];
      // left, topleft, topmid, topright...
      int[]dx = {-1,-1,0,1,1,1,0,-1};
      int[]dy = {0,1,1,1,0,-1,-1,-1};
      int sum = 0;
      for(int i = 0; i < 8; i++){
          int newX = x+dx[i];
          int newY = y+dy[i];
          // still has room to grow
          if(!isInbounds(newX, newY)) continue;
          if(arr[newX][newY] == -1) return false;
          if(!isGiven[newX][newY]){
              sum += arr[newX][newY];
          }
      }
      // If we did not hit quota we need to go back and make changes
      return cap > sum;
    }

    static boolean isOverCapacityCol(int[][] arr, int col, boolean[][] isGiven){
        int sum = 0;
        for(int row = 0; row < 10; row++){
            if(isGiven[row][col] || arr[row][col] == -1) continue;
            sum += arr[row][col];
        }
        return sum > 10;
    }
    static boolean isOverCapacityRow(int[][] arr, int row, boolean[][] isGiven){
        int sum = 0;
        for(int col = 0; col < 10; col++){
            if(isGiven[row][col] || arr[row][col] == -1) continue;
            sum += arr[row][col];
        }
        return sum > 10;
    }

    static boolean isInbounds(int x, int y){
        return !(x < 0 || x >= 10 || y < 0 || y >=10);
    }
}
