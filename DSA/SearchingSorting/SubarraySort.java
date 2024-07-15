package CompetitiveProgramming.SearchingSorting;

public class SubarraySort {

    public static boolean outOfOrder(int[] arr,int i){
        int num = arr[i];
        int n = arr.length;
        if(i==0){
            //spl case
            return num > arr[i+1];
        }
        else if(i==n-1){
            return num < arr[i-1];
        }
        return num > arr[i+1] || num < arr[i-1];
    }

    public static void subarrayRange(int[] arr){
        int MinElement = Integer.MAX_VALUE;
        int MaxElement = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(outOfOrder(arr,i)){
                MinElement = Math.min(MinElement,arr[i]);
                MaxElement = Math.max(MaxElement,arr[i]);
            }
        }
        if(MinElement == Integer.MAX_VALUE){
            System.out.println("No such subarray exists, as array is already sorted!");
            return;
        }

        int leftIdx = 0;
        int rightIdx = arr.length-1;
        while(arr[leftIdx]<=MinElement){
            leftIdx++;
        }
        while(arr[rightIdx]>=MaxElement){
            rightIdx--;
        }
        System.out.println(leftIdx+ " "+ rightIdx);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,7,10,11,12,6,7,16,18,19,20,25};
        int n = arr.length;
        subarrayRange(arr);

    }
}
