import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;
	
	public Node(char data) {
		this(data, null, null);
	}
	
	public Node(char data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class Main {
	
	static Node root = new Node('A');
	
	// 전위순회
	static void preOrder(Node currNode) {
		// 기저조건: null 만나면 return(되돌아감)
		if(currNode == null) {
			return;
		}
		
		System.out.print(currNode.data);	// 부모
		preOrder(currNode.left);			// 왼쪽자식
		preOrder(currNode.right);			// 오른쪽자식
	}
	
	// 중위순회
	static void inOrder(Node currNode) {
		// 기저조건: null 만나면 return(되돌아감)
		if(currNode == null) {
			return;
		}
		
		inOrder(currNode.left);				// 왼쪽자식
		System.out.print(currNode.data);	// 부모
		inOrder(currNode.right);			// 오른쪽자식
	}
	
	// 후위순회
	static void postOrder(Node currNode) {
		// 기저조건: null 만나면 return(되돌아감)
		if(currNode == null) {
			return;
		}
		
		postOrder(currNode.left);			// 왼쪽자식
		postOrder(currNode.right);			// 오른쪽자식
		System.out.print(currNode.data);	// 부모
	}

	static void makeTree(Node temp, char data, char left, char right) {
		// 만들어야하는 노드(data)자리까지 도달했다면 노드 만들지 말지 결정
		if(temp.data == data) {
			temp.left = (left == '.' ? null : new Node(left));
			temp.right = (right == '.' ? null : new Node(right));
		}
		// 아니라면(만들어야하는 노드자리까지 도달 못했다면) 계속 타고타고 들어가기
		else {
			if(temp.left != null) {
				makeTree(temp.left, data, left, right);
			}
			if(temp.right != null) {
				makeTree(temp.right, data, left, right);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int nodeNum = Integer.parseInt(br.readLine());	// 노드 갯수 입력받기
		
		for(int i = 0; i < nodeNum; i++) {
			st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);	// 노드 데이터
			char left = st.nextToken().charAt(0);	// 왼쪽자식
			char right = st.nextToken().charAt(0);	// 오른쪽자식
			
			makeTree(root, data, left, right);
		}
		
		preOrder(root);			// 전위
		System.out.println();
		inOrder(root);			// 중위
		System.out.println();
		postOrder(root);		// 후위
	}

}