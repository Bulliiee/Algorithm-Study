import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int H, W, commandNum;		// 맵 높이, 너비, 명령어 갯수
	static char map[][], command[];		// 맵, 명령어
	
	static Tank tank;	// 탱크 정보
	static char[] tankDirView = {'^', 'v', '<', '>'};
	static int[] moveR = {-1, 1, 0, 0};
	static int[] moveC = {0, 0, -1, 1};
	
	static class Tank {
		// dir => 0: 상, 1: 하, 2: 좌, 3: 우
		int r, c, dir;
		public Tank(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());		// 테케 입력
		for(int tc = 1; tc <= T; tc++) {				// 테케만큼 반복
			st = new StringTokenizer(br.readLine());	// 한 줄 입력
			H = Integer.parseInt(st.nextToken());		// 맵 높이	
			W = Integer.parseInt(st.nextToken());		// 맵 너비
			
			// 맵 입력받기
			map = new char[H][W];						// 맵 만들기
			for(int r = 0; r < H; r++) {	
				String ln = br.readLine();
				for(int c = 0; c < W; c++) {
					char temp = ln.charAt(c);
					map[r][c] = temp;					// 맵에 값 넣고
					makeInitTank(r, c, temp);				// 탱크 초기 위치 확인
				}
			}
			
			// 명령어 입력받기
			commandNum = Integer.parseInt(br.readLine());
			command = new char[commandNum];
			command = br.readLine().toCharArray();
			
			// 명령어 수행하기
			performCommand();
			
			// 출력하기
			sb.append("#" + tc + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}
	
	// 명령어 수행
	static void performCommand() {
		// 명령어 횟수만큼 반복
		for(int rep = 0; rep < commandNum; rep++) {
			switch(command[rep]) {
			case 'U':
				move(0);
				break;
			case 'D':
				move(1);
				break;
			case 'L':
				move(2);
				break;
			case 'R':
				move(3);
				break;
			case 'S':
				shoot();
				break;
			}
		}
	}
	
	static void shoot() {
		int nextR = tank.r + moveR[tank.dir];
		int nextC = tank.c + moveC[tank.dir];
		
		// 탱크가 쏜 방향으로 날림
		while(mapCheck(nextR, nextC) > 0) {
			// 벽돌벽이면 평지로 바꿈
			if(map[nextR][nextC] == '*') {
				map[nextR][nextC] = '.';
				break;
			}
			
			nextR = nextR + moveR[tank.dir];
			nextC = nextC + moveC[tank.dir];
		}
		
	}
	
	static void move(int inputDir) {
		
		// 바라보는 방향 바꾸고
		tank.dir = inputDir;	
		map[tank.r][tank.c] = tankDirView[inputDir];

		// 다음 예정 좌표
		int nextR = tank.r + moveR[inputDir];
		int nextC = tank.c + moveC[inputDir];
		

		// 갈 수 있는지 확인 후 되면 움직임
		if(mapCheck(nextR, nextC) == 3) {
			// 보고있는 방향 틀기
			char temp = map[tank.r][tank.c];
			map[tank.r][tank.c] = '.';
			map[nextR][nextC] = temp;
			
			// 움직이기
			tank.r = nextR;
			tank.c = nextC;
		}
	}
	
	// -1: 해당 좌표는 바운더리를 벗어나거나 물임, 0: 강철벽, 1: 벽돌벽, 2: 물, 3: 아무것도 없음
	static int mapCheck(int r, int c) {
		if(r < 0 || r >= H || c < 0 || c >= W) {
			return -1;
		}
		else if(map[r][c] == '#') {
			return 0;
		}
		else if(map[r][c] == '*') {
			return 1;
		}
		else if(map[r][c] == '-') {
			return 2;
		}
		return 3;
	}
	
	// 탱크 만들기
	static void makeInitTank(int r, int c, char dir) {
		for(int i = 0; i < 4; i++) {
			if(dir == tankDirView[i]) {
				tank = new Tank(r, c, i);
			}
		}
	}

}