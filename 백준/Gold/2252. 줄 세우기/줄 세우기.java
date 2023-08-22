import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int studentNum, compairNum;
	static ArrayList<ArrayList<Integer>> students = new ArrayList<ArrayList<Integer>>();
//	static int[][] students;
	static int[] inDegree;
	static boolean[] visited;
	
	static Queue<Integer> q = new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		studentNum = Integer.parseInt(st.nextToken());
		compairNum = Integer.parseInt(st.nextToken());
		
		// 학생은 1번부터 시작
//		students = new int[studentNum+1][studentNum+1];
		for(int i = 0; i <= studentNum; i++) {
			students.add(new ArrayList<Integer>());
		}
		inDegree = new int[studentNum+1];
		visited = new boolean[studentNum+1];
		for(int i = 1; i <= compairNum; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			students.get(from).add(to);
//			students[from][to]++;
			inDegree[to]++;
		}
		
		// 위상정렬
		pushZeroIndegreeIdxToQueue();
		while(!q.isEmpty()) {
			int zeroIndegree = q.poll();
			sb.append(zeroIndegree + " ");
			pushZeroIndegreeIdxToQueue();
		}

		System.out.print(sb.toString());
	}
	
	static void pushZeroIndegreeIdxToQueue() {
//		for(int a : inDegree) {
//			System.out.print(a + " ");
//		}
//		System.out.println();
//		for(boolean a : visited) {
//			System.out.print(a + " ");
//		}
//		System.out.println();
		
		
		for(int i = 1; i <= studentNum; i++) {
			if(inDegree[i] == 0 && !visited[i]) {
				q.offer(i);
				visited[i] = true;
				removeOutDegree(i);
			}
		}
	}
	
	static void removeOutDegree(int from) {
//		for(int j = 1; j <= studentNum; j++) {
//			if(students[from][j] > 0) {
//				inDegree[j]--;
//			}
//		}
		
		int idx = students.get(from).size();
		while(idx-- > 0) {
			inDegree[students.get(from).get(idx)]--;
		}
	}

}
