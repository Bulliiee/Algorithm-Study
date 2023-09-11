import java.io.*;
import java.util.*;


public class Main {

	static int cityNum, roadNum, targetDistance, startCity;
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Node[] adjList;
	
	static class Node {
		int city;
		Node next;
		
		public Node(int city, Node next) {
			this.city = city;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cityNum = Integer.parseInt(st.nextToken());
		roadNum = Integer.parseInt(st.nextToken());
		targetDistance= Integer.parseInt(st.nextToken());
		startCity = Integer.parseInt(st.nextToken());
		adjList = new Node[cityNum+1];
		
		for(int i = 0; i < roadNum; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adjList[start] = new Node(end, adjList[start]);
		}
		
		bfs(new int[] {startCity, 0});
		
		if(list.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(list);
		for(int t : list) {
			System.out.println(t);
		}
	}
	
	static void bfs(int[] root) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[cityNum + 1];
		
		q.offer(root);
		visited[root[0]] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int now = temp[0];
			int distance = temp[1];
			
			if(distance == targetDistance) {
				list.add(now);
				continue;
			}
			
			for(Node nextCity = adjList[now]; nextCity != null; nextCity = nextCity.next) {
				if(!visited[nextCity.city]) {
					visited[nextCity.city] = true;
					q.offer(new int[] {nextCity.city, distance+1});
				}
			}
		}
	}

}