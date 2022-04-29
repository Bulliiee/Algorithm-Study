// 계단 오르기
#include <iostream>
#include <vector>

using namespace std;

int stair[301];
int dp[301];

int MAX(int a, int b) { if(a > b) { return a; } return b; }

// 계단 갯수만 받음
// 탑 바텀 방식
int getMaxPoint(int input) {
    dp[1] = stair[1];
    dp[2] = stair[1] + stair[2];
    dp[3] = MAX(stair[1] + stair[3], stair[2] + stair[3]);

    for(int i = 4; i <= input; i++) {
        // 인덱스가 1 2 3 4라고 할 때 4의 dp를 구한다면,
        // 2까지 최대, 4의 계단점수로 두칸 건너뛰는 점수 합과(3은 3개 연속 돼서 안됨)
        // 1까지 최대, 3, 4의 계단점수로 건너가는 점수 합을 비교한다.
        // 어차피 이렇게 하면 4까지 가는데에 1칸을 건넌것이 되므로
        // 다음 계단으로 갈 때 따로 카운트를 셀 필요가 없다.
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