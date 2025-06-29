package sorting;

public class QuickSort {

    public static void quickSort(int arr[],int st,int end){
        if(st<end){
            int pivotIdx = partion(arr,st,end);
            quickSort(arr,st,pivotIdx-1);
            quickSort(arr,pivotIdx+1,end);
        }
    }

    private static int partion(int[] arr, int st, int end) {
        int idx = st-1, pivot = arr[end];

        for(int j = st; j<end; j++){
            if(arr[j] <= pivot){
                idx++;
                swap(arr,j,idx);
            }
        }
        idx++;
        swap(arr,end,idx);
        return idx;
    }

    private static void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
      int arr[] = {12,31,35,8,32,17};

      quickSort(arr,0,arr.length-1);

      for(int i : arr){
          System.out.print(i+" ");
      }


    }
}
