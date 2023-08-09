package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D2_2001_파리퇴치_이항우.java 
 * 메모리: 19400 KB 
 * 시간: 108 ms
 * 
 * 파리채의 크기만큼 좌표를 기준으로 주변을 탐색한다. for문으로 배열을 각각 탐색하며, 인덱스를 잘 조절한다.
 */
public class D2_2001 {

	static int n, m, maxFly, arr[][];

	static int getFlies() {
		// 2차원 배열 탐색하며 최대 파리 구하기
		// 최대 탐색 인덱스는 n-m까지다.
		for (int i = 0; i <= n-m; i++) {
			for (int j = 0; j <= n-m; j++) {
				int sum = 0;
				for(int k = i; k < i + m; k++) {
					for(int l = j; l < j + m; l++) {
						sum += arr[k][l];
					}
				}
				maxFly = Integer.max(sum, maxFly);
			}
		}
		
		return maxFly;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			maxFly = 0;

			// 배열 입력받기
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#" + tc + " " + getFlies() + "\n");
		}

		System.out.println(sb.toString());
	}

}

/*
2
5 2
1 3 3 6 7
8 13 9 12 8
4 16 11 12 6
2 4 1 23 2
9 13 4 7 3
6 3
29 21 26 9 5 8
21 19 8 0 21 19
9 24 2 11 4 24
19 29 1 0 21 19
10 29 6 18 4 3
29 11 15 3 3 29
*/