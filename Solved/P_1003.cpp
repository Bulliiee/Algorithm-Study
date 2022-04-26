// �Ǻ���ġ �Լ�
#include <iostream>
#include <vector>

using namespace std;

int dp[41] = { 0, 1, };

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return ;
}

/*
    0�� ������ 1�� ������ �������� �ϳ��� �и� �׿� ����.
    �׸��� 1�� ������ �Է°��� �Ǻ���ġ ���� ����.
    ���� ���
    �Է°�  �Ǻ�    0����   1����
    0       0       1       0
    1       1       0       1
    2       1       1       1
    3       2       1       2
    4       3       2       3
    5       5       3       5

    �׷��� dp�� �ε����� �Է°�, 
    �Է°��� 1������ �Է°��� ���� �Ǻ���ġ ���� ����, 
    �Է°��� 0������ �ε��� - 1�� ������ �ȴ�.
*/

int fibonacci(int num) {
    if(num <= 1) {
        return dp[num];
    }
    // dp���� �Էµ��� �ʾҴٸ�
    if(dp[num] == 0) {
        dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
    }
    
    return dp[num];
}

int main() {
    init();

    int input;
    int num;
    cin >> input;

    for(int i = 0; i < input; i++) {
        cin >> num;
        // 0, 1�� �Էµ� ��� dp �ε��� ����ϱ�
        if(num == 0) {
            cout << 1 << ' ' << 0 << '\n';
        }
        else if(num == 1) {
            cout << 0 << ' ' << 1 << '\n';
        }
        else {
            cout << fibonacci(num - 1) << ' ' << fibonacci(num) << '\n';
        }
    }


    return 0;
}