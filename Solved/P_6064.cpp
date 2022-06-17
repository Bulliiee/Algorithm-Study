// ī�� �޷�
#include <iostream>

using namespace std;

// �� ���� ���ϰ� �ּҰ������ ������ ������ ����
int getMaxYear(int M, int N) {
    int res = M * N;

    while(N != 0) {
        int temp = M % N;
        M = N;
        N = temp;
    }

    return res / M;
}

// ù x�� ���� ����(ù res)�̰�, �̿� �´� y�� ã�Ƽ� �ű���� Ž���Ѵ�.
// ���� x�� ���� �������� x�� �ִ밪�� M�� ���ذ��� �Ͱ� ����.(��, res�� ���� x, ���� M�� ��������)
// �׷��⿡ �׿� �˸��� y�� ���ذ��� �ȴ�.
// ù x�� �˸��� ù y�� x % N�̴�.
// ���� y�� (y + M) % N�� �þ��, ���� ���� ���� 0�̶�� y�� N���� �δ� ���ǵ� �����.(���� ����)
// (��, y�� ������ x % N, ������ (y + M) % N�� �ε�, �� ���� ���� 0�̶�� N���� �Ѵ�.)
// �׷��� y�� ���簡�� ���ϴ� ����� ��´�.
int calander(int M, int N, int x, int y) {
    int maxYear = getMaxYear(M, N);
    int ty = x % N; // ó�� x�� �´� y�� �ʱ�ȭ
    int res = x;    // ó���� x������ ����

    if(ty == 0) ty = N;

    while(res <= maxYear) {
        if(ty == y) break;

        ty = ((ty + M) % N) == 0 ? N : ((ty + M) % N);
        res += M;
    }

    return res > maxYear ? -1 : res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    cin >> input;

    for(int i = 0; i < input; i++) {
        int M, N, x, y;
        cin >> M >> N >> x >> y;

        cout << calander(M, N, x, y) << '\n';
    }

    return 0;
}