package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre>
 * BJ_2606_바이러스_이항우.java
 * https://www.acmicpc.net/problem/2606
 * 메모리: 	14216 KB
 * 시간:		120 ms
 * 
 * 여러 컴퓨터가 네트워크를 통해 연결되어있고, 이 바이러스가 네트워크를 통해 전파된다.
 * 한 컴퓨터가 걸리면 연결된 모든 컴퓨터가 바이러스에 걸린다.
 * 즉, 컴퓨터가 정점, 네트워크가 간선이라고 했을 때, 무방향 그래프로 볼 수 있고
 * 바이러스에 걸린 컴퓨터를 시작 정점(1번 컴퓨터)으로 그래프 탐색을 하면서
 * 탐색한 그래프의 수를 체크하면 정답을 구할 수 있다.
 * </pre>
 * 
 * @author 이항우
 *
 */
public class P_2606 {
	static final int MAX = 101;	// 1번 정점부터 사용
	
	static boolean[][] computers = new boolean[MAX][MAX];	// [시작 컴퓨터 번호][연결된 컴퓨터 번호]
	static boolean[] visited = new boolean[MAX];			// 방문 여부 확인용
	static int computerNum;	// 컴퓨터 갯수
	static int edgeNum;		// 네트워크상에서 연결된 컴퓨터쌍 수
	static int count;		// 바이러스에 감염된 컴퓨터 갯수 카운트
	
	static void dfs(int computer) {		// dfs 재귀를 사용한다. 파라미터는 현재 탐색할 컴퓨터 번호
		visited[computer] = true;		// 먼저 방문 표시를 한 후
		count++;						// 방문했으니 감염된 컴퓨터 갯수를 증가시킨다.
		
		for(int i = 1; i <= computerNum; i++) {			// 1번 컴퓨터부터 마지막 컴퓨터까지 반복한다
			if(computers[computer][i] && !visited[i]) {	// 현재 컴퓨터와 연결된 컴퓨터가 방문하지 않은 컴퓨터라면
				dfs(i);									// 해당 컴퓨터 번호로 재귀 호출
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringTokenizer st;	// 입력 문자열 자르기
		
		computerNum = Integer.parseInt(br.readLine());	// 컴퓨터 갯수
		edgeNum = Integer.parseInt(br.readLine());		// 연결된 네트워크 갯수(연결된 컴퓨터쌍 수)
		
		for(int i = 1; i <= edgeNum; i++) {					// 연결 상태 입력
			st = new StringTokenizer(br.readLine());		// 한줄 입력받기
			int src = Integer.parseInt(st.nextToken());		// 출발 컴퓨터 
			int dest = Integer.parseInt(st.nextToken());	// 도착 컴퓨터
			
			computers[src][dest] = computers[dest][src] = true;	// 무방향 그래프 형태이므로 출발 도착점 양방향 연결
		}

		dfs(1);	// 바이러스에 처음 걸린 컴퓨터가 1이므로 파라미터로 1을 넘겨줌
		
		System.out.print(count - 1);	// 1번 컴퓨터(시작 컴퓨터)는 제외해야하므로 -1
	}

}