// 토마토
#include <iostream>
#include <vector>
#include <queue>
#define MAX 1000

using namespace std;

int width, height;      // 토마토박스 크기
int dayCount = 0;       // 익어가는 날짜
int box[MAX][MAX];      // 박스
bool visited[MAX][MAX]; // 방문여부

queue<pair<int, int>> startQ;
queue<pair<int, int>> q;    // 다음에 방문할 곳 좌표 큐

// 입력받기
void input() {
    cin >> width >> height;
    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            cin >> box[i][j];
        }
    }
}

// 테스트용 출력
void print(char what) {
    cout << '\n';
    // box
    if(what == 'b') {
        cout << "box >> \n";
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                cout << box[i][j] << ' ';
            }
            cout << '\n';
        }
    }
    // visited
    else if(what == 'v') {
        cout << "visited >> \n";
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                cout << visited[i][j] << ' ';
            }
            cout << '\n';
        }
    }
}

// 방문하지 않은 토마토가 있는 경우, 그것을 시작점으로 설정 위함(q에 넣음)
// 방문할게 남아있으면 true, 아니면 false;
void getTomatoStartPoint() {
    // bool flag = false;

    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            // 토마토가 익었고, 방문하지 않았다면
            if(box[i][j] == 1 && visited[i][j] == false) {
                // 큐에 탐색할 토마토로 저장
                q.push(make_pair(i, j));
                // 방문할게 남았다고 표시해줌
                // flag = true;
            }
        }
    }

    // return flag;
}

// 다음칸 검사 시 박스 크기 벗어났는지 체크
bool isOnBound(int nextRow, int nextCol) {
    return (0 <= nextRow && nextRow < height) && (0 <= nextCol && nextCol < width);
}

// 시작점 좌표
void aging() {
    int rowMove[] = { 0, 0, -1, 1 };
    int colMove[] = { -1, 1, 0, 0 };
    int row, col;

    while(!q.empty()) {
        row = q.front().first;
        col = q.front().second;
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nextRow = row + rowMove[i];
            int nextCol = col + colMove[i];

            if(isOnBound(nextRow, nextCol) && box[nextRow][nextCol] == 0 &&
            !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                box[nextRow][nextCol] = box[row][col] + 1;
                q.push(make_pair(nextRow, nextCol));
            }
        }
    }



    // print('b');
    // print('v');
}

// 끝났는데 안익은 토마토 있는지 검사
// 다 됐으면 true리턴, 안됐으면 false리턴
int doneCheck() {
    int dayCount = 0;
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (box[i][j] == 0 && visited[i][j] == false) {
                return -1;
            }
            if(dayCount < box[i][j]) {
                dayCount = box[i][j];
            }
        }
    }

    return (dayCount - 1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    getTomatoStartPoint();
    // cout << q.front().first << ", " << q.front().second << '\n';

    aging();
    

    // print('b');
    // print('v');
    cout << doneCheck();

    return 0;
}