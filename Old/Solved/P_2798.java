package Solved;
// 블랙잭 2798
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int cardAmount, maxNum;
        int []cards;
        int res = 0;
        int temp = 0;
        
        st = new StringTokenizer(br.readLine());
        cardAmount = Integer.parseInt(st.nextToken());
        maxNum = Integer.parseInt(st.nextToken());

        cards = new int[cardAmount];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cardAmount; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < cardAmount; i++) {
            for(int j = i + 1; j < cardAmount; j++) {
                for(int k = j + 1; k < cardAmount; k++) {
                    temp = cards[i] + cards[j] + cards[k];
                    if(res < temp && temp <= maxNum) {
                        res = temp;
                    }
                }
            }
        }

        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
