// 경로 찾기
/*
<플로이드 워셜 알고리즘(Floyd-Warshall Algorithm)>

다익스트라 알고리즘은 한 곳에서 다른 특정 지점까지의 최단 경로를 구하는 알고리즘
플로이드 워셜을 모든 지점에서 다른 모든 지점까지의 최단경로를 모두 구하는 알고리즘

소스코드가 다익스트라에 비해 매우 짧아 구현이 쉬움

다익스트라는 그리디, 플로이드 워셜은 DP에 속함
왜냐하면 만약 노드 갯수가 N개라고 하면 N번만큼 단계를 반복하며
점화식에 맞게 2차원 리스트를 갱신하기 때문임

다익스트라는 한 지점에서 다른 지점까지의 최단거리이기에 1차원 리스트에 저장함
플로이드 워셜은 2차원 테이블에 최단거리 정보를 저장함
(모든 지점에서 다른 모든 지점까지 최단거리 저장해야 하기 때문)

다익스트라는 단계마다 최단거리를 가지는 노드를 하나씩 반복적으로 선택함
이후 해당 노드 거쳐가는 경로 확인하며 최단거리 테이블을 갱신하는 방식으로 동작함
플로이드 워셜은 단계마다 거쳐가는 노드를 기준으로 알고리즘을 수행함
매 단계마다 방문 안한 노드중 최단거리를 갖는 노드를 찾을 필요가 없음

플로이드 워셜의 점화식
Distance[a,b] = min(Distance[a,b], Distance[a,k] + Distance[k,b])
-> a에서 b까지의 거리는
a에서 b까지의 거리와 a에서 b사이의 k를 거친것 중 작은 값이 된다.

시간복잡도 O(N^3)
현재 노드 갯수 N개일 때, N번의 단계 수행하며, 단계마다 O(N^2)의 연산을 통해
현재 노드를 거쳐가는 모든 경로를 고려한다.
따라서 시간복잡도는 총 O(N^3)

https://ansohxxn.github.io/algorithm/floyd/
*/
#include <iostream>

#define MAX 100

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // int INF = 10000000;
    // int temp;
    int a[MAX][MAX];
    int input;
    cin >> input;

    for(int i = 0; i < input; i++) {
        for(int j = 0; j < input; j++) {
            // cin >> temp;
            // if(temp == 0) { temp = INF; }
            // a[i][j] = temp;
            cin >> a[i][j];
        }
    }

    // 플로이드 워셜
    for(int k = 0; k < input; k++) {    // 거쳐가는 정점
        for(int i = 0; i < input; i++) {    // 행(출발정점)
            for(int j = 0; j < input; j++) {    // 열(도착 정점)
                // if(a[i][j] > (a[i][k] + a[k][j])) { // 점화식대로
                //     a[i][j] = (a[i][k] + a[k][j]);
                // }
                
                // i에서 j로갈 때 k점을 거쳐서 도착할 수 있으며 i에서 j로 갈 수 있다고 본다.
                if(a[i][k] == 1 && a[k][j] == 1) {
                    a[i][j] = 1;
                }
            }
        }
    }

    for(int i = 0; i < input; i++) {
        for(int j = 0; j < input; j++) {
            // if(a[i][j] == INF) { a[i][j] = 0; }
            // else { a[i][j] = 1; }
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}