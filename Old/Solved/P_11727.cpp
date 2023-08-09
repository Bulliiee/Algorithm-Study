// 2xn Ÿ�ϸ� 2
#include <iostream>

#define MAX 1001    // �ε��� 1���� ����

using namespace std;
int dp[MAX] = { 0, 1, 3, };

int getCaseNum(int n) {
    if(dp[n] != 0) {
        return dp[n];
    }

    // 2 x n ���簢���� ä��� ����� ���� P(n)�̶�� �ϸ�
    // ��ȭ���� P(n) = P(n - 1) + (2 * P(n - 2))�̴�.
    // (P_11726 2xn Ÿ�ϸ� ����)
    // �ֳ��ϸ� ���� ��� n = 3�� ���
    // |�ϳ��� �� ���ʿ� �дٰ� �ϸ� 2x2�� �����Ƿ� n = 2�� ����� ���� �ʿ��ϰ�
    // =�� ���� �� ���ʿ� �дٰ� �ϸ� 2x1�� ���⿡ �ΰ����� ���� �� ����� ��
    // ��, =|, ��| ��찡 �ʿ��ϹǷ� n = 1�� ����� �� * 2������ �ʿ��ϴ�.
    // ||�� ���� ������ n = 2�ΰ�쿡�� ��ġ�� �����̴�.
    
    // �̹� ����ִ� ������ 10007�� ���� �������̱⿡ ��ü ����ϰ� ������ ��길 ���ش�.
    return dp[n] = (getCaseNum(n - 1) + (2 * getCaseNum(n - 2))) % 10007;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    cout << getCaseNum(n);

    return 0;
}