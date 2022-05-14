// DFS�� BFS
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
#define MAX 1001    // �������� �ִ� 1000��

int map[MAX][MAX];  // ������ȣ, ������ ����Ű�� ��ȣ
bool visited[MAX];  // ������ȣ�� �湮 ����
int vertexSize;
queue<int> q;       // bfs�� ť

void dfs(int curVertexNum) {
    visited[curVertexNum] = true;

    cout << curVertexNum << ' ';

    // ���� Ž���� ������ ���� ���� �������� ������ŭ �ݺ� Ž��
    for(int i = 1; i <= vertexSize; i++) {
        // ���� ������ ����Ű�� ��������(i)�� �湮���� ���� �����̶��
        // dfs�� ���ȣ���Ͽ� ����Ž���� ��
        if(map[curVertexNum][i] == 1 && visited[i] == false) {
            dfs(i);
        }
    }
}

void bfs(int curVertexNum) {
    // ���� ���� ���� �湮 üũ ��
    // ť�� ���� ���� ����
    visited[curVertexNum] = true;
    q.push(curVertexNum);

    cout << curVertexNum << ' ';

    // ť�� �������� �ݺ�
    while(!q.empty()) {
        // ���� ������ ���� �������� ���� ��
        // ť���� ����
        curVertexNum = q.front();
        q.pop();

        // ���� ������ ����Ű�� ���� ������ �� �������� �ݺ�
        for(int i = 1; i <= vertexSize; i++) {
            // ���� ������ ����Ű�� ���� ����(i)�� �湮���� ���� �����̶��
            // �湮üũ �� ť�� ����
            if(map[curVertexNum][i] == 1 && visited[i] == 0) {
                visited[i] = true;
                q.push(i);
                cout << i << ' ';
            }
        }
    }
}

void reset(int vertexNum) {
    for(int i = 1; i <= vertexNum; i++) {
        visited[i] = false;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // ����, ����, ����������ȣ
    int vertexNum, edgeNum, startVertexNum;
    int tempV1, tempV2;

    cin >> vertexNum >> edgeNum >> startVertexNum;
    vertexSize = vertexNum;

    for(int i = 0; i < edgeNum; i++) {
        cin >> tempV1 >> tempV2;

        map[tempV1][tempV2] = 1;
        map[tempV2][tempV1] = 1;
    }

    dfs(startVertexNum);
    cout << '\n';

    reset(vertexNum);
    bfs(startVertexNum);

    return 0;
}