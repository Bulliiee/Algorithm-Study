// ��� ������
#include <iostream>
#include <vector>

using namespace std;

int stair[301];
int dp[301];

int MAX(int a, int b) { if(a > b) { return a; } return b; }

// ��� ������ ����
// ž ���� ���
int getMaxPoint(int input) {
    dp[1] = stair[1];
    dp[2] = stair[1] + stair[2];
    dp[3] = MAX(stair[1] + stair[3], stair[2] + stair[3]);

    for(int i = 4; i <= input; i++) {
        // �ε����� 1 2 3 4��� �� �� 4�� dp�� ���Ѵٸ�,
        // 2���� �ִ�, 4�� ��������� ��ĭ �ǳʶٴ� ���� �հ�(3�� 3�� ���� �ż� �ȵ�)
        // 1���� �ִ�, 3, 4�� ��������� �ǳʰ��� ���� ���� ���Ѵ�.
        // ������ �̷��� �ϸ� 4���� ���µ��� 1ĭ�� �ǳͰ��� �ǹǷ�
        // ���� ������� �� �� ���� ī��Ʈ�� �� �ʿ䰡 ����.
        dp[i] = MAX(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
    }

    return dp[input];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    cin >> input;

    for(int i = 1; i <= input; i++) {
        cin >> stair[i];
    }

    cout << getMaxPoint(input);

    return 0;
}