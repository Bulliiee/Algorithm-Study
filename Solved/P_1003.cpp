// 피보나치 함수
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
    0의 갯수는 1의 갯수를 기준으로 하나씩 밀면 그와 같다.
    그리고 1의 갯수는 입력값의 피보나치 수와 같다.
    예를 들어
    입력값  피보    0갯수   1갯수
    0       0       1       0
    1       1       0       1
    2       1       1       1
    3       2       1       2
    4       3       2       3
    5       5       3       5

    그래서 dp의 인덱스는 입력값, 
    입력값의 1갯수는 입력값에 대한 피보나치 수와 같음, 
    입력값의 0갯수는 인덱스 - 1과 같음이 된다.
*/

int fibonacci(int num) {
    if(num <= 1) {
        return dp[num];
    }
    // dp값이 입력되지 않았다면
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
        // 0, 1이 입력된 경우 dp 인덱스 벗어나니까
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