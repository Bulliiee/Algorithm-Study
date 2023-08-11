package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * D3_2805_농작물수확하기_이항우.java
 * 메모리: 20156 KB
 * 시간: 116 ms
 * 
 * 각 행별로 열의 시작 인덱스와 반복 횟수를 적고, 규칙을 찾아서 구현한다.
 * 
 * @author 이항우
 *
 */
public class D3_2805 {
	
	static int harvesting(int[][] farm, int size) {
		int center = size / 2;	// 가운데 사이즈
		
		int res = 0;	// 리턴할 결과 저장용
		
		for(int i = 0; i < size; i++) {	// 각 행을 탐색하며
			// 열을 구하는데, 3행을 기준으로 2, 4행, 1, 5행, 1, 6행은 모두 6의 보수이다.
			// 계산 하면 j는 3, 2, 1, 0, 1, 2, 3이 반복된다.
			for(int j = center - Math.min((size - i - 1), i); j <= center + Math.min((size - i - 1), i); j++) {
				res += farm[i][j];
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int size = Integer.parseInt(br.readLine());
			int[][] farm = new int[size][size];
			
			for(int i = 0; i < size; i++) {
				String temp = br.readLine();
				for(int j = 0; j < size; j++) {
					farm[i][j] = temp.charAt(j) - '0';
				}
			}
			
			sb.append("#" + tc + " " + harvesting(farm, size) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}