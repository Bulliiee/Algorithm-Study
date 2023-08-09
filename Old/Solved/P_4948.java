package Solved;
// 베르트랑 공준 4948
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<>();

        int count = 0;
        int i = 0;

        // 입력받기
        while(true) {
            num.add(Integer.parseInt(br.readLine()));
            if(num.get(i) == 0) {
                break;
            }
            i++;
        }

        // 소수판별
        int temp1, temp2;
        for(i = 0; i < num.size() - 1; i++) {
            count = 0;

            temp1 = num.get(i) + 1;
            temp2 = num.get(i) * 2;

            while(temp1 <= temp2) {
                if(isPrime(temp1)) {
                    count++;
                }
                temp1++;
            }
            sb.append(count + "\n");
        }

        System.out.print(sb);

    }

    static boolean isPrime(int num) {
        int temp = (int)Math.sqrt(num);

        for(int i = 2; i <= temp; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
