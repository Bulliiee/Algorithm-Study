// 1로 만들기
#include <iostream>
#include <algorithm>

using namespace std;

// 인덱스0은 제외(인덱스랑 숫자랑 맞추기 위해서)
// 1은 그대로니까 연산횟수 0
// 2는 연산 2또는 3 해서 연산횟수 1
// 3은 연선1 해서 연산횟수 1

int dp[1000001] = {0, 0, 1, 1, };

int makeOne(int num) {
    if(num <= 3) {
        return dp[num];
    }
    // 1, 2, 3 연산 다 하고 가장 작은 값 dp에 넣기
    // 1, 2, 3번연산 각각 바텀 업 방식으로 작은 값에서부터 채워감
    // 탑다운 방식으로 하면 시간초과 남(재귀연산)
    // +1 하는 이유는 한 번 연산한걸로 쳐야하니까
    // 3번연산부터 하는 이유는 dp[i]가 초기에 값이 0이라서 먼저 지정하기 위함
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