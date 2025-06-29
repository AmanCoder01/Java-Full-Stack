package arraydemo;

public class FrequencyEachElement {

    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 3, 2, 2, 2, 5, 1};
        int freq[] = new int[arr.length];
        int visited = -1;

        for(int i = 0; i < arr.length; i++){
            int count = 1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                    freq[j] = visited;
                }
            }

            if(freq[i] != visited)
                freq[i] = count;
        }

        //Displays the frequency of each element present in array
        System.out.println("---------------------------------------");
        System.out.println(" Element | Frequency");
        System.out.println("---------------------------------------");
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != visited)
                System.out.println("    " + arr[i] + "    |    " + freq[i]);
        }
        System.out.println("----------------------------------------");
    }
}
