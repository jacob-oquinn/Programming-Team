
import java.util.*;
import java.lang.*;


class illiteracyInput {
	public static void main(String args[])
	{
		for(int i = 0; i < 520; i++){
			char [] s = new char[8];
			for(int j = 0; j < 8; j++){
				s[j] = (char)(Math.random()*6 + 'A');
			}
			System.out.println(s);
		}
	}

}
