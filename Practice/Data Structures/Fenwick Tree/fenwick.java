import java.util.*;
import java.lang.*;


class fenwick {

	final static int MAX = 500;
	public static int[] tree = new int[MAX];

	public static void main(String[] args){

		int [] arr = {1,2,3,4s,5,6,7};

		fenwick bitree = new fenwick();
		bitree.initialize(arr);

		System.out.println(bitree.query(6));

		arr[0] += 100;
		bitree.update(0, 100, arr.length + 1);

		System.out.println(bitree.query(6));

	}

	private static void initialize(int[] arr){
		Arrays.fill(tree, 0);
		for(int i = 0; i < arr.length; i++){
			update(i, arr[i], arr.length+1);
		}
	}

	private static int query(int index){
		int ret = 0;
		for(index += 1; index > 0; index -= Integer.lowestOneBit(index))
			ret += tree[index];
		return ret;
	}

	private static void update(int index, int val, int n){
		for(index += 1; index < n; index += Integer.lowestOneBit(index))
			tree[index] += val;
	}
}
