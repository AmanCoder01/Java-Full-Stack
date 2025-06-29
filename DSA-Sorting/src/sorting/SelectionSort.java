package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {12,31,35,8,32,17};

        selectionSort(arr,arr.length);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }


    private static void selectionSort(int[] arr, int n) {
        for(int i=0; i< n-1; i++){
            int minIdx = i;

            for(int j= i+1; j<n; j++){
                if(arr[j]<arr[minIdx]){
                    minIdx = j;
                }
            }

            // swap is needed
            if(minIdx!=i){
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }
}
