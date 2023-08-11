import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {
	static int row, col, rot, arr[][];	// 입력받은것들
	
	// 돌리고 배열에 다시 넣는다.
	static void inputArray(Queue<Integer> queue, int startIdx) {
		// 큐에 넣어놓은거 돌리기
		for(int i = 0; i < rot; i++) {
			queue.offer(queue.poll());
		}
		
		// 배열에 큐 집어넣기
					// 	우 	하	 좌	 상
		int[] moveR = { 0, 	1, 	0, 	-1 	};
		int[] moveC = { 1, 	0, 	-1,	0 	};
		// move배열 사용 방향, 처음에는 오른쪽으로 가면서 배열에 넣음
		int dir = 0;
		// 배열에 담을 최소 인덱스와 최대 인덱스
		int minR = startIdx, minC = startIdx;
		int maxR = row - startIdx, maxC = col - startIdx;
		// 시작하는 인덱스 만들기
		int currR = startIdx, currC = startIdx;

		arr[currR][currC] = queue.poll();	// 시작점 먼저 넣어놓기
		int reps = ((row - (startIdx * 2)) * 2) + ((col - 2 - (startIdx * 2)) * 2); 
		while (reps > 1) { // 큐에 담은 크기 미리 계산해서 그만큼 반복
			int nextR = currR + moveR[dir];
			int nextC = currC + moveC[dir];

			// 범위를 벗어난다면 방향 바꾸기
			if (nextR < minR || nextR >= maxR || nextC < minC || nextC >= maxC) {
				dir++;
				continue;
			}

			// 큐에 넣기
			currR = nextR;
			currC = nextC;
			arr[currR][currC] = queue.poll();
			reps--;
		}
	}
	
	// 파라미터로 받은 startIdx로 큐에 담을 배열의 최소 인덱스와 최대 인덱스를 알 수 있다.
	static void inputQueue(Queue<Integer> queue, int startIdx) {
					//	우	하	좌	상
		int[] moveR = {	0,	1,	0,	-1	};
		int[] moveC = {	1,	0,	-1,	0	};
		// move배열 사용 방향, 처음에는 오른쪽으로 가면서 큐에 넣음
		int dir = 0;		
		// 큐에 담을 배열의 최소 인덱스와 최대 인덱스
		int minR = startIdx, 		minC = startIdx;
		int maxR = row - startIdx, 	maxC = col - startIdx;
		// 시작하는 인덱스 만들기
		int currR = startIdx, 		currC = startIdx;
		
		queue.offer(arr[currR][currC]);	// 시작점 먼저 넣어놓기
		int reps = ((row - (startIdx * 2)) * 2) + ((col - 2 - (startIdx * 2)) * 2); 
		while(reps > 1) {	// 큐에 담은 크기 미리 계산해서 그만큼 반복
			int nextR = currR + moveR[dir];
			int nextC = currC + moveC[dir];
			
			// 범위를 벗어난다면 방향 바꾸기
			if(nextR < minR || nextR >= maxR || nextC < minC || nextC >= maxC) {
				dir++;
				continue;
			}
			
			// 큐에 넣기
			currR = nextR;
			currC = nextC;
			queue.offer(arr[currR][currC]);
			reps--;
		}
	}
	
	static void rotateArray(int rep) {
		Queue<Integer> queue = new ArrayDeque<Integer>();	// 배열을 쫙 펴서 담을 큐

		// 큐에 넣기 시작하는 인덱스는 0,0 / 1,1 / 2,2 ... 인데, 배열 크기 중 짝수인 크기의 절반만큼 반복한다.(파라미터)
		for(int startIdx = 0; startIdx < rep; startIdx++) {
			inputQueue(queue, startIdx);	// 배열 가장자리부터 큐에 넣고
			inputArray(queue, startIdx);	// 그 큐를 돌려서 배열에 다시 집어넣고
			queue.clear();					// 큐 제거 후 반복
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 첫줄 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		rot = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		// 1회전에 있어 큐를 만들어 회전하는 횟수는 배열 크기 중 짝수인 크기의 절반만큼이다.
//		int rep = ((row % 2 == 0) ? row / 2 : col / 2);
		int rep = Integer.min(row, col) / 2;
		
		// 두번째 줄부터 입력
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전시키기
		rotateArray(rep);
		
		// 출력
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}