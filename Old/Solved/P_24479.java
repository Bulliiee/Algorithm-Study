package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BJ_24479_알고리즘수업-깊이우선탐색1_이항우
 * https://www.acmicpc.net/problem/24479
 * 메모리: 96912 KB, 시간: 2376 ms (재귀)
 * 
 * dfs를 그대로 구현하면서, 시작 정점부터 방문하는 순서를 출력한다.
 * 방문하는 순서를 저장하는 배열(visitSequence)과, 순서를 계산할 변수(visitCount)를 사용한다.
 * 이외에는 dfs 구현과 똑같다.
 * 
 * @author 이항우
 *
 */
public class P_24479 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();	// 그래프 저장 2차원 ArrayList
	static boolean[] visited;	// 방문 여부 확인 배열
	static int[] visitSequence;	// 방문 순서 저장 배열
	static int visitCount = 1;	// 방문 순서 계산 변수
	
	// dfs(재귀)
	static void dfs(int startVertex) {
		visited[startVertex] = true;				// 먼저 방문 표시
		visitSequence[startVertex] = visitCount++;	// 방문한 정점변호를 인덱스로 방문 순서 기록
		
		for(int i = 0; i < graph.get(startVertex).size(); i++) {	// 방문한 정점을 차례로 순회(작은 정점부터)
			int nextVertex = graph.get(startVertex).get(i);			// 순회하며 다음으로 방문할 정점 찾기
			if(!visited[nextVertex]) {								// 방문하지 않았다면
				dfs(nextVertex);									// 해당 정점을 기준으로 dfs()호출
			}
		}
	}
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringTokenizer st = new StringTokenizer(br.readLine());					// 입력 문자열 자르기
		
		// 기본 정보 입력
		int vertexNum = Integer.parseInt(st.nextToken());		// 정점 갯수
		int edgeNum = Integer.parseInt(st.nextToken());			// 간선 갯수
		int startVertex = Integer.parseInt(st.nextToken());		// 시작 정점
		
		// 그래프 만들기(정점 1부터 시작하므로 정점갯수+1만큼 만들기)
		for(int i = 0; i < vertexNum + 1; i++) {
			graph.add(new ArrayList<Integer>());	// 2중 ArrayList 생성
		}
		
		// 정점에 간선 추가(무방향이라 양쪽으로)
		for(int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());		// 출발 정점
			int dest = Integer.parseInt(st.nextToken());	// 도착 정점
			graph.get(src).add(dest);						// 그래프에서 정점끼리 연결(무방향)
			graph.get(dest).add(src);
		}
		
		for(int i = 1; i < vertexNum + 1; i++) {
			graph.get(i).sort(Comparator.naturalOrder());	// 각 정점에서 직접적으로 연결된 정점들 정렬(오름차순)
		}
		
		 visited = new boolean[vertexNum + 1];		// 방문 여부 확인(0번정점 사용 안하므로 정점갯수+1)
		 visitSequence = new int[vertexNum + 1];	// 방문 순서 확인(위와 같음)
		 dfs(startVertex);							// 시작 정점 기준으로 dfs()호출
		 
		for(int i = 1; i <= vertexNum; i++) { 
			System.out.println(visitSequence[i]);	// 결과 출력
		}
	}

}
