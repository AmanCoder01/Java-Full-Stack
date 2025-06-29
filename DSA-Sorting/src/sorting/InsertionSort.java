package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {12,31,35,8,32,17};

        insertionSort(arr,arr.length);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void insertionSort(int[] arr, int n) {
        for(int i=1; i<n; i++) {
          int current = arr[i];
          int prev = i-1;

          while(prev >= 0 && arr[prev] > current){
              arr[prev+1] = arr[prev];
              prev--;
          }

          arr[prev+1] = current;
        }
    }
}
