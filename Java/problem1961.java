import java.util.Scanner;
import java.io.IOException;

public class problem1961{
    public static void main(String[] args) throws IOException { 

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int n = sc.nextInt();

            // arr 만들기
            int[][] arr = new int[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k ++){
                    arr[j][k] = sc.nextInt();
                }
            }

            System.out.printf("#%d\n", i + 1);
            
            // 90도
            int[][] arr90 = rotate(arr);

            // 180도
            int[][] arr180 = rotate(arr90);
            
            // 270도
            int[][] arr270 = rotate(arr180);
            
            // 돌아가며 출력, 각각의 1 행 부터
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    System.out.print(arr90[j][k]);
                }
                System.out.print(" ");
                for(int k = 0; k < n; k++){
                    System.out.print(arr180[j][k]);
                }
                System.out.print(" ");
                for(int k = 0; k < n; k++){
                    System.out.print(arr270[j][k]);
                }
                System.out.println();
            }
        }

    }


public static int[][] rotate(int[][] matrix){
    int n = matrix.length;
    int[][] rotatedMatrix = new int[n][n];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            rotatedMatrix[i][j] = matrix[n - 1 - j][i];
        }
    }
    return rotatedMatrix;
}
}