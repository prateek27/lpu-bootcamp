package CompetitiveProgramming.SearchingSorting.LadderProblem;

public class Permutation {
    static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void permute(char[] arr,int start,int n){
        //base case
        if(start==arr.length-1){
            System.out.println(arr);
            return;
        }
        //bring the ith character to the front
        for(int i=start;i<arr.length;i++){
            swap(arr,i,start);
            permute(arr,start+1,n);
            //undo the swap to restore the prev state of the array
            swap(arr,i,start);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        char[] arr = s.toCharArray();
        permute(arr,0,3);
    }
}
