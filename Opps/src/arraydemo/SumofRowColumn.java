package arraydemo;

public class SumofRowColumn {
    public static void main(String[] args) {
        int rows, cols, sumRow, sumCol;

        //Initialize matrix a
        int a[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //Calculates number of rows and columns present in given matrix
        rows = a.length;
        cols = a[0].length;

        for(int i=0;i< rows;i++){
            int sumRows = 0;
            for(int j=0;j<cols;j++){
                sumRows+=a[i][j];
            }
            System.out.println("Sum of " + (i+1) +" row: " + sumRows);
        }
    }
}
