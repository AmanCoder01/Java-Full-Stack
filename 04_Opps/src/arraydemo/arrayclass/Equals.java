package arraydemo.arrayclass;

import java.util.Arrays;

public class Equals {

    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,8,4,9,0,3};
        int arr2[] = new int[]{1,2,8,4,9,0,3};

        System.out.println(Arrays.equals(arr1,arr2));
    }
}
