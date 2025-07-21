package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {12,31,35,8,32,17};

        bubbleSort(arr,arr.length);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }


    private static void bubbleSort(int[] arr,int n) {

        for(int i=0; i<n-1; i++){
            boolean isSwap =false;

            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwap = true;
                }
            }

            if(!isSwap){
                return;
            }
        }
    }
}
