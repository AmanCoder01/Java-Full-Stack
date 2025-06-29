package arraydemo.arrayclass;

import java.util.Arrays;
import java.util.Collections;

public class SortArray {

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1,2,8,4,9,0,3};

        Arrays.sort(arr,Collections.reverseOrder());


        System.out.println(Arrays.toString(arr));
    }
}
