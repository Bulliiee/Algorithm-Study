// ����� ����
#include <iostream>
#include <vector>
#include <queue>
#include <memory.h>
#define MAX 51  // 1���� ����

using namespace std;

int map[MAX][MAX] = { 0 };          // ���� ����ִ��� ǥ�� 
bool visited[MAX][MAX] = { false }; // �湮 ����
vector<pair<int, int>> v;           // ���� �ִ� ��ǥ ���
queue<pair<int, int>> q;            // ���� Ž���� ��ǥ�� ���� ť


// map�� visited�迭 �ʱ�ȭ
void init() {
    // 0, -1�� �ʱ�ȭ��ų ��� memset�� fill���� �� �����⿡ �̰ɷ� �Ѵ�.
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

    // ���� ��ǥ �����ִ°Ÿ� ���������� Ž���Ѵ�.
    while(!v.empty()) {
        curX = v.back().first;
        curY = v.back().second;
        v.pop_back();

        // �湮�� �ߴ� ���� ��ǥ��� �ٽ� �ö󰡼� ��ǥ �̾ƿ�
        if(visited[curX][curY]) {
            continue;
        }

        // �湮 ���ߴٸ� �Ʒ��� ����
        visited[curX][curY] = true;
        q.push(make_pair(curX, curY));
        count++;

        // ���� ��ǥ �������� �̾����͵� �� üũ
        while(!q.empty()) {
            curX = q.front().first;
            curY = q.front().second;
            q.pop();

            // ����, ������, ��, �Ʒ� �����̸� �̾��� ���ߵ� üũ
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

    int testCase;                   // �׽�Ʈ���̽� ��
    int width, height, pointAmount; // ����, ����, ���� �ɾ��� ��ġ ����

    cin >> testCase;
    while(testCase--) {
        init();     // �Է� �ޱ� �� �ʱ�ȭ
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