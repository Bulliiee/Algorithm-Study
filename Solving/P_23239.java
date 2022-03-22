package Solving;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_23239 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int []input = new int[3];   // [0]: width, [1]: height, [2]: length
        int carrot = 0;
        
        String s;
        
        s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        for(int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 2, 3, 4분면(length 길이만큼 그대로)
        carrot += getCarrots(input[2], input[2]) * 3;
        carrot += input[2] * 2;

        // 길이가 마구간보다 큰 경우 마구간 오른쪽부분과 윗부분
        int remainLength = input[2] - input[0];

        for(int i = 0; i < 2; i++) {
            remainLength = input[2] - input[i];
            if(remainLength > 0) {
                carrot += getCarrots(remainLength, remainLength);
                carrot += remainLength;
            }
        }

        System.out.println(carrot);

        return ;
    }

    // 사분원 경계선을 제외한 안쪽의 당근 수만 구하기
    static int getCarrots(int length, int rep) {
        int carrot = 0;
        int y = length - 1;

        for(int x = 1; x < rep; x++) {
            if(Math.pow(y, 2) + Math.pow(x, 2) > Math.pow(length, 2)) {
                y--;
                x--;
            }
            else {
                carrot += y;
            }
        }

        return carrot;
    }
}