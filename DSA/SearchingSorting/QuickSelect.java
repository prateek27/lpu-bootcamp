package CompetitiveProgramming.SearchingSorting;

import static java.util.Collections.swap;

public class QuickSelect {

    public static int partition(int[] arr,int s,int e){
        //choose a pivot and put it at its correct place
        int pivot = arr[e];
        int i=-1;
        for(int j=0;j<e;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,e);
        return i+1;
    }

    private static void swap(int arr[],int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int quickSelectHelper(int[] arr,int s,int e,int k){
        if(s>e){
            throw new RuntimeException("Invalid K");
        }

        //rec case
        int p = partition(arr,s,e);
        if(p==k){
            return arr[k];
        }
        else if(p>k){
            return quickSelectHelper(arr,s,p-1,k);
        }
        else{
            return quickSelectHelper(arr,p+1,e,k);
        }
    }
    public static int quickSelect(int[] arr,int k){
       return quickSelectHelper(arr,0,arr.length-1,k-1);
    }
    public static void main(String[] args) {
        int[] arr = {8,5,2,9,17,6,3};
        int k =2; //1-based indexing

        System.out.println(quickSelect(arr,k));
        return;
    }
}
