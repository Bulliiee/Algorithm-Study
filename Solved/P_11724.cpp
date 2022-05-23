// 연결 요소의 개수
#include <iostream>
#include <vector>
#include <queue>
#define MAX 1001    // 정점 1부터 시작

using namespace std;

bool map[MAX][MAX];
bool visited[MAX] = {false};   // 정점 방문여부
int vNum, eNum;                // 정점, 간선 갯수

void dfs(int vertex) {
    visited[vertex] = true;

    for(int i = 1; i <= vNum; i++) {
        // 깊이우선 탐색, 들어온 정점에서 연결된 모든 정점 다 체크하며 방문안했으면 계속 들어간다.
        if(map[vertex][i] == true && !visited[i]) {
            dfs(i);
        }
    }
}

int getConnectedComponent() {
    int count = 0;

    // 존재하는 정점 모두 다 시작점으로 탐색한다.
    for(int i = 1; i <= vNum; i++) {
        if(!visited[i]) {
            count++;
            dfs(i);
        }
    }

    return count;
}

void input() {
    cin >> vNum >> eNum;

    for(int i = 0; i < eNum; i++) {
        int t1, t2;
        cin >> t1 >> t2;

        map[t1][t2] = true;
        map[t2][t1] = true;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // 입력받기
    input();

    // 수행 및 출력
    cout << getConnectedComponent();

    return 0;
}