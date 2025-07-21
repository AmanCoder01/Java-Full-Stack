package arraydemo;

public class ArrayCopy {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};

        for(int i : arr){
            System.out.print(i);
        }

        System.out.println();

        int copyArr[] = new int[arr.length];
        System.arraycopy(arr,0,copyArr,0,arr.length);

        for(int i : copyArr){
            System.out.print(i);
        }
    }
}
