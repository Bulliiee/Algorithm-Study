package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BJ_1158_요세푸스문제_이항우.java
 * 메모리: 294156 KB
 * 시간: 500 ms
 * 
 * 큐에서 규칙에 따라 빼는데, K에 도달하면 뒤로 안붙인다
 * 
 * @author 이항우
 *
 */
public class BJ_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 N, K
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1 ~ N까지 담을 큐
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 1; i <= N; i++) {	// 초기에 1 ~ N까지 담아준다.
			queue.offer(i);
		}
		
		int[] result = new int[N];	// 결과 담을 배열
		int resIdx = 0;	// result 저장용 인덱스
		int count = 0;	// K 도달 여부 확인 카운트
		while(!queue.isEmpty()) {	// 큐에 값이 있는동안은 계속 연산
			int temp = queue.poll();
			count++;
			
			if(count != K) {
				queue.offer(temp);
			} else {	// 카운트 도달시 결과 배열에 넣기
				result[resIdx++] = temp;
				count = 0;
			}
		}
		
		// 결과 출력
		sb.append("<");
		for(int i = 0; i < N-1; i++) {
			sb.append(result[i] + ", ");
		}
		sb.append(result[N-1] + ">");
		
		System.out.print(sb.toString());
	}

}
