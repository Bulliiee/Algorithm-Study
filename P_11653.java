import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        factorization(num, 2);
    }

    static void factorization(int num, int divisor) {
        if(num < 2) {
            return ;
        }
        if(num % divisor == 0) {
            System.out.println(divisor);
            factorization(num / divisor, 2);
        }
        else {
            factorization(num, divisor + 1);
        }
    }
    
}
