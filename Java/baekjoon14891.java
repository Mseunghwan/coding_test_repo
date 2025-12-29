import java.util.*;
import java.io.*;

public class baekjoon14891 {
    static public class Node {
        int gearNum;
        int direction;
        Node(int gearNum, int direction){
            this.gearNum = gearNum;
            this.direction = direction;
        }
    }

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 극이 다르면 회전 O , 같으면 회전 X
        
        int[][] gears = new int[4][8];
        for(int i = 0 ; i < 4; i ++){
            String line = br.readLine();
            for(int j = 0; j < 8; j++){
                gears[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int K = Integer.parseInt(br.readLine());

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0 ; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            
            queue.add(new Node(gearNum, direction));
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int startGear = now.gearNum;
            int startDir = now.direction;

            // 각 톱니가 이번 턴에 회전할 방향 저장하는 배열(0 : 정지, 1 : 시계, -1 : 반시계)
            int[] d = new int[4];
            d[startGear] = startDir;

            // 왼쪽 톱니들 확인
            for(int i = startGear; i > 0; i--){
                if(gears[i][6] != gears[i - 1][2]){
                    // 극이 다르면 반대 방향으로 회전
                    d[i - 1] = -d[i];
                } else {
                    // 극이 같으면 회전 X
                    break;
                }
            }

            // 오른쪽 톱니들 확인
            for(int i = startGear; i < 3; i++){
                if(gears[i][2] != gears[i + 1][6]){
                    d[i + 1] = -d[i];
                } else { 
                    break;
                }
            }

            // 톱니들 회전
            for(int i = 0 ; i < 4; i ++){
                if(d[i] == 0) continue; // 다음 케이스로

                int[] temp = Arrays.copyOf(gears[i], 8);

                if(d[i] == - 1){
                    for(int j = 0; j < 8 ; j++){
                        gears[i][j] = temp[(j + 1) % 8];
                    }
                }
                else { 
                    for(int j = 0; j < 8 ; j++){
                        gears[i][j] = temp[(j + 7) % 8];
                    }
                }
            }

            

        }


        int rs = 0;
        for(int i = 0 ; i < 4; i++){
            if(gears[i][0] == 1){
                rs += Math.pow(2, i);
            }
        }
        
        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();


    }
}
