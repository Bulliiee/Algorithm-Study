package live;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 마지막마이쮸누가가져갈까_이항우.java
 * 마이쮸 규칙에 따라서  계산한다.
 * 사람은 큐에 넣고, 마이쮸 받은 갯수는  따로 배열에 저장한다.
 * @author SSAFY
 *
 */
public class MyChew {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<Integer>();	// 사람 번호를 담을 큐
		int[] myChewAmount = new int[20];	// 인덱스는 사람 번호, 값은 그 사람이 받은 마이쮸 갯수
		
		int myChew = 20;	// 마이쮸 총 갯수
		queue.offer(1);		// 1번 줄 서는걸로 시작
		
		int people = 2;		// 다음 받을 사람 번호 초기화
		int receiver = 0;	//  다음에 마이쮸 받을 사람 번호
		while(myChew > 0) {	// 마이쮸 동날때까지 반복
			receiver = queue.poll();
			
			// 줄에서 다음에 마이쮸 받을 사람 번호를 받아서 마이쮸 받은 갯수 증가시키고 총 갯수에서 빼기
			myChew -= (myChewAmount[receiver]++);
			
			// 받은 사람 줄 세우고 새로운 사람 줄 세우기
			queue.offer(receiver);
			queue.offer(people++);
		}
		
		// 결과 출력
		System.out.println(receiver);
	}
	
}
