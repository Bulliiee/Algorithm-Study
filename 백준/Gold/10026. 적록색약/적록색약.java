import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int N;
	static char[][] paint;
	
	static boolean[][] visited;
	static int startR, startC;
	static int jeoklock, noJeoklock;
	
	static int[] moveR = {-1, 1, 0, 0};
	static int[] moveC = {0, 0, -1, 1};
	
	static boolean isOk(int[] points) {
		if(0 <= points[0] && points[0] < N && 0 <= points[1] && points[1] < N && !visited[points[0]][points[1]]) {
			return true;
		}
		return false;
	}
	
	static void getRGBCount(boolean isJeoklock, char startColor) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		q.offer(new int[] {startR, startC});
		
		if(isJeoklock) {	// 적록색약인 경우
			while(!q.isEmpty()) {
				int[] currPoint = q.poll();
				visited[currPoint[0]][currPoint[1]] = true;

				for(int i = 0; i < 4; i++) {
					int[] nextPoint = {currPoint[0]+moveR[i], currPoint[1]+moveC[i]};
					if(isOk(nextPoint)) {
						if(startColor == 'R' || startColor == 'G') {
							if(paint[nextPoint[0]][nextPoint[1]] == 'R' || paint[nextPoint[0]][nextPoint[1]] == 'G') {
								q.offer(nextPoint);
								visited[nextPoint[0]][nextPoint[1]] = true;
							}
						}
						else if(paint[nextPoint[0]][nextPoint[1]] == 'B') {
							q.offer(nextPoint);
							visited[nextPoint[0]][nextPoint[1]] = true;
						}
					}
				}
			}
			jeoklock++;
		}
		else {	// 아닌 경우
			while(!q.isEmpty()) {
				int[] currPoint = q.poll();
				visited[currPoint[0]][currPoint[1]] = true;

				for(int i = 0; i < 4; i++) {
					int[] nextPoint = {currPoint[0]+moveR[i], currPoint[1]+moveC[i]};
					
					if(isOk(nextPoint) && paint[nextPoint[0]][nextPoint[1]] == startColor) {
						q.offer(nextPoint);
						visited[nextPoint[0]][nextPoint[1]] = true;
					}
				}
			}
			noJeoklock++;
		}
	}
	
	static char getStartPoint() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					startR = i;
					startC = j;
					return paint[startR][startC];
				}
			}
		}
		
		return 'F';
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		paint = new char[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String ln = br.readLine();
			paint[i] = ln.toCharArray();
		}
		
		// 적록색약 아닌 사람이 보는 그림
		while(true) {
			char startColor = getStartPoint();
			if(startColor == 'F') {
				break;
			}
			getRGBCount(false, startColor);
		}
		visited = new boolean[N][N];
		startR = startC = 0;
		// 적록색약이 보는 그림
		while(true) {
			char startColor = getStartPoint();
			if(startColor == 'F') {
				break;
			}
			getRGBCount(true, startColor);
		}
		
		System.out.println(noJeoklock + " " + jeoklock);
	}

}
