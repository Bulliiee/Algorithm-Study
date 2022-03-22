package Solved;
// 하노이 탑 이동 순서 11729
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        
        bw.write(Integer.toString(hanoiMove(input)) + "\n");    // 옮긴횟수(버퍼에 담기)
        hanoi(input, 1, 3, 2, sb);     // 수행과정
        bw.write(sb.toString());   // 화면에 뿌리기
        bw.flush();
        bw.close();
    }

    static int hanoiMove(int input) {
        // 재귀 하면 더 느린듯
        // if(input == 0) {
            //     return res += 1;
            // }
            // res += (int)Math.pow(2, input);
            
            // return hanoiMove(input - 1, res);

        int res = 0;
        
        for(int i = 0; i < input; i++) {
            res += Math.pow(2, i);
        }

        return res;
    }

    static void hanoi(int input, int source, int destination, int temp, StringBuilder sb) {
        if(input != 1) {
            hanoi(input - 1, source, temp, destination, sb);
            // sb.append(input + "번 원반을 막대기 " + source + "에서 " + destination + "으로 이동");
            sb.append(source + " " + destination + "\n");
            hanoi(input - 1, temp, destination, source, sb);
        }
        else {
            // sb.append(input + "번 원반을 막대기 " + source + "에서 " + destination + "으로 이동");
            sb.append(source + " " + destination + "\n");
        }
        
    }
}
