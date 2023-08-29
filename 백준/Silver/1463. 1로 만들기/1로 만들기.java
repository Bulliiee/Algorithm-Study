import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(getCount(N));
	}
	
	static int getCount(int N) {
		int[] dp;

		dp = new int[N+1];
		dp[1] = 0;

		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;

			if(i % 3 == 0) {	// 3으로 나누어 떨어지는 경우
				min = dp[i/3] + 1;
			}
			if(i % 2 == 0) {	// 2로 나누어 떨어지는 경우
				min = Math.min(dp[i/2]+1, min);
			}
			// -1
			min = Math.min(dp[i-1] + 1, min);
			
			dp[i] = min;
		}
		
		return dp[N];
	}
	
}
