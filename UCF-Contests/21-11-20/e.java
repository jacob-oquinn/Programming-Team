
import java.util.*;
import java.lang.*;


char [][] nums = [


]


public class e {

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		ArrayList<String> al = new ArrayList<String>();

		for(int i = 0; i < 7; i++){
			al.add(scnr.next());
		}
		int numChars = al.get(0).length() + 1 / 6;

		for(int i = 0; i < numChars; i++){
			int offset = i * 6;

			char val;

			System.out.println(val);
		}
	}
}



/*
			// middle bar
			if(al.get(3).charAt(offset+3) == 'x'){
				// bottom right
				if(al.get(5).charAt(offset+5) == 'x'){
					// botton left
					if(al.get(4).charAt(offset) == 'x'){
						// top right
						if(al.get(2).charAt(offset+5) == 'x'){
							val = '8';
						} else {
							val = '6';
						}
					} else {
						// top left
						if(al.get(2).charAt(offset) == 'x'){
							// top bar
							if(al.get(0).charAt(offset+2) == 'x'){
								// top right
								if(al.get(2).charAt(offset+5) == 'x'){
									val = '9';
								} else {
									val = '5';
								}
							} else {
								val = '4';
							}
						} else {
							val = '3';
						}
					}
				} else {
					if(al.get(6).charAt(offset)=='x'){
						val = '2';
					} else {
						val = '+';
					}
				}
			} else {
				// left bar
				if(al.get(2).charAt(offset) == 'x'){
					val = '0';
				} else {
					// top bar
					if(al.get(0).charAt(offset + 2) == 'x'){
						val = '7';
					} else {
						val = '1';
					}
				}
			}
*/
