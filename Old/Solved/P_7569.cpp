// �丶��
#include <iostream>
#include <queue>

#define MAX 100

using namespace std;

// ��ǥ
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

// z, y, x��
/*
z = 2, y = 3, x = 4�� ���
000 001 002 003
010 011 012 013
020 021 022 023

100 101 102 103
110 111 112 113
120 121 122 123
*/
queue<Points> q;            // ������ Ž���� ��ǥ ���� ť
int box[MAX][MAX][MAX];     // �丶�� ��� �ڽ�
bool visited[MAX][MAX][MAX];// �湮����

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

// ���� �� ��ĥ�� �ɷȴ��� üũ
int getDayCount() {
    int dayCount = 0;

    for(int i = 0; i < inputZ; i++) {
        for(int j = 0; j < inputY; j++) {
            for(int k = 0; k < inputX; k++) {
                if(box[i][j][k] == 0) {
                    return -1;
                }
                // �ڽ��� ���ִ� ���ڰ� Ž���� ����==�ɸ� ��¥��� �� �� ����
                if(dayCount < box[i][j][k]) {
                    dayCount = box[i][j][k] - 1;
                }
            }
        }
    }

    return dayCount;
}

// ó������ Ž���� �丶�� ��ġ�� ã�Ƽ� ť�� �ֱ�
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

// �ٿ�� �ȿ� �ְ�, �湮 ���� Ȯ��
bool isPossible(int nextX, int nextY, int nextZ) {
    if((0 <= nextX && nextX < inputX) &&
        (0 <= nextY && nextY < inputY) &&
        (0 <= nextZ && nextZ < inputZ) &&
        !visited[nextZ][nextY][nextX]) {
            return true;
    }

    return false;
}

// �丶�� ������
void aging() {
    int moveX[] = { -1, 1, 0, 0, 0, 0 };
    int moveY[] = { 0, 0, -1, 1, 0, 0 };
    int moveZ[] = { 0, 0, 0, 0, -1, 1 };
    int x, y, z;

    while(!q.empty()) {
        // ó�� ���� ��ǥ �ְ�(������ǥ)
        x = q.front().getX();
        y = q.front().getY();
        z = q.front().getZ();
        q.pop();

        // ���� ��ǥ�� Ž��(�޿��յ����Ʒ�)
        for(int i = 0; i < 6; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            int nextZ = z + moveZ[i];

            // �ٿ�� �����̰�, �湮 ���߰�, ������ �丶�� �ɾ�������
            if(isPossible(nextX, nextY, nextZ) && box[nextZ][nextY][nextX] == 0) {
                // �湮ǥ��, ����ڽ����� 1 ���� �����ڽ��� �ְ�, ť�� ��ǥ ����
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