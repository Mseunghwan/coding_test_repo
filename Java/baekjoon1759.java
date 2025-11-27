import java.util.*;
import java.io.*;


public class baekjoon1759 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int L;
    static int C;
    static char[] list;


    static boolean isValid(char[] rs){
        int cnt_1 = 0;
        int cnt_2 = 0;
        for (char c : rs) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt_1++;
            } else {
                cnt_2++;
            }
        }
        return cnt_1 >= 1 && cnt_2 >= 2;
    }
    static void DFS(char[] rs, int start, int depth) throws IOException{
        if(depth == L){
            if(isValid(rs)){
                for(int i = 0 ; i < L; i++){
                    bw.write(String.valueOf(rs[i]));
                }
                bw.write("\n");
            }
            return;
            
        }

        for(int i = start; i < C; i++){
            rs[depth] = list[i];
            DFS(rs, i + 1, depth + 1);
        }

    }
    public static void main(String args[]) throws IOException{

        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C; i++){
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);
        char[] rs = new char[L];
        DFS(rs, 0, 0);

        
        bw.flush();
        bw.close();
        br.close();

    }
    
}
