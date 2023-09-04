import java.util.*;
import java.io.*;
	
/**
 * union-find를 한다.
 * 두 원소 a, b를 합집합 연산 할 때는, b의 루트노드의 부모를 a의 루트로 바꿔버린다.
 * 두 원소가 같은 집합인지 확인 할 때는 루트노드(부모가 자기 자신)가 나올 때까지 거슬로 올라가며, 그 경로에 있는 모든 원소들의 직속 부모를
 * 해당 루트노드로 바꿔서 경로압축을 실시한다.
 * 이후 두 원소의 루트노드가 같다면 YES, 아니면 NO
 */
public class Main {
	
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeSet();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if(com == 0) {
				sum(num1, num2);
			}
			else {
				sb.append(isSameParent(num1, num2) ? "YES\n" : "NO\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void makeSet() {
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int number) {
		if(parent[number] == number) {
			return number;
		}
		
		return parent[number] = find(parent[number]);
	}
	
	static void sum(int num1, int num2) {
		parent[find(num2)] = find(num1); 
	}
	
	static boolean isSameParent(int num1, int num2) {
		int num1Root = find(num1);
		int num2Root = find(num2);
		
		if(num1Root == num2Root) {
			return true;
		}
		
		return false;
	}
	
	
}