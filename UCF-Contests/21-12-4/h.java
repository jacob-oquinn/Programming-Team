import java.util.*;
import java.lang.*;

public class h {

	static class Circle{
		double x;
		double y;
		double r;
		Circle(double xx, double yy, double rr){
			x = xx;
			y = yy;
			r = rr;
		}
		boolean canContact(Circle o){
			double dist = Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y-o.y,2));
			double range = Math.max(this.r, o.r);
			//System.out.println((this.x)+ " : " + o.x);
			return dist < range;
		}
		Circle merge(ArrayList<Circle> al){
			double sumX = this.x;
			double sumY = this.y;
			double sumA = this.r * this.r * Math.PI;
			for(int i = 0; i < al.size(); i++){
				Circle c = al.get(i);
				sumX += c.x;
				sumY += c.y;
				sumA += c.r * c.r * Math.PI;
			}
			return new Circle(sumX / (al.size()+1), sumY / (al.size()+1), Math.sqrt(sumA / Math.PI));
		}

	}

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);

		int n = scnr.nextInt();
		while(n != 0){

			ArrayList<Circle> groups = new ArrayList<Circle>();
			while(n-->0){
				double x = scnr.nextDouble();
				double y = scnr.nextDouble();
				double r = scnr.nextDouble();
				Circle next = new Circle(x,y,r);

				while(true){
					ArrayList<Circle> contacts = new ArrayList<Circle>();
					ArrayList<Circle> remaining = new ArrayList<Circle>();

					for(int i = 0; i < groups.size(); i++){
						Circle c = groups.get(i);
						if(c == next) continue;
						if(next.canContact(c)){
							contacts.add(c);
						} else
							remaining.add(c);
					}

					// merge current circle with contacts
					next = next.merge(contacts);
					// add current circle to remaining cirles
					remaining.add(next);
					groups.clear();
					for(int i = 0; i < remaining.size(); i++){
						groups.add(remaining.get(i));
					}

					// stop looping if no NEW contacts were merged
					if(contacts.size() == 0){
						break;
					}
				}
			}
			System.out.println(groups.size());
			n = scnr.nextInt();
		}

	}
}
