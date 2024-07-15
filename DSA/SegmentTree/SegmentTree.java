package CompetitiveProgramming.SegmentTree;

public class SegmentTree {

    int tree[];
    int n;

    public SegmentTree(int arr[]){
        n = arr.length;
        tree = new int[4*n+1]; //over-estimate
        build(arr,1,0,n-1);
    }

    void build(int arr[],int idx,int s,int e){
        if(s==e){
            tree[idx] = arr[s];
            return;
        }
        int mid = (s+e)/2;
        build(arr,2*idx,s,mid);
        build(arr,2*idx+1,mid+1,e);
        tree[idx] = Math.min(tree[2*idx],tree[2*idx+1]);
    }

    private int RMQqueryHelper(int qs,int qe,int idx,int s,int e){
        //3 Cases
        //Complete Overlap
        if(s>=qs && e<=qe){
            return tree[idx];
        }

        //No Overlap
        if(e<qs || s>qe){
            return Integer.MAX_VALUE;
        }

        //Partial Overlap
        int mid = (s+e)/2;
        int left = RMQqueryHelper(qs,qe,2*idx,s,mid);
        int right = RMQqueryHelper(qs,qe,2*idx+1,mid+1,e);
        return Math.min(left,right);
    }
    int query(int qs,int qe){
        return RMQqueryHelper(qs,qe,1,0,n-1);
    }
    void updateHelper(int treeIdx,int s,int e,int i,int val){
        //base case (leaf node)
        if(s==e){
            tree[treeIdx] = val;
            return;
        }

        //rec case
        else{
            int mid = (s+e)/2;
            if(i>mid){
                //right subtree
                updateHelper(2*treeIdx+1,mid+1,e,i,val);
            }
            else{
                //left subtree
                updateHelper(2*treeIdx,s,mid,i,val);
            }
            tree[treeIdx] = Math.min(tree[2*treeIdx],tree[2*treeIdx+1]);
        }
    }

    void update(int i,int value){
        updateHelper(1,0,n-1,i,value);
    }
    void print(){
        for(int x:tree){
            System.out.print(x+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {4,5,8,2,1,7,3};
        SegmentTree segmentTree = new SegmentTree(arr);
        System.out.println(segmentTree.query(1,4)); //1
        System.out.println(segmentTree.query(1,3)); //2
        segmentTree.update(4,11);
        System.out.println(segmentTree.query(1,5)); //2
        System.out.println(segmentTree.query(4,4)); //11
        System.out.println(segmentTree.query(4,5)); //7

        // segmentTree.print();

    }
}
