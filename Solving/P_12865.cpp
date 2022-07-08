// 평범한 배낭
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define FASTIO ios_base::sync_with_stdio(false), cin.tie(NULL)
#define OBJECT_MAX 101
#define WEIGHT_MAX 100001  // 0번 안씀

// 페어는 무게, 가치 쌍임
vector<pair<int, int>> objs(OBJECT_MAX, make_pair(0, 0));
// [물건 번호][가방크기] = 가치 합
int dp[OBJECT_MAX][WEIGHT_MAX];

int main() {
    FASTIO;

    int objAmount, bagWeight;

    cin >> objAmount >> bagWeight;
    for(int i = 1; i <= objAmount; i++) {
        int tempWeight, tempValue;
        cin >> tempWeight >> tempValue;
        objs[i] = make_pair(tempWeight, tempValue);
    }

    // 준서가 버틸 무게는 1부터 시작
    for(int i = 1; i <= objAmount; i++) {
        for(int j = 1; j <= bagWeight; j++) {
            // 점화식 dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
            // 
            if((j - objs[i].first) >= 0) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - objs[i].first] + objs[i].second);
            }
            else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    // for(auto iter: objs) {
    //     cout << iter.first << ", " << iter.second << '\n';
    // }

    // for(int i = 1; i <= objAmount; i++) {
    //     for(int j = 1; j <= bagWeight; j++) {
    //         cout << dp[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }

    cout << dp[objAmount][bagWeight];



    return 0;
}