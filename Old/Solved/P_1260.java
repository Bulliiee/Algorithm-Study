package solved;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * BJ_1260_DFS와BFS_이항우
 * https://www.acmicpc.net/problem/1260
 * 메모리: 38940 KB, 시간: 628 ms (재귀)
 * 메모리: 38676 KB, 시간: 660 ms (스택)
 * 
 * 전형적인 DFS, BFS를 사용해 그래프를 탐색하는 문제다.
 * DFS는 스택과 재귀를 활용해 구현하고,
 * BFS는 큐를 활용해 구현한다.
 * 
 * @author 이항우
 *
 */
public class P_1260 {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();	// 그래프 저장용 2차원 ArrayList
	static boolean[] visited;	// 방문 여부 확인용 배열, 인덱스는 정점 번호임
	
	// dfs 스택으로 구현
	static void dfsStack(int startVertex) {
		Stack<Integer> stack = new Stack<Integer>();	// 방문할 정점 저장할 스택
		
		stack.push(startVertex);	// 먼저, 스택에 시작 정점을 넣는다.
		
		while(!stack.empty()) {				// 스택이 빌 때까지 반복한다.
			int currVertex = stack.pop();	// 현재 정점을 스택에서 꺼내고
			
			if(!visited[currVertex]) {				// 해당 정점을 방문하지 않았으면
				visited[currVertex] = true;			// 방문 표시 한 후
				System.out.print(currVertex + " ");	// 출력
			}
			
			// 현재 정점과 연결된 다른 정점들 수만큼 반복하는데, 내림차순으로 스택에 넣어야 한다
			for(int i = graph.get(currVertex).size() - 1; i >= 0; i--) {	
				int nextVertex = graph.get(currVertex).get(i);	// 현재 정점에 연결된 다른 정점에서
				if(!visited[nextVertex]) {	// 해당 정점을 방문하지 않았다면
					stack.add(nextVertex);	// 스택에 넣고 반복한다
				}
			}
		}
	}

	// dfs 재귀로 구현
	static void dfs(int startVertex) {
		visited[startVertex] = true;			// 먼저, 호출할 때 받아온 정점 번호를 방문처리 함. 이는, 방문하지 않은 노드로 dfs를 호출하기 때문
		System.out.print(startVertex + " ");	// 방문했으니 출력
		
		for(int i = 0; i < graph.get(startVertex).size(); i++) {	// 방문한 정점에 연결된 정점들 확인 위한 반복
			int nextNode =graph.get(startVertex).get(i);	// 방문한 정점의 연결된 정점 번호를 담고
			if(!visited[nextNode]) {						// 해당 번호의 방문여부 체크 후, 방문하지 않았다면
				dfs(nextNode);								// 재귀적 호출
			}
		}
	}
	
	// bfs 큐로 구현
	static void bfs(int startVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();	// 방문할 정점 저장할 큐
		
		visited[startVertex] = true;	// 먼저 시작 정점 방문 표시
		queue.offer(startVertex);		// 큐에 삽입
		
		while(!queue.isEmpty()) {	// 큐가 빌때까지 반복
			int currVertex = queue.poll();		// 큐의 가장 앞에 있는 정점을 꺼냄
			System.out.print(currVertex + " ");	// 정점 출력
			
			for(int neighbor : graph.get(currVertex)) {	// 정점과 인접한 정점들 차례로 방문
				if(!visited[neighbor]) {
					visited[neighbor] = true;	// 방문한 정점 체크
					queue.offer(neighbor);		// 방문한 정점 큐에 삽입
				}
			}
		}
	}
	
	// 무방향 그래프, 출발지->도착지와 도착지->출발지 연결
	static void linkNode(int src, int dest) {
		graph.get(src).add(dest);	// 출발지와 도착지 연결
		graph.get(dest).add(src);	// 도착지와 출발지 연결
	}

	public static void main(String[] args) {
		/** 입력받기 */
		Scanner sc = new Scanner(System.in);	// 입력 Scanner
		int vertexNum = sc.nextInt();			// 정점 갯수 입력
		int edgeNum = sc.nextInt();				// 간선 갯수 입력
		int startVertex = sc.nextInt();			// 시작 정점 입력
		
		/** 2차원 ArrayList로 그래프 만들기 */
		for(int i = 0; i < vertexNum + 1; i++) {	// 0번 정점은 없으므로 정점 갯수 +1번 반복함
			graph.add(new ArrayList<Integer>());	// ArrayList<ArraryLise<Integer>>에 ArrayList<Integer> 연결
		}
		for(int i = 0; i < edgeNum; i++) {		// 간선 연결
			int src = sc.nextInt();				// 출발지 정점 번호
			int dest = sc.nextInt();			// 도착지 정점 번호
			linkNode(src, dest);				// 정점끼리 연결
		}
		for(int i = 0; i < graph.size(); i++) {		// 방문할 수 있는 정점 여러개일 때, 작은 번호부터 방문해야 하므로 작은 번호 순 정렬
			graph.get(i).sort(Comparator.naturalOrder());
//			graph.get(i).sort(null);
		}
		
		/** 탐색 */
		visited = new boolean[vertexNum + 1];	// 방문 여부 확인용 boolean 배열, 0번 정점 사용x
		dfs(startVertex);						// dfs(재귀) 호출
		System.out.println();
		
//		visited = new boolean[vertexNum + 1];	// 방문 여부 확인용 boolean 배열, 0번 정점 사용x
//		dfsStack(startVertex);					// dfs(스택) 호출
//		System.out.println();
		
		visited = new boolean[vertexNum + 1];	// 방문 여부 확인용 boolean 배열, 0번 정점 사용x
		bfs(startVertex);						// bfs 호출
		
		sc.close();	// Scanner 닫기
	}
}
