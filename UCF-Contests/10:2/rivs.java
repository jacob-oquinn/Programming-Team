
import java.util.*;
import java.lang.*;

class rvis
{
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);


		Long maxLen = scnr.nextLong();
		Long k = scnr.nextLong();

		ArrayList<Long> arr1 = new ArrayList<Long>();
		ArrayList<Long> arr2 = new ArrayList<Long>();
		int len1 = scnr.nextInt();
		while(len1-->0)
			arr1.add(scnr.nextLong());
		int len2 = scnr.nextInt();
		while(len2-->0)
			arr2.add(scnr.nextLong());

		ArrayList<Long> sum = new ArrayList<Long>();
		// sum
		int i = 0;
		int j = 0;
		while(i != arr1.size() || j != arr2.size()){
			if(i == arr1.size()){
				sum.add(arr2.get(j));
				j++;
				continue;
			}
			if(j == arr2.size()){
				sum.add(arr1.get(i));
				i++;
				continue;
			}
			// if they concel each other continue (-1 + 1 = 0)
			if(Math.abs(arr1.get(i)) == Math.abs(arr2.get(j))){
				if(arr1.get(i) < 0 ^ arr2.get(j) < 0){
					i++; j++;
					continue;
				}
			}

			if( Math.abs(arr1.get(i)) < Math.abs(arr2.get(j)) ){
				sum.add(arr1.get(i));
				i++;
			} else {
				sum.add(arr2.get(j));
				j++;
			}
		}

		ArrayList<Long> prod = new ArrayList<Long>();
		// prod
		i = 0;
		j = 0;
		while(i != arr1.size() && j != arr2.size()){
			// if they aren't the same position move on
			if(Math.abs(arr1.get(i)) == Math.abs(arr2.get(j))){
				// if both are negative return positive
				if(arr1.get(i) < 0 && arr2.get(j) < 0){
					prod.add(arr1.get(i) * -1);
				} else {
					// if either is negative a negative should be returned
					prod.add(Math.min(arr1.get(i), arr2.get(j)));
				}
				i++; j++;
				continue;
			}

			if( Math.abs(arr1.get(i)) < Math.abs(arr2.get(j)) ){
				i++;
			} else {
				j++;
			}
		}

		ArrayList<Long> rot1 = rotate(arr1, k, maxLen);
		ArrayList<Long> rot2 = rotate(arr2, k, maxLen);

		printArr(sum);
		printArr(prod);
		printArr(rot1);
		printArr(rot2);
	}

	static void printArr(ArrayList<Long> arr){
		System.out.print(arr.size() + " ");
		for(int i = 0;  i < arr.size(); i++){
			Long t = arr.get(i);
			System.out.printf("%d ",t);
		}System.out.println();
	}

	static ArrayList<Long> rotate(ArrayList<Long> arr, Long k, Long maxLen){
		int[] negatives = new int [arr.size()];
		// make all values positives but remember which were negatives
		for(int i = 0 ;  i < arr.size(); i++){
			if(arr.get(i) < 0) negatives[i] = -1;
			else negatives[i] = 1;
			// make positive then apply rotation
			Long rep = (Math.abs(arr.get(i)) - k <= 0 ) ? Math.abs(arr.get(i)) - k + maxLen :  Math.abs(arr.get(i)) - k;
			arr.set(i, rep);
		}
		// set back to negative
		for(int i = 0 ;  i < arr.size(); i++){
			arr.set(i, arr.get(i) * negatives[i]);
		}

		Collections.sort(arr, (a, b) -> {
			if(Math.abs(a) < Math.abs(b)) return -1;
			if(Math.abs(a) == Math.abs(b)) return 0;
			return 1;
		});

		return arr;
	}


}
