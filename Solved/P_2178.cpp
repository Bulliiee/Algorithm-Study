// 미로 탐색
#include <iostream>
#include <string>
#include <queue>

#define MAX 100

using namespace std;

int n, m;               // 미로 크기
int map[MAX][MAX];      // 미로 2차원 배열
int dist[MAX][MAX];     // 탐색거리
bool visited[MAX][MAX]; // 방문확인 2차원 배열
// int count = 0;  // 탐색거리
queue<pair<int, int>> q;    // 탐색할 좌표 저장 while문에서 사용

void searchMaze(int row, int column) {
    // 상하좌우로 좌표 1씩 증가시키기 위함
    // 같은 인덱스일 때, 만약 인덱스 0이라면
    // row에 0, col에 -1이 더해지면 왼쪽좌표로 한 칸 가는 것이고
    // 만약 인덱스 2라면
    // row에 -1, col에 0이 더해지면 위쪽좌표로 한 칸 가는 것이다.
    int xMove[] = {0, 0, -1, 1};
    int yMove[] = {-1, 1, 0, 0};

    // [0][0] 방문 시 먼저 체크
    visited[row][column] = true;
    q.push(make_pair(row, column));     // pair 생성 시 make_pare()
    dist[row][column]++;
    // count++;

    while(!q.empty()) {
        // 현재좌표 갱신
        int r = q.front().first;    // pair 접근 시 .first, .second
        int c = q.front().second;

        q.pop();

        // 상하좌우로 좌표 1씩 증가, 감소시켜서 하나씩 본다.
        // 방문하지 않았고, 갈 수 있는 길이라면(map[][]의 값이 1)
        // 큐에 넣고 거리를 증가시킨다.
        for(int i = 0; i < 4; i++) {
            int nextR = r + yMove[i];
            int nextC = c + xMove[i];

            // 다음에 탐색할 새로운 좌표 tempR, tempC이 갈 수 있는 좌표인지 확인
            // if문이 and문으로만 이루어졌기에 순서가 중요하다.
            // nextR, nextC이 좌표를 벗어나지 않았는지 먼저 체크해야 방문여부와 갈 수 있는지 여부를 확인할 수 있다.
            if((0 <= nextR && nextR < n) && (0 <= nextC && nextC < m) &&
                !visited[nextR][nextC] && map[nextR][nextC] == 1) {
                visited[nextR][nextC] = true;
                q.push(make_pair(nextR, nextC));
                dist[nextR][nextC] = dist[r][c] + 1;
                // count++;
            }
        }
    }
}

void printInput() {
    // 2차원 미로 출력 테스트
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << map[i][j] << ' ';
        }
        cout << '\n';
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << visited[i][j] << ' ';
        }
        cout << '\n';
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << dist[i][j] << ' ';
        }
        cout << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    for(int i = 0; i < n; i++) {
        string temp;
        cin >> temp;
        for(int j = 0; j < m; j++) {
            map[i][j] = temp[j] - '0';
            // visited[i][j] = false;
        }
    }
    
    searchMaze(0, 0);

    // printInput();

    cout << dist[n-1][m-1] << '\n';

    return 0;
}