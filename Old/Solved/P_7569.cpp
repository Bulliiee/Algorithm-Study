// 토마토
#include <iostream>
#include <queue>

#define MAX 100

using namespace std;

// 좌표
class Points {
private:
    int x;
    int y;
    int z;

public:
    Points(int x, int y, int z) {
        this->x = x;
        this->y = y;
        this->z = z;
    }
    int getX() {
        return this->x;
    }
    int getY() {
        return this->y;
    }
    int getZ() {
        return this->z;
    }
};

// z, y, x축
/*
z = 2, y = 3, x = 4인 경우
000 001 002 003
010 011 012 013
020 021 022 023

100 101 102 103
110 111 112 113
120 121 122 123
*/
queue<Points> q;            // 다음에 탐색할 좌표 담을 큐
int box[MAX][MAX][MAX];     // 토마토 담긴 박스
bool visited[MAX][MAX][MAX];// 방문여부

int inputX, inputY, inputZ;

void printTest() {
    cout << "\nbox>>\n";
    for(int i = 0; i < inputZ; i++) {
        for(int j = 0; j < inputY; j++) {
            for(int k = 0; k < inputX; k++) {
                cout << '[' << i << "][" << j << "][" << k << "]: " << box[i][j][k] << ' ';
            }
            cout << '\n';
        }
        cout << '\n';
    }
    cout << "\nvisited>>\n";
    for(int i = 0; i < inputZ; i++) {
        for(int j = 0; j < inputY; j++) {
            for(int k = 0; k < inputX; k++) {
                cout << '[' << i << "][" << j << "][" << k << "]: " << visited[i][j][k] << ' ';
            }
            cout << '\n';
        }
        cout << '\n';
    }
}

// 끝난 후 며칠이 걸렸는지 체크
int getDayCount() {
    int dayCount = 0;

    for(int i = 0; i < inputZ; i++) {
        for(int j = 0; j < inputY; j++) {
            for(int k = 0; k < inputX; k++) {
                if(box[i][j][k] == 0) {
                    return -1;
                }
                // 박스에 써있는 숫자가 탐색한 길이==걸린 날짜라고 볼 수 있음
                if(dayCount < box[i][j][k]) {
                    dayCount = box[i][j][k] - 1;
                }
            }
        }
    }

    return dayCount;
}

// 처음으로 탐색할 토마토 위치들 찾아서 큐에 넣기
void getStartPoints() {
    for(int i = 0; i < inputZ; i++) {
        for(int j = 0; j < inputY; j++) {
            for(int k = 0; k < inputX; k++) {
                if(box[i][j][k] == 1 && !visited[i][j][k]) {
                    visited[i][j][k] = true;
                    q.push(Points(k, j, i));
                }
            }
        }
    }
}

// 바운드 안에 있고, 방문 여부 확인
bool isPossible(int nextX, int nextY, int nextZ) {
    if((0 <= nextX && nextX < inputX) &&
        (0 <= nextY && nextY < inputY) &&
        (0 <= nextZ && nextZ < inputZ) &&
        !visited[nextZ][nextY][nextX]) {
            return true;
    }

    return false;
}

// 토마토 익히기
void aging() {
    int moveX[] = { -1, 1, 0, 0, 0, 0 };
    int moveY[] = { 0, 0, -1, 1, 0, 0 };
    int moveZ[] = { 0, 0, 0, 0, -1, 1 };
    int x, y, z;

    while(!q.empty()) {
        // 처음 얻은 좌표 넣고(현재좌표)
        x = q.front().getX();
        y = q.front().getY();
        z = q.front().getZ();
        q.pop();

        // 다음 좌표들 탐색(왼오앞뒤위아래)
        for(int i = 0; i < 6; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            int nextZ = z + moveZ[i];

            // 바운드 안쪽이고, 방문 안했고, 안익은 토마토 심어졌으면
            if(isPossible(nextX, nextY, nextZ) && box[nextZ][nextY][nextX] == 0) {
                // 방문표시, 현재박스에서 1 더해 다음박스에 넣고, 큐에 좌표 넣음
                visited[nextZ][nextY][nextX] = true;
                box[nextZ][nextY][nextX] = box[z][y][x] + 1;
                q.push(Points(nextX, nextY, nextZ));
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int dayCount = 0;

    // input
    cin >> inputX >> inputY >> inputZ;
    for(int i = 0; i < inputZ; i++) {
        for(int j = 0; j < inputY; j++) {
            for(int k = 0; k < inputX; k++) {
                cin >> box[i][j][k];
            }
        }
    }
    
    getStartPoints();
    aging();

    // printTest();
    dayCount = getDayCount();

    cout << dayCount;

    return 0;
}