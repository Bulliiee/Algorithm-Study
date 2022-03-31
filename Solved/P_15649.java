package Solved;
// N과 M (1) 
/*
    백트래킹 사용
    백트래킹이란 트리 형태의 노드들을 DFS수행하며 노드의 유망성(promising)을 판단하며
    유망하지 못하다고 생각하면 가지치기(풀이시간 단축, pruning)하고 
    다시 부모노드로 돌아가 다른 자식노드 탐색하는 것
    백트래킹의 방법 중 하나가 DFS(깊이우선탐색)
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_15649 {
    public static int []arr;
    public static boolean []visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];       // 탐색하며 값 담을 배열
        visit = new boolean[n]; // 이미 방문한 노드라면 다음꺼 탐색하기 위한 배열

        // 첫 호출은 depth가 0
        getSequence(n, m, 0);
    
        System.out.println(sb);
    }
    
    // depth로 재귀 깊이 측정, m까지 들어갔으면 arr배열 출력하고 리턴
    static void getSequence(int n, int m, int depth) {
        // 재귀 깊이가 m과 같아지면 탐색과정에서 담은 배열을 출력
        // 재귀를 끝낼 조건
        if(depth == m) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {                     // 만약 해당 노드를 방문하지 않았다면
                arr[depth] = i + 1;             // 해당 깊이를 인덱스로 해서 i + 1 저장
                visit[i] = true;                // 해당 노드를 방문상대로 변경
                getSequence(n, m, depth + 1);   // 다음 자식노드 방문 위해 depth+1하며 재귀
                // 자식노드 방문 끝나고 돌아오면 방문노드 방문하지 않은 상태로 변경
                visit[i] = false;
            }
        }
    }
}
