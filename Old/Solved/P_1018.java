package Solved;
// 체스판 다시 칠하기 1018
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputHeight = Integer.parseInt(st.nextToken());
        int inputWidth = Integer.parseInt(st.nextToken());

        char [][]chess = new char[inputHeight][inputWidth];
        for(int i = 0; i < inputHeight; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        // 체스판 차례로 체크
        int count = 2500;
        int temp;
        for(int i = 0; i < inputHeight - 7; i++) {
            for(int j = 0; j < inputWidth - 7; j++) {
                temp = checkChessTable(chess, j, i, 'W');
                if(temp < count) {
                    count = temp;
                }

                temp = checkChessTable(chess, j, i, 'B');
                if(temp < count) {
                    count = temp;
                }
            }
        }
        System.out.println(count);
    }

    static int checkChessTable(char [][] chess, int startWid, int startHei, char startChar) {
        int count = 0;

        // chess2차원배열 깊은복사
        char[][] tempChess = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            System.arraycopy(chess[i], 0, tempChess[i], 0, tempChess[i].length);
        }

        // 시작문자
        if(tempChess[startHei][startWid] != startChar) {
            tempChess[startHei][startWid] = startChar;
            count++;
        }
        
        // 체스판 체크 후 수정, 카운트 측정
        for(int i = startHei; i < startHei + 7; i++) {
            for(int j = startWid; j < startWid + 7; j++) {
                if(tempChess[i][j] == tempChess[i][j + 1]) {
                    tempChess[i][j + 1] = tempChess[i][j + 1] == 'W' ? 'B' : 'W';
                        count++;
                }
                if(tempChess[i][j] == tempChess[i + 1][j]) {
                    tempChess[i + 1][j] = tempChess[i + 1][j] == 'W' ? 'B' : 'W';
                        count++;
                }
            }
        }

        // 마지막칸
        if(tempChess[startHei + 7][startWid + 6] == tempChess[startHei + 7][startWid +7]) {
            tempChess[startHei + 7][startWid + 7] = 
            tempChess[startHei + 7][startWid + 7] == 'W' ? 'B' : 'W';
            count++;
        }

        return count;
    }
}
