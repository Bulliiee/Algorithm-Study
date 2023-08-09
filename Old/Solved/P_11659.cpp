// ���� �� ���ϱ� 4
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    int *arrN;
    int *result;

    cin >> N >> M;
    arrN = new int[N];
    result = new int[M + 1];    // �ε��� 0�� 0�ְ�, 1���� �Էµ� ���ڵ� ���� �� ����
    
    result[0] = 0;
    for(int i = 0; i < N; i++) {
        cin >> arrN[i];
        result[i + 1] = arrN[i] + result[i];
    }
    for(int i = 0; i < M; i++) {
        int start, end;
        cin >> start >> end;
        // ���� �� �迭���� �������ε��� �� - (�����ε���-1 ��) �ϸ� �������� ���� ���´�
        cout << result[end] - result[start - 1] << '\n';
    }

    delete[] arrN;
    delete[] result;

    return 0;
}