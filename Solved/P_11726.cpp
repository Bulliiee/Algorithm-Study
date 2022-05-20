// 2xn 타일링
#include <iostream>
#include <vector>
#define MAX 1001    // 1번부터 사용

using namespace std;

vector<int> dp(MAX, 0);

// 처음 세로짝대기로 시작, 이후 남은걸 이전껄로 채운다.
// 근데 n이 3인 경우부터 세로짝대기 가장 왼쪽에 하나 넣는다고 치고
// 2x2를 채운다. 그렇다면 2의 경우의 수만큼이 필요하고,
// 가로짝대기를 가장 왼쪽에 2개 넣으면 2x1을 채워야한다.
// 그렇다면 1의 경우의 수만큼이 더 필요하다.
// 결국 2xn의 크기의 경우 2x(n-1)경우와 2x(n-2)경우를 더한 것이 된다.
// 즉, n = 1인 경우는 | 1개
// n = 2인 경우는 ||, = 로 2개
// n = 3인 경우는 가장 왼쪽을 |로 채우면 n = 2인경우의 수만큼 필요,
// 가장 왼쪽을 =로 채우면 n = 1인 경우의 수만큼 필요, 두 경우를 더한 것이 답이다.
int tiling(int num) {
    if(dp[num] != 0) {
        return dp[num];
    }

    return dp[num] = (tiling(num - 1) + tiling(num - 2)) % 10007;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    cin >> input;

    // 1인경우는 세로짝대기 1개로 방법 수는 1, 2인경우는 세로2개 가로2개로 방법 수는 2
    dp[1] = 1;
    dp[2] = 2;

    cout << tiling(input) << '\n';

    return 0;
}