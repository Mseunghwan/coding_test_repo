import java.io.IOException;
import java.util.Scanner;

public class baekjoon13300 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] room = new int[2][6];
        
        for(int i = 0; i < n; i++){
            int s = sc.nextInt();
            int y = sc.nextInt();
            room[s][y - 1] += 1;
        }
        int result = 0;
        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < 6; j ++){
                if(room[i][j] > 0){
                    if(room[i][j] % k == 0){
                        result += room[i][j] / k;
                    } else {
                        result += (room[i][j] / k) + 1;
                    }
                }
            }
        }
        System.out.println(result);


    }
}
