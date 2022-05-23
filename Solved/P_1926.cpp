// �׸�
#include <iostream>
#include <queue>
#define MAX 500

using namespace std;

queue<pair<int, int>> q;
int height, width;
int paper[MAX][MAX];
bool visited[MAX][MAX];

// ��ǥ�� ��ȭ�� �������� Ȯ��
bool isInBound(int p1, int p2) {
    if((0 <= p1 && p1 < MAX) && (0 <= p2 && p2 < MAX)) return true;
    else return false;
}

// �湮�� ĭ ���� �׸��� ���̰� �ȴ�.
// �װ� ����
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

        // ���ʿ��������Ʒ� ����
        for(int i = 0; i < 4; i++) {
            int newP1 = curP1 + move1[i];
            int newP2 = curP2 + move2[i];

            // newP�� ��ȭ�� �����̰�, �湮���߰�, ��ĥ�Ǿ�������
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

    int count = 0;  // �׸� ����
    int max = 0;    // ���� ū �׸� ����
    int area = 0;   // bfs�� �׸� ����

    input();

    for(int i = 0; i < height; i++) {
        for(int j = 0; j < width; j++) {
            // �湮���� �ʾҰ�, ��ȭ���� ��ĥ �Ǿ������� �ű⸦ ���������� bfsŽ���Ѵ�.
            // �ѹ� bfs�� ���������� �׸��� �ִ�ũ�⸦ �����ϰ�, �׸��� ������ ������Ų��.
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