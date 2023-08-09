// Four Squares
// DP(Dynamic Programming)���� ���� �ذ��ϱ�
#include <iostream>
#include <cmath>

using namespace std;

// �ε����� ���ڶ� ������ 50001��
int dp[50001] = { 0 };

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return ;
}

int getSqareNum(int num) {
    int minCount;
    int index;
    dp[1] = 1;

    for(int i = 2; i <= num; i++) {
        minCount = 0x7f7f7f7f;

        for(int j = 1; pow(j, 2) <= i; j++) {
            index = i - pow(j, 2);

            minCount = dp[index] < minCount ? dp[index] : minCount;
        }

        dp[i] = minCount + 1;
    }

    return dp[num];
}

int main() {
    init();
    int input;

    cin >> input;

    cout << getSqareNum(input) << '\n';

    return 0;
}