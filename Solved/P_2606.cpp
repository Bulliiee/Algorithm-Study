// 바이러스
#include <iostream>
#define MAX 101     // 1번부터 사용

using namespace std;

bool map[MAX][MAX] = { false };
bool visited[MAX] = { false };
int inputVertex, inputEdge;
int count = 0;

void dfs(int curVertex) {
    count++;
    visited[curVertex] = true;  // 방문하지 않은 컴퓨터일 경우 visited로 방문했다고 찍기

    // 1번부터 존재하는 컴퓨터 갯수만큼 반복
    for(int i = 1; i <= inputVertex; i++) {
        // 현재 컴퓨터와 i가 연결되어있고, 그게 방문하지 않은 것이면
        if(map[curVertex][i] == 1 && !visited[i]) {
            dfs(i);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    cin >> inputVertex >> inputEdge;

    for(int i = 0; i < inputEdge; i++) {
        int t1, t2;
        cin >> t1 >> t2;

        map[t1][t2] = map[t2][t1] = true;
    }

    dfs(1);

    cout << count - 1;

    return 0;
}