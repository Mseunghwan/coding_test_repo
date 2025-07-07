import java.util.Scanner;
import java.io.IOException;
public class problem1959 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int[] A;
        int[] B;

        for(int i = 0; i < t; i ++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            A = new int[n];
            B = new int[m];
            for(int j = 0; j < n; j++){
                A[j] = sc.nextInt();
            }
            for(int j = 0; j < m; j++){
                B[j] = sc.nextInt();
            }
            
            int tempSum;
            int max = 0;

            if(n > m) { 
                int temp = n;
                n = m;
                m = temp;

                int[] tempArr = A;
                A = B;
                B = tempArr;
            }

            for(int j = 0; j <= Math.abs(m - n); j++){
                tempSum = 0;
                for(int k = 0; k < n; k++){
                    tempSum += A[k] * B[j + k];
                }
                if(max < tempSum){
                    max = tempSum;
                }
            }
            System.out.printf("#%d %d\n", i + 1, max);
        }

    }
}
