import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int vertexNum;	// 정점 갯수
	static int edgeNum;		// 간선 정보 갯수
	
	static Edge[] edgeList;	// 간선 정보 저장할 배열
	static int[] parents;	// union find를 위한 부모 담는 배열
	
	// 간선 정보 저장할 클래스
	static class Edge implements Comparable<Edge>{
		int from, to, weight;	// 정점 시작점, 도착점, 가중치
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		// 가중치 중심으로 오름차순 정렬 위해 오버라이드
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력용
		StringBuilder sb = new StringBuilder();	// 출력 문자열 만들기용
		StringTokenizer st;	// 문자열 자르기용
		
		int T = Integer.parseInt(br.readLine());	// 테케 수 입력
		for(int tc = 1; tc <= T; tc++) {	// 테케 수만큼 반복
			st = new StringTokenizer(br.readLine());		// 한 줄 입력받기
			vertexNum = Integer.parseInt(st.nextToken());	// 정점 갯수 입력받기
			edgeNum = Integer.parseInt(st.nextToken());		// 간선 정보 수 입력받기

			// 간선 정보 입력
			edgeList = new Edge[edgeNum];
			for(int i = 0; i < edgeNum; i++) {	// 간선 정보 수만큼 반복
				st = new StringTokenizer(br.readLine());		// 한 줄 입력받기
				int from = Integer.parseInt(st.nextToken()); 	// 시작 정점
				int to = Integer.parseInt(st.nextToken()); 		// 끝 정점
				int weight = Integer.parseInt(st.nextToken());	// 가중치
				
				edgeList[i] = new Edge(from, to, weight);		// 간선 정보 배열에 넣기
			}
			
			// 오름차순 정렬(크루스칼시 그리디하게 하려면 필수)
			Arrays.sort(edgeList);
			
			long result = 0;		// 가중치 누적 합 저장
			int count = 0;		// 연결시킨 간선의 갯수 저장
			
			make();	// 부모 배열 초기화
			for(Edge edge : edgeList) {	// 연결
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					// 간선 갯수가 정점갯수-1개만큼 되었다면 모두 연결된 것
					if(++count == vertexNum) {	
						break;
					}
				}
			}
			
			// 출력 문자열 만들기
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		// 출력
		System.out.print(sb.toString());
	}
	
	// 초기에 정점들 부모를 자기 자신으로 초기화
	static void make() {
		parents = new int[vertexNum+1];	// 1번부터 정점 존재
		// 자기자신이 부모가 되도록 함
		for(int i = 1; i <= vertexNum; i++) {
			parents[i] = i;
		}
	}
	
	// 대표자 찾기
	static int findSet(int vertex) {
		// 자기 자신이 부모라면 해당 정점이 대표자
		if(parents[vertex] == vertex) {
			return vertex;
		}
		
		// 대표자 못찾았으면 해당 정점의 부모한테 계속 거슬러 올라감
		// path compression 시행, 자기 자신을 대표자한테 연결
		return parents[vertex] = findSet(parents[vertex]);
	}
	
	// 두 정점 합치기, 성공시 true, 실패시 false 리턴
	static boolean union(int vertex1, int vertex2) {
		int v1Root = findSet(vertex1);	// 정점1의 대표자
		int v2Root = findSet(vertex2);	// 정점2의 대표자
		
		if(v1Root == v2Root) {	// 만약, 둘의 대표자가 같다면 같은 집합이다(사이클이 된다.)
			return false;		// 따라서 합치지 않고 false
		}
		parents[v2Root] = v1Root;	// 대표자가 다르다면 정점2의 대표자 부모를 정점1의 대표자로 바꾼다
		return true;				// 성공했으니 true
	}
	
}
