import java.util.Scanner;
import java.io.IOException;
public class problem12712 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i ++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] list = new int[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    list[j][k] = sc.nextInt();
                }
            }

            int sum = 0;
            // + 모양으로 뿌리기
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, 1, -1};
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    int tmp = list[r][c];
                    // 시행 횟수 m 만큼
                    for(int h = 1; h < m; h++){
                        for(int d = 0; d < 4; d ++){
                            int nr = r + dr[d] * h;
                            int nc = c + dc[d] * h;
                            if(0 <= nr && nr < n && nc >= 0 && nc < n){
                                tmp += list[nr][nc];
                            }
                        }
                    }

                    if(tmp > sum) {
                        sum = tmp;
                    }
                }
            }

            // x 모양으로 뿌리기
            int[] dr2 = {-1, 1, -1, 1};
            int[] dc2 = {-1, 1, 1, -1};
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    int tmp = list[r][c];
                    // 시행 횟수 m 만큼
                    for(int h = 1; h < m; h++){
                        for(int d = 0; d < 4; d ++){
                            int nr = r + dr2[d] * h;
                            int nc = c + dc2[d] * h;
                            if(0 <= nr && nr < n && nc >= 0 && nc < n){
                                tmp += list[nr][nc];
                            }
                        }
                    }

                    if(tmp > sum){
                        sum = tmp;
                    }
                }
            }

            System.out.printf("#%d %d\n", i + 1, sum);
        }

    }
}
