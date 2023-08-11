package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * BJ_11286_절댓값힙_이항우.java
 * 메모리: 26480 KB
 * 시간: 388 ms
 * 
 * 최소힙을 절댓값으로 계산해서 만든다.
 * 절댓값이 같다면 기존 값 중 더 작은 값이 작은것이 되도록 한다.
 * PriorityQueue를 사용해 조건에 맞게 정렬되어 들어가도록 한다.
 * 큐를 만들 때 위의 비교조건을 람다식으로 넣는다.
 * 
 * @author 이항우
 *
 */
public class BJ_11286 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();	// 출력용
		
		int N = Integer.parseInt(br.readLine());	// 명령어 갯수 입력
		// 우선순위 큐 만들기. 정렬 조건은 람다식으로 줄인다.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> {
			if(Math.abs(n1) == Math.abs(n2)) {
				return n1 - n2;
			}
			return Math.abs(n1) - Math.abs(n2);
		});
		
		// 명령어 입력 수만큼 반복
		for(int rep = 0; rep < N; rep++) {
			int input = Integer.parseInt(br.readLine());	// 연산 입력
			if(input == 0) {	// 0인 경우: 절댓값이 가장 작은 값 출력 후 그 값 제거
				if(pq.isEmpty()) {	// 큐가 비어있으면 0
					sb.append(0 + "\n");
				}
				else {	// 아니면 해당 값 꺼내기
					sb.append(pq.poll() + "\n");
				}
			} else {			// 0이 아닌 경우: 값을 절댓값 힙에 넣기
				pq.offer(input);
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
	
}
