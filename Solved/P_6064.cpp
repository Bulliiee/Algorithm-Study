// 카잉 달력
#include <iostream>

using namespace std;

// 두 연도 곱하고 최소공배수로 나누면 마지막 해임
int getMaxYear(int M, int N) {
    int res = M * N;

    while(N != 0) {
        int temp = M % N;
        M = N;
        N = temp;
    }

    return res / M;
}

// 첫 x가 시작 연도(첫 res)이고, 이에 맞는 y를 찾아서 거기부터 탐색한다.
// 같은 x는 시작 연도부터 x의 최대값인 M을 더해가는 것과 같다.(즉, res는 초항 x, 공차 M인 등차수열)
// 그렇기에 그에 알맞은 y를 구해가면 된다.
// 첫 x에 알맞은 첫 y는 x % N이다.
// 이후 y는 (y + M) % N씩 늘어나며, 만약 더한 값이 0이라면 y를 N으로 두는 조건도 생긴다.(초항 포함)
// (즉, y의 초항은 x % N, 공차는 (y + M) % N로 두되, 그 값이 각각 0이라면 N으로 한다.)
// 그렇게 y를 맞춰가며 원하는 결과를 얻는다.
int calander(int M, int N, int x, int y) {
    int maxYear = getMaxYear(M, N);
    int ty = x % N; // 처음 x에 맞는 y로 초기화
    int res = x;    // 처음은 x연도로 시작

    if(ty == 0) ty = N;

    while(res <= maxYear) {
        if(ty == y) break;

        ty = ((ty + M) % N) == 0 ? N : ((ty + M) % N);
        res += M;
    }

    return res > maxYear ? -1 : res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    cin >> input;

    for(int i = 0; i < input; i++) {
        int M, N, x, y;
        cin >> M >> N >> x >> y;

        cout << calander(M, N, x, y) << '\n';
    }

    return 0;
}