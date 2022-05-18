// ���̷���
#include <iostream>
#define MAX 101     // 1������ ���

using namespace std;

bool map[MAX][MAX] = { false };
bool visited[MAX] = { false };
int inputVertex, inputEdge;
int count = 0;

void dfs(int curVertex) {
    count++;
    visited[curVertex] = true;  // �湮���� ���� ��ǻ���� ��� visited�� �湮�ߴٰ� ���

    // 1������ �����ϴ� ��ǻ�� ������ŭ �ݺ�
    for(int i = 1; i <= inputVertex; i++) {
        // ���� ��ǻ�Ϳ� i�� ����Ǿ��ְ�, �װ� �湮���� ���� ���̸�
        if(map[curVertex][i] == 1 && !visited[i]) {
            dfs(i);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    cin >> inputVertex >> inputEdge;

    for(int i = 0; i < inputEdge; i++) {
        int t1, t2;
        cin >> t1 >> t2;

        map[t1][t2] = map[t2][t1] = true;
    }

    dfs(1);

    cout << count - 1;

    return 0;
}