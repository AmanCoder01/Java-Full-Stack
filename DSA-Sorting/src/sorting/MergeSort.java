package sorting;

import java.util.Vector;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {12, 31, 35, 8, 32, 17};

        mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] arr, int st, int end) {//O(log n) TC
        if(st<end) {
            int mid = st + (end - st) / 2;

            mergeSort(arr, st, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr,st,mid,end);
        }
    }

    private static void merge(int[] arr, int st, int mid, int end) {//O(n) TC
        Vector<Integer> vector = new Vector<>();
        int i = st,j=mid+1;

        while (i<=mid && j<=end){
            if(arr[i]<arr[j]){
                vector.add(arr[i]);
                i++;
            } else {
                vector.add(arr[j]);
                j++;
            }
        }

        while(i<=mid){
            vector.add(arr[i]);
            i++;
        }
        while(j<=end){
            vector.add(arr[j]);
            j++;
        }

        for(int idx=0;idx<vector.size();idx++){
            arr[idx+st] = vector.get(idx);
        }
    }
}
