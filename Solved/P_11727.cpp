// 2xn 타일링 2
#include <iostream>

#define MAX 1001    // 인덱스 1부터 시작

using namespace std;
int dp[MAX] = { 0, 1, 3, };

int getCaseNum(int n) {
    if(dp[n] != 0) {
        return dp[n];
    }

    // 2 x n 직사각형을 채우는 방법의 수가 P(n)이라고 하면
    // 점화식은 P(n) = P(n - 1) + (2 * P(n - 2))이다.
    // (P_11726 2xn 타일링 참고)
    // 왜냐하면 예를 들어 n = 3인 경우
    // |하나를 맨 왼쪽에 둔다고 하면 2x2가 남으므로 n = 2인 경우의 수가 필요하고
    // =와 ㅁ을 맨 왼쪽에 둔다고 하면 2x1이 남기에 두가지가 각각 들어갈 경우의 수
    // 즉, =|, ㅁ| 경우가 필요하므로 n = 1인 경우의 수 * 2가지가 필요하다.
    // ||를 빼는 이유는 n = 2인경우에서 겹치기 때문이다.
    
    // 이미 들어있는 값들은 10007로 나눈 나머지이기에 전체 계산하고 나머지 계산만 해준다.
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