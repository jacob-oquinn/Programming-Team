import java.util.*;
import java.lang.*;

public class b {
	static class Person{
		String name;
		double val;
		String[] rankings;
		Person(String n, String[] r){
			name=n;
			rankings = r;
			val = -1;
		}
	}
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		List<Person> people = new ArrayList<Person>();
		for(int i = 0; i < n; i++){
			String name = scnr.next().replace(":","");
			String[] r = scnr.nextLine().split(" ");

			people.add(new Person(name, r));
		}
		for(int i = 0; i < n; i++){
			double k = Math.pow(3,50);
			double val = 0;
			Person p = people.get(i);
			for(int j = p.rankings.length - 1; j >= 0; j--){
				String s = p.rankings[j];
				if(s.equals("lower")){
					val += 1 * k;
				}
				else if(s.equals("middle")){
					val += 0;
				}
				else if(s.equals("upper")){
					val += -1 * k;
				}
				k /= 3;
			}
			people.get(i).val = val;
		}


		Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (o2.val==o1.val) ? o1.name.compareTo(o2.name) : (int)(o1.val-o2.val);
            }
        });
		for(int i = 0; i < n; i++)
			System.out.println(people.get(i).name);
	}
}
