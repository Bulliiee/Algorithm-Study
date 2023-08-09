// �丶��
#include <iostream>
#include <vector>
#include <queue>
#define MAX 1000

using namespace std;

int width, height;      // �丶��ڽ� ũ��
int dayCount = 0;       // �;�� ��¥
int box[MAX][MAX];      // �ڽ�
bool visited[MAX][MAX]; // �湮����

queue<pair<int, int>> startQ;
queue<pair<int, int>> q;    // ������ �湮�� �� ��ǥ ť

// �Է¹ޱ�
void input() {
    cin >> width >> height;
    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            cin >> box[i][j];
        }
    }
}

// �׽�Ʈ�� ���
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

// �湮���� ���� �丶�䰡 �ִ� ���, �װ��� ���������� ���� ����(q�� ����)
// �湮�Ұ� ���������� true, �ƴϸ� false;
void getTomatoStartPoint() {
    // bool flag = false;

    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            // �丶�䰡 �;���, �湮���� �ʾҴٸ�
            if(box[i][j] == 1 && visited[i][j] == false) {
                // ť�� Ž���� �丶��� ����
                q.push(make_pair(i, j));
                // �湮�Ұ� ���Ҵٰ� ǥ������
                // flag = true;
            }
        }
    }

    // return flag;
}

// ����ĭ �˻� �� �ڽ� ũ�� ������� üũ
bool isOnBound(int nextRow, int nextCol) {
    return (0 <= nextRow && nextRow < height) && (0 <= nextCol && nextCol < width);
}

// ������ ��ǥ
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

// �����µ� ������ �丶�� �ִ��� �˻�
// �� ������ true����, �ȵ����� false����
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