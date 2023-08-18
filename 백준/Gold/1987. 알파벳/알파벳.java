import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c;			// 입력 r, c
	static char[][] alpha;		// 알파벳 보드
	static boolean[] isUsed;	// 알파벳 사용 여부
	
	// 움직임 제어 상하좌우
	static int[] moveR = {-1, 1, 0, 0};
	static int[] moveC = {0, 0, -1, 1};
	
	// 결과 최대값
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringTokenizer st = new StringTokenizer(br.readLine());	// 문자열 자르기용
		r = Integer.parseInt(st.nextToken());	// r입력
		c = Integer.parseInt(st.nextToken());	// c입력
		
		// 알파벳 보드 입력받기
		alpha = new char[r][c];	// 알파벳 보드 만들기
		for(int i = 0; i < r; i++) {
			alpha[i] = br.readLine().toCharArray();
		}
		
		isUsed = new boolean[26];
		dfs(0, 0, 1);
		System.out.println(max);
	}
	
	static boolean isOk(int chkR, int chkC) {
		if(0 <= chkR && chkR < r && 0 <= chkC && chkC < c) {
			if(!isUsed[alpha[chkR][chkC] - 'A']) {
				return true;
			}
		}
		return false;
	}
	
	static void dfs(int sr, int sc, int count) {
		
		isUsed[alpha[sr][sc]-'A'] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextR = sr+moveR[i];
			int nextC = sc+moveC[i];
			if(isOk(nextR, nextC)) {
				isUsed[alpha[nextR][nextC]-'A'] = true;
				dfs(nextR, nextC, count+1);
				isUsed[alpha[nextR][nextC]-'A'] = false;
			}
		}
		
		if(max < count) {
			max = count;
		}
	}
	
}
