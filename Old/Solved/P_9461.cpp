// 파도반 수열
#include <iostream>

#define MAX 101 // 인덱스 1부터 시작
#define ull unsigned long long

using namespace std;

ull dp[MAX] = { 0, 1, 1, 1, 2, 2, };

ull getPN(int n) {
    if(dp[n] != 0) {
        return dp[n];
    }

    dp[n] = getPN(n - 1) + getPN(n - 5);
    
    return dp[n];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int caseNum;
    cin >> caseNum;

    for(int i = 0; i < caseNum; i++) {
        int n;
        cin >> n;
        cout << getPN(n) << '\n';
    }

    return 0;
}