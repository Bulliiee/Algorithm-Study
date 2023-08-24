import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 */
public class Solution {
	
	static int dataNum, start;		// 데이터 수, 시작하는 사람 번호
	static int[][] contactNetwork;	// 연락망 인접행렬
	
	// 탐색한 사람들 깊이, 번호 정렬해서 저장할 우선순위 큐
	static PriorityQueue<People> pq = new PriorityQueue<People>(new Comparator<People>() {
		// 람다, 깊이 내림차순, 깊이 같다면 번호 내림차순
		@Override
		public int compare(People p1, People p2) {
			int res = Integer.compare(p2.depth, p1.depth);	// 먼저 깊이로 내림차순
			if(res == 0) {
				return Integer.compare(p2.peopleNum, p1.peopleNum);	// 깊이가 같다면 큰 번호 기준 내림차순
			}
			return res;
		}
	});
	
	static class People {
		int depth;			// 해당 사람의 깊이
		int peopleNum;		// 사람 번호
		public People(int depth, int peopleNum) {
			this.depth = depth;
			this.peopleNum = peopleNum;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();	// 출력용 문자열 만들기
		StringTokenizer st;	// 문자열 자르기
		
		// 10번 반복
		for(int tc = 1; tc <= 10; tc++) {
			// 데이터 수와 시작하는 사람 입력받기
			st = new StringTokenizer(br.readLine());
			dataNum = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			// 연락망 만들기
			contactNetwork = new int[101][101];	// 1번부터 시작
			
			// 연락망 전체 입력받아서 연락망 인접행렬로 저장
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < dataNum/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contactNetwork[from][to] = 1;
			}
			
			// 우선순위 큐 초기화
			pq.clear();
			// bfs로 탐색
			bfs(start);
			// 문자열 만들기
			sb.append("#").append(tc).append(" ").append(pq.poll().peopleNum).append("\n");
		}
		// 출력
		System.out.println(sb.toString());
	}
	
	static void bfs(int startNum) {
		Queue<People> q = new ArrayDeque<People>();	// 탐색할 애들 넣을 큐
		boolean[] visited = new boolean[101];	// 몇번 사람이 연락 받았는지 알아야하니까
		
		// 초기 depth는 1
		q.offer(new People(1, startNum));
		pq.offer(new People(1, startNum));
		visited[startNum] = true;
		
		// 큐가 비지 않은동안 반복
		while(!q.isEmpty()) {
			People curr = q.poll();	// 큐 맨 앞사람 꺼내기
			
			// 현재 사람이 연결하고 있는 다른 사람들 방문 여부 체크해서 큐에 넣기
			for(int i = 1; i <= 100; i++) {
				int connectChk = contactNetwork[curr.peopleNum][i];
				// 인접행렬상으로 연결되어있고, 방문하지 않았다면
				if(connectChk != 0 && !visited[i]) {
					q.offer(new People(curr.depth+1, i));	// 방문 큐에 넣고
					pq.offer(new People(curr.depth+1, i));	// 결과 큐에 넣고
					visited[i] = true;	// 방문처리
				}
			}
		}
	}
	
}