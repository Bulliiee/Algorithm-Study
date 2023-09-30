import java.util.*;
import java.io.*;

/**
 * 덱을 사용해서 머리를 늘리고, 꼬리를 줄이는 식으로 구현을 열심히 한다.
 *
 */
public class Main {

	static int boardSize;	// 보드 크기
	static int appleNum, rotNum;	// 사과 갯수, 방향 전환 정보 수
	static List<int[]> applePos = new ArrayList<int[]>();	// 사과 좌표
	static List<Info> rotInfo = new ArrayList<Info>();	// 방향 전환 정보
	
	static Deque<int[]> snake = new ArrayDeque<int[]>();	// 뱀 덱
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int dir = 1;	// 0: 상, 1: 우, 2: 하, 3: 좌

	// 방향 전환 정보
	static class Info {
		int sec;
		char dir;
		Info(int sec, char dir) { 
			this.sec = sec;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력받기
		boardSize = Integer.parseInt(br.readLine());
		appleNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < appleNum; i++) {
			st = new StringTokenizer(br.readLine());
			int tr = Integer.parseInt(st.nextToken());
			int tc = Integer.parseInt(st.nextToken());
			applePos.add(new int[] {tr, tc});	// 사과 좌표
		}
		rotNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < rotNum; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			rotInfo.add(new Info(sec, dir));	// 방향 전환 정보
		}

		// 시작점 머리
		snake.offer(new int[] {1, 1});
		// 타이머
		int timer = 0;
		// 게임 종료 체크 플래그
		boolean isGameOver = false;
		while(true) {
//			System.out.println("====");
			timer++;
			// 현재 머리 좌표(아직 움직이지 않은 경우임)
			int[] head = {snake.peekFirst()[0], snake.peekFirst()[1]};
			
			// 머리를 알맞은 방향으로 한 칸 움직일 예정인 좌표
			head[0] += dr[dir];
			head[1] += dc[dir];
			

			// 예정인 좌표가 범위 벗어난 경우
			if (head[0] <= 0 || head[0] > boardSize || head[1] <= 0 || head[1] > boardSize) {
//				System.out.println("chk1");
				isGameOver = true;
			}
			// 몸통에 닿은 경우
			for(int[] body : snake) {
				if(head[0] == body[0] && head[1] == body[1]) {
//					System.out.println("chk2");
					isGameOver = true;
					break;
				}
			}

			// 뱀한테 적용해줌
			snake.offerFirst(head);
			
			// 좌표 벗어나거나 몸통에 닿은 경우
			if(isGameOver) {
				break;
			}
			
			
			// 늘어난 머리 좌표가 사과를 먹지 않은 경우 꼬리 하나 없애기
			if(!isEatApple(head)) {
				snake.pollLast();
			}
			
			// 방향 전환할 시간이 된 경우
			for (int i = 0; i < rotInfo.size(); i++) {
				if (rotInfo.get(i).sec == timer) {
					// 방향 설정
					char temp = rotInfo.get(i).dir;
					if (temp == 'L') {
						dir += 3;
					} else {
						dir++;
					}
					dir %= 4;
//					System.out.println("dir: " + dir);
					rotInfo.remove(i);
					break;
				}
			}

//			System.out.println("timer: " + timer);
//			for(int[] temp : snake) {
//				System.out.println(temp[0] + ", " + temp[1]);
//			}
			
			
			
		}
		
		System.out.println(timer);
	}

	static boolean isEatApple(int[] head) {
		// 사과 먹은 경우
		for (int i = 0; i < applePos.size(); i++) {
			int[] apple = applePos.get(i);
			if (head[0] == apple[0] && head[1] == apple[1]) {
				applePos.remove(i);
				return true;
			}
		}
		
		return false;
	}
}