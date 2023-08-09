// ���� ����� ����
#include <iostream>
#include <vector>
#include <queue>
#define MAX 1001    // ���� 1���� ����

using namespace std;

bool map[MAX][MAX];
bool visited[MAX] = {false};   // ���� �湮����
int vNum, eNum;                // ����, ���� ����

void dfs(int vertex) {
    visited[vertex] = true;

    for(int i = 1; i <= vNum; i++) {
        // ���̿켱 Ž��, ���� �������� ����� ��� ���� �� üũ�ϸ� �湮�������� ��� ����.
        if(map[vertex][i] == true && !visited[i]) {
            dfs(i);
        }
    }
}

int getConnectedComponent() {
    int count = 0;

    // �����ϴ� ���� ��� �� ���������� Ž���Ѵ�.
    for(int i = 1; i <= vNum; i++) {
        if(!visited[i]) {
            count++;
            dfs(i);
        }
    }

    return count;
}

void input() {
    cin >> vNum >> eNum;

    for(int i = 0; i < eNum; i++) {
        int t1, t2;
        cin >> t1 >> t2;

        map[t1][t2] = true;
        map[t2][t1] = true;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // �Է¹ޱ�
    input();

    // ���� �� ���
    cout << getConnectedComponent();

    return 0;
}