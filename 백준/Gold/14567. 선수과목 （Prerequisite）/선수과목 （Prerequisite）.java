import java.io.*;
import java.util.*;

/**
 * 메모리:  KB
 * 시간:  ms
 * 
 * 먼저, 과목들간 관계를 표현 해야한다.
 * 과목들은 결국 가중치가 없는 방향 그래프로 표현할 수 있으므로, 인접리스트로 선수과목과 이후 수강 가능한 과목을 표현했다.
 * 이 인접리스트의 노드에는 현재 과목번호, 다음에 수강 가능한 과목 노드이다.
 * 배열로 각 과목들로 들어오는 indegree를 표시하는 배열을 만든다
 * 위상정렬을 위해 indegree가 0인 과목들부터 차례로 1학기부터 카운팅한다.
 * 꺼낸 과목이 가리키는 다음 과목들의 indegree를 하나씩 줄여가며 모든 과목을 이수 할 때까지(모든 과목의indegree가 0) 반복한다. 
 * 
 *
 */
public class Main {

	static int subjNum, caseNum;	// 과목 수, 선수 조건의 수
	static Node[] adjList;			// 과목 인접 리스트
	static int[] indegree;			// indegree
	static int[] result;
	
	static class Node {
		int subject;
		Node next;
		public Node(int subject, Node next) {
			this.subject = subject;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		subjNum = Integer.parseInt(st.nextToken());
		caseNum = Integer.parseInt(st.nextToken());
		adjList = new Node[subjNum+1];
		indegree = new int[subjNum+1];
		result = new int[subjNum+1];
		
		for(int i = 0; i < caseNum; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			indegree[to]++;
		}
		
		int[] idx;
		int count = 1;
		while(true) {
			idx = getZeroIndegreeIdxArr();
			if(idx[0] == 0) break;
			
			for(int i = 0; i < subjNum; i++) {
				if(idx[i] == 0) break;	// indegree가 0인애들 확인 끝난 경우
				result[idx[i]] = count;
				indegreeUpdate(idx[i]);
			}
			
			count++;
		}
		
		for(int i = 1; i <= subjNum; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	static void indegreeUpdate(int currSubject) {
		for(Node next = adjList[currSubject]; next != null; next = next.next) {
			indegree[next.subject]--;
		}
	}
	
	static int[] getZeroIndegreeIdxArr() {
		int[] res = new int[subjNum];
		int idx = 0;
		for(int i = 1; i <= subjNum; i++) {
			if(result[i] == 0 && indegree[i] == 0) {
				res[idx++] = i;
			}
		}
		
		return res;
	}
}