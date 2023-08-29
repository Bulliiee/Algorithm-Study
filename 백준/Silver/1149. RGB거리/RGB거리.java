import java.io.*;
import java.util.*;

/**
 * 빨강일 때, 이전의 파랑, 초록의 최소값을 더하고
 * 파랑일 때, 이전의 빨강, 초록의 최소값을 더하고
 * 초록일 때, 이전의 빨강, 파랑의 최소값을 더한다.
 * 그래서 
 * dp[N][빨강] = min(dp[N-1][파랑], dp[N-1][초록])
 * dp[N][파랑] = min(dp[N-1][빨강], dp[N-1][초록])
 * dp[N][초록] = min(dp[N-1][빨강], dp[N-1][파랑])
 * 이 된다.
 * 여기서 dp[N]에 대한 빨강, 파랑, 초록 중 가장 작은 값이 문제에서 원하는 답이 된다.
 */
public class Main {

	static int N;	// 입력 N
	static int[][] dp;	// [N개][빨,파,초]
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringTokenizer st;	// 문자열 자르기
		
		N = Integer.parseInt(br.readLine());	// N입력
		dp = new int[N][3];	// 입력받아서 저장할 배열 만들기
		// 각 집의 비용 입력받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		// 각 집에 대해 가장 위에서 설명한 연산 하기
		for(int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
		}

		// 원하는 N번째 집을 칠했을 때의 최소비용 구하기
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(dp[N-1][2], min);
		
		// 최소비용 출력
		System.out.println(min);
	}
	
}