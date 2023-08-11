package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * D3_1225_SW문제해결기본7일차_암호생성기_이항우.java 
 * 메모리: 21416 KB 
 * 시간: 124 ms
 * 
 * 암호 생성하는 규칙 자체가 큐 쓰라고 대놓고 하는것같다. 그래서 큐를 사용하기로 한다.
 * 
 * @author 이항우
 *
 */
public class D3_1225 {

	static String makePw(Queue<Integer> queue) {
		StringBuilder sb = new StringBuilder();	// 문자열 만들기용
		
		int temp = 1;	// 반복문 컨트롤용
		while(temp > 0) {	// 꺼낸 수가 0 이하가 되면 멈추게 한다.
			// 5회 반복
			for (int i = 1; i <= 5; i++) {
				temp = queue.poll() - i;	// 꺼낸 수 - 반복횟수
				if (temp <= 0) {	// 이 temp가 0 이하면 0을 넣고 멈춘다.
					queue.offer(0);
					break;
				}
				queue.offer(temp);	// 0 초과면 해당 값을 그냥 큐 뒤로 넣는다.
			}
		}
		
		// 큐에 들어있는 숫자들을 형식에 맞게 문자열로 만든다
		while(!queue.isEmpty()) {
			sb.append(queue.poll() + " ");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();	// 문자열 만들기용
		StringTokenizer st;	// 문자열 자르기용

		int rep = 10;	// 반복 횟수 10회 지정
		while (rep-- > 0) {
			String r = br.readLine();	// 한 줄 입력받기(8개의 숫자)

			Queue<Integer> queue = new ArrayDeque<Integer>(); // 계산용 큐
			st = new StringTokenizer(br.readLine()); // 한 줄 입력받기
			for (int i = 0; i < 8; i++) { // 입력받은 숫자 큐에 넣기
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			sb.append("#" + r + " " + makePw(queue) + "\n");	// 문자열 만들기 + 암호 만드는 메서드 호출
		}

		System.out.println(sb.toString());	// 출력
	}

}
