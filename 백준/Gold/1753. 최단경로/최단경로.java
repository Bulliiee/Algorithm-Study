import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 인접리스트 활용한 다익스트라 사용
 * 1. 미방문 정점 중 출발지와 가까운 정점 탐색
 * 	- distance배열의 해당 정점 인덱스가 출발지로부터 해당 정점까지의 최단거리(min)가 되며,
 *    이 정점이 다음 정점까지의 경유지(stopOver)가 될 수 있다.
 * 2. 해당 미방문 정점 방문처리
 * 3. 이 정점을 경유지로 가는것이 빠른지, 기존에 설정된(혹은 설정되지 않아서 INF인) 경우가 빠른지 비교
 * 	- distance[stopOver->nextVertex] > min + nextVertex.weight인 경우
 *    distance를 갱신한다.
 * 
 */
public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	
	static int V, E, startVertex;	// 정점갯수, 간선갯수, 시작 정점 번호
	static Node[] adjList;			// 인접 리스트
	static int[] distance;			// 시작 정점으로부터 인덱스 정점까지 최소 거리 저장
	static boolean[] visited;		// 방문 배열 사용
	
	static class Node {
		int vertex;
		int weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();		// 출력 문자열 만들기
		StringTokenizer st = new StringTokenizer(br.readLine());	// 문자열 자르기
		
		V = Integer.parseInt(st.nextToken());	// 정점갯수
		E = Integer.parseInt(st.nextToken());	// 간선갯수
		startVertex = Integer.parseInt(br.readLine());	// 시작 정점 번호
		
		adjList = new Node[V+1];	// 0번 사용x
		distance = new int[V+1];	// 0번 사용x
		visited = new boolean[V+1];	// 0번 사용x
		for(int i = 0; i < E; i++) {
			// 인접리스트 만들기
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		// 거리 배열 최대값으로 초기화
		Arrays.fill(distance, INF);
		
		// 시작 정점 설정
		distance[startVertex] = 0;

		int min, stopOver;	// 최소가중치(출발지에서 경유지까지의 최단거리), 경유지
		for(int i = 0; i < V; i++) {
			min = INF;
			stopOver = -1;
			// 1. 출발점으로부터 가장 가까운 미방문 정점 구하기
			for(int j = 1; j <= V; j++) {				
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					stopOver = j;
				}
			}
			if(stopOver == -1) {
				break;
			}
			
			// 2. 방문처리
			visited[stopOver] = true;
			
			// 3. 해당 경유지에서 갈 수 있는 애들 모두 탐색해서 현재 distance에 적힌 값과 경유해서 가는 거리 비교해서
			// 작은거 넣는다.
			for(Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min+temp.weight;
				}
			}
		}
		
		// 결과 출력
		for(int i = 1; i <= V; i++) {
			int res = distance[i];
			if(res == INF) {
				sb.append("INF");
			}
			else {
				sb.append(res);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
