// 그림
#include <iostream>
#include <queue>
#define MAX 500

using namespace std;

queue<pair<int, int>> q;
int height, width;
int paper[MAX][MAX];
bool visited[MAX][MAX];

// 좌표가 도화지 안쪽인지 확인
bool isInBound(int p1, int p2) {
    if((0 <= p1 && p1 < MAX) && (0 <= p2 && p2 < MAX)) return true;
    else return false;
}

// 방문한 칸 수가 그림의 넓이가 된다.
// 그걸 리턴
int bfs() {
    int move1[] = {0, 0, -1, 1};
    int move2[] = {-1, 1, 0, 0};
    int curP1, curP2;
    int area = 0;

    while(!q.empty()) {
        curP1 = q.front().first;
        curP2 = q.front().second;
        q.pop();
        visited[curP1][curP2] = true;
        area++;

        // 왼쪽오른쪽위아래 무빙
        for(int i = 0; i < 4; i++) {
            int newP1 = curP1 + move1[i];
            int newP2 = curP2 + move2[i];

            // newP가 도화지 안쪽이고, 방문안했고, 색칠되어있으면
            if(isInBound(newP1, newP2) && !visited[newP1][newP2] && paper[newP1][newP2] == 1) {
                q.push(make_pair(newP1, newP2));
                visited[newP1][newP2] = true;
            }
        }
    }

    return area;
}

void input() {
    cin >> height >> width;

    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            cin >> paper[i][j];
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int count = 0;  // 그림 갯수
    int max = 0;    // 가장 큰 그림 넓이
    int area = 0;   // bfs한 그림 넓이

    input();

    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            // 방문하지 않았고, 도화지에 색칠 되어있으면 거기를 시작점으로 bfs탐색한다.
            // 한번 bfs를 끝낼때마다 그림의 최대크기를 갱신하고, 그림의 갯수를 증가시킨다.
            if(!visited[i][j] && paper[i][j] == 1) {
                q.push(make_pair(i, j));
                area = bfs();
                max = max < area ? area : max;
                count++;
            }
        }
    }

    cout << count << '\n' << max;

    return 0;
}