// 1�� �����
#include <iostream>
#include <algorithm>

using namespace std;

// �ε���0�� ����(�ε����� ���ڶ� ���߱� ���ؼ�)
// 1�� �״�δϱ� ����Ƚ�� 0
// 2�� ���� 2�Ǵ� 3 �ؼ� ����Ƚ�� 1
// 3�� ����1 �ؼ� ����Ƚ�� 1

int dp[1000001] = {0, 0, 1, 1, };

int makeOne(int num) {
    if(num <= 3) {
        return dp[num];
    }
    // 1, 2, 3 ���� �� �ϰ� ���� ���� �� dp�� �ֱ�
    // 1, 2, 3������ ���� ���� �� ������� ���� ���������� ä����
    // ž�ٿ� ������� �ϸ� �ð��ʰ� ��(��Ϳ���)
    // +1 �ϴ� ������ �� �� �����Ѱɷ� �ľ��ϴϱ�
    // 3��������� �ϴ� ������ dp[i]�� �ʱ⿡ ���� 0�̶� ���� �����ϱ� ����
    else {
        for(int i = 4; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;

            if((i % 3) == 0) {
                dp[i] = min(dp[i], dp[i / 3] + 1);
            }

            if((i % 2) == 0) {
                dp[i] = min(dp[i], dp[i / 2] + 1);
            }
        }
    }

    return dp[num];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int num;
    cin >> num;

    cout << makeOne(num);

    return 0;
}