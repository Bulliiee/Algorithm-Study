
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> {
			if(Math.abs(n1) == Math.abs(n2)) {
				return n1 - n2;
			}
			return Math.abs(n1) - Math.abs(n2);
		});
		for(int rep = 0; rep < N; rep++) {
			int input = Integer.parseInt(br.readLine());	// 연산 입력
			if(input == 0) {	// 0인 경우: 절댓값이 가장 작은 값 출력 후 그 값 제거
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(pq.poll() + "\n");
				}
			} else {			// 0이 아닌 경우: 값을 절댓값 힙에 넣기
				pq.offer(input);
			}
		}
		System.out.print(sb.toString());
	}
	
}
