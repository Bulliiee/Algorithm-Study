package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D3_9229_한빈이와SpotMart_이항우.java
 * 메모리: 32656 KB
 * 시간: 469 ms
 * 
 * 앞에서부터 차례대로 비교하며 최대로 들 수 있는 무게를 찾는다.
 * 
 * @author 이항우
 *
 */
public class D3_9229 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// 테케 갯수 입력
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());	// 한 줄 입력
			int snackNum = Integer.parseInt(st.nextToken());	// 과자 갯수
			int maxWeight = Integer.parseInt(st.nextToken());	// 최대 무게
			
			Integer[] snacks = new Integer[snackNum];	// Comparator 사용 위해 Integer
			// 과자 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < snackNum; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
				
			int sum = 0;		// 현재 sum
			int result = -1;	// 결과
			for(int i = 0; i < snackNum - 1; i++) {
				for(int j = i+1; j < snackNum; j++) {
					sum = snacks[i] + snacks[j];
					if(sum <= maxWeight) {
						result = Integer.max(result, sum);
					}
				}
			}
			
			// 출력
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.print(sb.toString());
	}
	
}
