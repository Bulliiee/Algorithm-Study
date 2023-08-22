import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();	// 출력 문자열 만들기
		StringTokenizer st;	// 문자열 자르기
		
		int T = Integer.parseInt(br.readLine());	// 테케 수 입력
		for(int tc = 1; tc <= T; tc++) {
			// N과 M 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 출력 문자열 만들기
			sb.append("#").append(tc).append(" ");

			// 숫자 N+1개 배열 만들기 => 부모 인덱스를 가리킴, 1~N까지 사용
			parents = new int[N+1];
			// 해당 인덱스의 부모는 자기 자신이 되도록 함
			for(int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			// M번 반복해서 명령어 입력받기
			for(int i = 0; i < M; i++) {
				// 명령어 3개 한줄로 입력
				st = new StringTokenizer(br.readLine());
				int[] com = new int[3];
				for(int j = 0; j < 3; j++) {
					com[j] = Integer.parseInt(st.nextToken());
				}
				
				// 명령어 종류에 따라 연산
				if(com[0] == 0) {	// 0: 합집합
					union(com[1], com[2]);
				}
				else if(com[0] == 1) {	// 1: 두 원소가 같은 집합인지 확인
					sb.append(isSameSet(com[1], com[2]));
				}
			}
			
			sb.append("\n");
		}
		
		// 출력
		System.out.print(sb.toString());
	}
	
	// 대표자 찾기
	static int findSet(int num) {
		// 파라미터로 받은 값의 부모가 자기 자신이라면 얘가 루트(대표자)
		if(parents[num] == num) {
			return num;
		}
		
		// path compression을 적용한다.
		// 탐색하며 지나는 경로의 모든 노드들은 최상단 부모를 가리키게 한다.
		return parents[num] = findSet(parents[num]);
	}

	// 두 원소를 포함한 집합 합치기
	static void union(int num1, int num2) {
		// 입력된 두 값의 대표자가 같지 않을 때만 합치기를 한다.
		if(isSameSet(num1, num2) == 0) {
			parents[findSet(num2)] = findSet(num1);
		}
	}
	
	
	// 같은 집합에 속해있다면 1, 아니면 0 리턴
	static int isSameSet(int num1, int num2) {
		if(findSet(num1) == findSet(num2)) {
			return 1;
		}
		return 0;
	}

}
