import java.util.*;
import java.lang.*;


public class d {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in); s.nextInt();

		for(int cC = -1; s.hasNext() && (cC=s.nextInt())!=-1; )
			for(int m=s.nextInt(), l=2, a=1, b=1, c; ;c=(a+b)%m, a=b, b=c, l++)
				if(a==1&&b==0){System.out.println(cC+" "+l);break;}




	}
}
