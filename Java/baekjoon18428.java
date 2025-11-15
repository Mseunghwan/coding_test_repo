import java.util.*;
import java.io.*;

public class baekjoon18428{
    static char[][] maps;
    static int N;
    static boolean rs = false;
    static ArrayList<Pos> teachers = new ArrayList<>();

    static class Pos{
        int y;
        int x;

        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void dfs(int start, int cnt){
        if(rs){
            return;
        }

        if(cnt == 3){
            if(look()){
                rs = true;
            }
            return;
        }

        for(int a = start; a < N * N; a++){
            int i = a / N;
            int j = a % N;
            if(maps[i][j] == 'X'){
                maps[i][j] = 'O';
                dfs(a + 1, cnt + 1);
                maps[i][j] = 'X';
            }
        }

    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static boolean look() {
        for(Pos now : teachers){
            for(int i = 0; i < 4; i++){
                int x = now.x;
                int y = now.y;

                while(true){
                    x += dx[i];
                    y += dy[i];
                    
                    if(0 > y || y >= N || x < 0 || x >= N){
                        break;
                    }
                    if(maps[y][x] == 'O'){
                        break;
                    }
                    if(maps[y][x] =='S'){
                        return false;
                    }
                    }
                }
            }
        
            return true;
        }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());


        StringTokenizer st;
        
        maps = new char[N][N];
        for(int i = 0; i < N; i++){
        st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                char val = st.nextToken().charAt(0);
                maps[i][j] = val;
                if(val == 'T'){
                    teachers.add(new Pos(i, j));
                }
            }
    }
        dfs(0, 0);

        if(rs){
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();


    }
}