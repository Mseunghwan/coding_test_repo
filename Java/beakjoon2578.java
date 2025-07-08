import java.util.*;
import java.io.*;

public class beakjoon2578 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 초기 빙고판
        int[][] matrix = new int[5][5];

        // 맞췄는지 유무(맞추면 1, 아니면 0)
        int[][] bingo = new int[5][5];

        // 5 번 돌아가면서 초기 빙고 판을 읽어낸다
        for(int i = 0; i < 5; i ++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            for(int j = 0; j < 5; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int val;
        // 이제부터 사회자가 부르는 수가 차례대로 나온다
        for(int i = 0; i < 5; i ++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            for(int j = 0; j < 5; j++){
                val = Integer.parseInt(st.nextToken());
                cnt += 1;
                for(int k = 0; k < 5; k ++){
                    for(int l = 0; l < 5; l ++){
                    if(matrix[k][l] == val){
                        bingo[k][l] = 1;
                        if(check(bingo) >= 3){
                            System.out.println(cnt);
                            return;
                        }
                    }
                }
                }
            }
        }

    }

    public static int check(int[][] bingo){
        int flag = 0;
        int checksum = 0;
        // 가로 체크
        for(int i = 0; i < 5; i ++){
            flag = 0;
            for(int j = 0; j < 5; j ++){

                if(bingo[i][j] == 0){
                    flag = 1;
                    break;
                }

                if(j == 4){
                    if(flag == 0){
                        checksum += 1;
                    }
                }

            }
        }

        // 세로 체크
        for(int i = 0; i < 5; i ++){
            flag = 0;
            for(int j = 0; j < 5; j ++){

                if(bingo[j][i] == 0){
                    flag = 1;
                    break;
                }

                if(j == 4){
                    if(flag == 0){
                        checksum += 1;
                    }
                }

            }
        }
        // 대각 체크(오른 방향)
        for(int i = 0; i < 5; i ++){
            flag = 0;
            if(bingo[i][i] == 0){
                    flag = 1;
                    break;
                }

                if(i == 4){
                    if(flag == 0){
                        checksum += 1;
                    }
                }
        }

        // 대각 체크(왼쪽 방향)
        for(int i = 0; i < 5; i ++){
            flag = 0;
            if(bingo[4 - i][i] == 0){
                    flag = 1;
                    break;
                }

                if(i == 4){
                    if(flag == 0){
                        checksum += 1;
                    }
                }

        }

        return checksum;
    }
}
