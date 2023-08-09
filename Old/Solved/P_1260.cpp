// DFS와 BFS
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
#define MAX 1001    // 정점갯수 최대 1000개

int map[MAX][MAX];  // 정점번호, 정점이 가리키는 번호
bool visited[MAX];  // 정점번호의 방문 여부
int vertexSize;
queue<int> q;       // bfs용 큐

void dfs(int curVertexNum) {
    visited[curVertexNum] = true;

    cout << curVertexNum << ' ';

    // 현재 탐색할 정점이 가진 하위 정점들의 갯수만큼 반복 탐색
    for(int i = 1; i <= vertexSize; i++) {
        // 현재 정점이 가리키는 다음정점(i)이 방문하지 않은 정점이라면
        // dfs를 재귀호출하여 깊이탐색을 함
        if(map[curVertexNum][i] == 1 && visited[i] == false) {
            dfs(i);
        }
    }
}

void bfs(int curVertexNum) {
    // 먼저 현재 정점 방문 체크 후
    // 큐에 현재 정점 넣음
    visited[curVertexNum] = true;
    q.push(curVertexNum);

    cout << curVertexNum << ' ';

    // 큐가 빌때까지 반복
    while(!q.empty()) {
        // 현재 정점을 다음 정점으로 갱신 후
        // 큐에서 제거
        curVertexNum = q.front();
        q.pop();

        // 현재 정점이 가리키는 다음 정점을 다 볼때까지 반복
        for(int i = 1; i <= vertexSize; i++) {
            // 현재 정점이 가리키는 다음 정점(i)이 방문하지 않은 정점이라면
            // 방문체크 후 큐에 넣음
            if(map[curVertexNum][i] == 1 && visited[i] == 0) {
                visited[i] = true;
                q.push(i);
                cout << i << ' ';
            }
        }
    }
}

void reset(int vertexNum) {
    for(int i = 1; i <= vertexNum; i++) {
        visited[i] = false;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // 정점, 간선, 시작정점번호
    int vertexNum, edgeNum, startVertexNum;
    int tempV1, tempV2;

    cin >> vertexNum >> edgeNum >> startVertexNum;
    vertexSize = vertexNum;

    for(int i = 0; i < edgeNum; i++) {
        cin >> tempV1 >> tempV2;

        map[tempV1][tempV2] = 1;
        map[tempV2][tempV1] = 1;
    }

    dfs(startVertexNum);
    cout << '\n';

    reset(vertexNum);
    bfs(startVertexNum);

    return 0;
}