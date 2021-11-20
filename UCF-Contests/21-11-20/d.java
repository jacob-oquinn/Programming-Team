import java.util.*;
import java.lang.*;


public class d {

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		String input = scnr.nextLine();
		while(!input.equals("END")){

			// System.out.println("input == " + input);

			boolean isValid = true;

			// Check if first char is a quote then rmeove
			if(input.charAt(0) != '"') isValid = false;

			// find second quote
			int i = 1;
			for(; i < input.length(); i++)
				if(input.charAt(i) == '"') break;
			// no second " or it was an empty string
			if(i >= input.length() || i == 1) isValid = false;

			// check if space following " is a space
			if(isValid && input.charAt(i+1) != ' ') isValid = false;

			String str1 = new String();
			if(isValid){
				str1 = input.substring(1,i);
				// +2 will skip the extra space
				String str2 = input.substring(i+2, input.length());

				// System.out.println(str1 + " : " + str2);

				isValid = (str1.equals(str2));
			}

			System.out.println((isValid) ? ("Quine(" + str1 + ")") : ("not a quine"));



			input = scnr.nextLine();
		}
	}
}
