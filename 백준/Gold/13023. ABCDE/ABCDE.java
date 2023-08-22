import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> relationship = new ArrayList<ArrayList<Integer>>();
	static int peopleNum, relationNum;
	
	static boolean[] visited;
	
	static boolean dfs(int start, int count) {
		
		if(count >= 5) {
			return true;
		}
		
		count += 1;
		for(int i : relationship.get(start)) {
			if(!visited[i]) {
				visited[i] = true;
				if(dfs(i, count)) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		peopleNum = Integer.parseInt(st.nextToken());
		relationNum = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < peopleNum; i++) {
			relationship.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < relationNum; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relationship.get(a).add(b);
			relationship.get(b).add(a);
		}
		
		for(int i = 0; i < peopleNum; i++) {
			visited = new boolean[peopleNum];
			if(dfs(i, 0)) {
				System.out.print(1);
				return;
			}
		}
		System.out.print(0);
	}
	
}
