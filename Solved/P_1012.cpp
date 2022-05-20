// 유기농 배추
#include <iostream>
#include <vector>
#include <queue>
#include <memory.h>
#define MAX 51  // 1부터 시작

using namespace std;

int map[MAX][MAX] = { 0 };          // 배추 어디있는지 표시 
bool visited[MAX][MAX] = { false }; // 방문 여부
vector<pair<int, int>> v;           // 배추 있는 좌표 명시
queue<pair<int, int>> q;            // 다음 탐색할 좌표들 담을 큐


// map과 visited배열 초기화
void init() {
    // 0, -1로 초기화시킬 경우 memset이 fill보다 더 빠르기에 이걸로 한다.
    memset(map, 0, sizeof(map));
    memset(visited, false, sizeof(visited));
    
    // fill(map[0], map[MAX], 0);
    // fill(visited[0], visited[MAX], false);
}

int dfs(int width, int height, int pointAmount) {
    int xMove[] = {0, 0, -1, 1};
    int yMove[] = {-1, 1, 0, 0};
    int curX, curY;
    int count = 0;

    // 배추 좌표 적혀있는거만 시작점으로 탐색한다.
    while(!v.empty()) {
        curX = v.back().first;
        curY = v.back().second;
        v.pop_back();

        // 방문을 했던 배추 좌표라면 다시 올라가서 좌표 뽑아옴
        if(visited[curX][curY]) {
            continue;
        }

        // 방문 안했다면 아래쪽 실행
        visited[curX][curY] = true;
        q.push(make_pair(curX, curY));
        count++;

        // 현재 좌표 기준으로 이어진것들 다 체크
        while(!q.empty()) {
            curX = q.front().first;
            curY = q.front().second;
            q.pop();

            // 왼쪽, 오른쪽, 위, 아래 움직이며 이어진 배추들 체크
            for (int i = 0; i < 4; i++) {
                int tx = curX + xMove[i];
                int ty = curY + yMove[i];

                if ((0 <= tx && tx < width) && (0 <= ty && ty < height) &&
                    map[tx][ty] == 1 && visited[tx][ty] == false) {
                    q.push(make_pair(tx, ty));
                    visited[tx][ty] = true;
                }
            }
        }
    }

    return count;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase;                   // 테스트케이스 수
    int width, height, pointAmount; // 가로, 세로, 배추 심어진 위치 갯수

    cin >> testCase;
    while(testCase--) {
        init();     // 입력 받기 전 초기화
        int count = 0;
        cin >> width >> height >> pointAmount;
        for(int i = 0; i < pointAmount; i++) {
            int x, y;
            cin >> x >> y;
            v.push_back(make_pair(x, y));
            map[x][y] = 1;
        }

        cout << dfs(width, height, pointAmount) << '\n';
    }

    return 0;
}