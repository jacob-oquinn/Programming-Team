import java.util.*;
import java.lang.*;

class SegmentTree {

    int [] tree;
    int n;

    public SegmentTree(int nn) {
        this.n = nn;
        tree = new int[2 * n];
        Arrays.fill(tree, 0);
    }

    public void update(int index, int val) {
        index += n;
        // update leaf value
        tree[index] = val;

        // propogate upwards
        while(index > 0){
            int l = leftChild(parent(index));
            int r = rightChild(parent(index));

            tree[parent(index)] = Math.max(tree[l], tree[r]);
            index = parent(index);
        }
    }

    public int maxRange(int l, int r) {
        // Shift to leaf nodes
        l += n;
        r += n;
        int max = -1;
        while(l <= r){
            if(l % 2 == 1){
                max = Math.max(tree[l], max);
                l++;
            }
            if(r % 2 == 0){
                max = Math.max(tree[r], max);
                r--;
            }
            r = parent(r);
            l = parent(l);
        }
        return max;
    }

    private int parent(int t){
        return t / 2;
    }
    private int leftChild(int t){
        return t * 2;
    }
    private int rightChild(int t){
        return t * 2 + 1;
    }
}

public class zigzag{

    static final int LEN = (int)1e6+40;

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();

        SegmentTree u = new SegmentTree(LEN);
        SegmentTree d = new SegmentTree(LEN);

        for(int i = 0; i < n; i++){
            //
            // for(int j = 0;j < LEN*2; j++)
            //     System.out.printf("%4d", u.tree[j]);
            // System.out.println();
            // for(int j = 0;j < LEN*2; j++)
            //     System.out.printf("%4d", d.tree[j]);
            // System.out.println();
            int x = scnr.nextInt();
            int maxDown = u.maxRange(0,x-1);
            // System.out.println("maxDown = " + maxDown);
            int maxUp = d.maxRange(x+1,LEN-1);
            // System.out.println("maxUp = " + maxUp);
            u.update(x, maxUp+1);
            d.update(x, maxDown+1);
        }

        int maxDown = u.maxRange(0,LEN-1);
        int maxUp = d.maxRange(0,LEN-1);
        int max = Math.max(maxDown, maxUp);
        System.out.println(max);
    }
}
