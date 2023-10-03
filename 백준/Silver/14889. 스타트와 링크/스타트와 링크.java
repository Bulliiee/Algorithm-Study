import java.util.*;
import java.io.*;

/**
 * 두 팀의 시너지를 계산해서 두 팀간의 최소 차이가 되게 만들었을 때의 차이가 답으로 나와야 한다.
 * 조합을 사용해서 팀을 2개로 나눈다.
 * 	- 20C10인데다가, 아래 예시처럼 절반만(nCr의 절반) 해도 되기 때문에 2초 안에 가능하다.
 * 	- 예시: 6명 팀인 경우, 스타트팀에 0, 1, 2번이 들어간 경우와 3, 4, 5번이 들어간 경우는 팀 능력치 차이가 똑같다.
 * 나눈 팀의 능력치를 주어진 시너지 표에 따라 구해서 최소값을 갱신해간다.
 */
public class Main {

	static int N;			// 입력받을 사람 수
	static int[][] synergy;	// 시너지 표
	
	static boolean[] isUsed;	// start팀 만들 떄 사용한 사람 번호 체크용
	static int[] startTeam;		// start팀 선수들 번호
	static int[] linkTeam;		// link팀 선수들 번호
	static int endCount;		// 위의 설명처럼 절반만 하기 위함
	static long end = 1;		// endCount 조절용
	
	static int min = Integer.MAX_VALUE;	// 결과값(능력치 차이 최소값)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/// 입력받기
		N = Integer.parseInt(br.readLine());
		synergy = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				synergy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// nCr의 절반 구하기
		for(int i = N; i > N/2; i--) {
			end *= i;
		}
		for(int i = N/2; i > 0; i--) {
			end /= i;
		}
		end /= 2;
		
		// 조합 만들 때 필요한 애들 만들기
		isUsed = new boolean[N];
		startTeam = new int[N/2];
		linkTeam = new int[N/2];
		// 조합 만들기(start팀 만들기
		comb(0, 0);
		
		System.out.print(min);
	}

	static void comb(int cnt, int start) {
		// 기저조건: start팀 완성
		if(cnt == N/2) {
			// link팀 구하기
			int idx = 0;
			for(int i = 0; i < N; i++) {
				if(!isUsed[i]) {
					linkTeam[idx++] = i;
				}
			}
			
			// start, link팀 능력치 구하기
			int startAbil = 0;
			int linkAbil = 0;
			for(int i = 0; i < N/2-1; i++) {
				for(int j = i+1; j < N/2; j++) {
					// start팀 능력치 구하기
					startAbil += synergy[startTeam[i]][startTeam[j]];
					startAbil += synergy[startTeam[j]][startTeam[i]];
					// link팀 능력치 구하기
					linkAbil += synergy[linkTeam[i]][linkTeam[j]];
					linkAbil += synergy[linkTeam[j]][linkTeam[i]];
				}
			}
			
			// 능력치 차이 구해서 최소값 갱신
			int temp = Math.abs(startAbil - linkAbil);
			if(min > temp) {
				min = temp;
			}
			
			endCount++;
			return;
		}
		
		// 조합으로 start팀 만들기
		for(int i = start; i < N; i++) {
			// nCr의 절반만큼만 조합 만들어도 됨
			if(endCount == end) {
				break;
			}
			startTeam[cnt] = i;
			isUsed[i] = true;
			comb(cnt+1, i+1);
			isUsed[i] = false;
		}
	}
	
}