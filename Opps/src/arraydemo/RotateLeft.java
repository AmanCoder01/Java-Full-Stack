package arraydemo;

public class RotateLeft {
    public static void main(String[] args) {
        int arr[] = new int[] {1,2,3,4,5};
        int n=7 % arr.length;

        System.out.println("Original array");

        for(int i : arr){
            System.out.print(i+" ");
        }

        // logic for rotate
        for(int i=0; i< n;i++){
            int j, first= arr[0];

            for( j=0;j<arr.length-1;j++){
                arr[j] = arr[j+1];
            }

            arr[j] = first;
        }

        System.out.println();
        //Displays resulting array after rotation
        System.out.println("Array after left rotation: ");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
