import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재료 클래스
class Jaeryo {
	int score;
	int calorie;
	
	public Jaeryo(int score, int calorie) {
		this.score = score;
		this.calorie = calorie;
	}
}

public class Solution {
	
	static int jaeryoNum;		// 재료 갯수
	static int maxCalorie;		// 최대 칼로리
	static Jaeryo[] jaeryos;	// 재료 담을 재료배열
	
	static int getMaxHamburgerScore() {
		int max = 0;	// 재료 부분집합 점수 합의 최대값
		
		for(int i = 1; i < (1<<jaeryoNum); i++) {
			int sum = 0;	// 현재 재료들 부분집합의 점수 합
			int cal = 0;	// 현재 재료들 부분집합의 칼로리 합
			
			for(int j = 0; j < jaeryoNum; j++) {
				if((i & (1<<j)) != 0) {
					sum += jaeryos[j].score;
					cal += jaeryos[j].calorie;
				}
			}
			
			if(cal <= maxCalorie && max < sum) {
				max = sum;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			jaeryoNum = Integer.parseInt(st.nextToken());
			maxCalorie = Integer.parseInt(st.nextToken());	// 최대 칼로리
			jaeryos = new Jaeryo[jaeryoNum];	// 재료 갯수만큼 배열 만들기
			
			// 재료들 입력받아서 배열에 넣기
			for(int i = 0; i < jaeryoNum; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				jaeryos[i] = new Jaeryo(score, calorie);
			}
			
			sb.append("#" + tc + " " + getMaxHamburgerScore() + "\n");
		}

		System.out.print(sb.toString());
	}

}
