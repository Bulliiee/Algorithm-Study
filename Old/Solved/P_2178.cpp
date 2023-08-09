// �̷� Ž��
#include <iostream>
#include <string>
#include <queue>

#define MAX 100

using namespace std;

int n, m;               // �̷� ũ��
int map[MAX][MAX];      // �̷� 2���� �迭
int dist[MAX][MAX];     // Ž���Ÿ�
bool visited[MAX][MAX]; // �湮Ȯ�� 2���� �迭
// int count = 0;  // Ž���Ÿ�
queue<pair<int, int>> q;    // Ž���� ��ǥ ���� while������ ���

void searchMaze(int row, int column) {
    // �����¿�� ��ǥ 1�� ������Ű�� ����
    // ���� �ε����� ��, ���� �ε��� 0�̶��
    // row�� 0, col�� -1�� �������� ������ǥ�� �� ĭ ���� ���̰�
    // ���� �ε��� 2���
    // row�� -1, col�� 0�� �������� ������ǥ�� �� ĭ ���� ���̴�.
    int xMove[] = {0, 0, -1, 1};
    int yMove[] = {-1, 1, 0, 0};

    // [0][0] �湮 �� ���� üũ
    visited[row][column] = true;
    q.push(make_pair(row, column));     // pair ���� �� make_pare()
    dist[row][column]++;
    // count++;

    while(!q.empty()) {
        // ������ǥ ����
        int r = q.front().first;    // pair ���� �� .first, .second
        int c = q.front().second;

        q.pop();

        // �����¿�� ��ǥ 1�� ����, ���ҽ��Ѽ� �ϳ��� ����.
        // �湮���� �ʾҰ�, �� �� �ִ� ���̶��(map[][]�� ���� 1)
        // ť�� �ְ� �Ÿ��� ������Ų��.
        for(int i = 0; i < 4; i++) {
            int nextR = r + yMove[i];
            int nextC = c + xMove[i];

            // ������ Ž���� ���ο� ��ǥ tempR, tempC�� �� �� �ִ� ��ǥ���� Ȯ��
            // if���� and�����θ� �̷�����⿡ ������ �߿��ϴ�.
            // nextR, nextC�� ��ǥ�� ����� �ʾҴ��� ���� üũ�ؾ� �湮���ο� �� �� �ִ��� ���θ� Ȯ���� �� �ִ�.
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
    // 2���� �̷� ��� �׽�Ʈ
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