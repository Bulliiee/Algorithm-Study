// ���ٲ���
#include <iostream>
#include <vector>
#include <queue>
#define MAX 100001

using namespace std;

int getBro(int n, int k) {
    // ������ġ, �ɸ��ð� ��
    queue<pair<int, int>> q;
    // Ž���ߴ� ��찡 ������(true) ���� Ž�� ���ϰ� �ϱ� ����    
    bool visited[MAX] = { false };  
    int sec = 0;

    q.push(make_pair(n, 0));

    // int i = 0;
    while(!q.empty()) {
        // ť���� ������ ������ ������ġ�� �ɸ� �ð� ����
        int subin = q.front().first;
        int time = q.front().second;
        q.pop();
        // cout << "count: " << i++ << " \\ " << subin << ", " << time << endl;

        // �����̰� ���� �������
        if(subin == k) {
            // ť���� ��� ���� �ð� �״�� ��ȯ
            sec = time;
            break;
        }

        // ������ ��ǥ 3���� ��� ���� üũ
        // -1�ϴ� ���� 0���� �۾����� �ȵǰ�, �湮 ���� ��쿡
        // �湮�ߴٰ� üũ�ϰ� ť�� �ɸ� �ð� ����
        if(0 <= subin - 1 && !visited[subin - 1]) {
            visited[subin - 1] = true;
            q.push(make_pair(subin - 1, time + 1));
        }
        // +1�ϴ� ���� �ִ� �Ÿ��� 100000���� �۰ų� ���ƾ� ��
        if(subin + 1 < MAX && !visited[subin + 1]) {
            visited[subin + 1] = true;
            q.push(make_pair(subin + 1, time + 1));
        }
        // *2�ϴ� ��쵵 �ִ� �Ÿ��� 100000���� �۰ų� ���ƾ� ��
        if(subin * 2 < MAX && !visited[subin * 2]) {
            visited[subin * 2] = true;
            q.push(make_pair(subin * 2, time + 1));
        }
    }

    return sec;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;   // ������ ��ġ, ���� ��ġ
    cin >> n >> k;

    cout << getBro(n, k);

    return 0;
}