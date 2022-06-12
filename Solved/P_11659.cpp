// 구간 합 구하기 4
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    int *arrN;
    int *result;

    cin >> N >> M;
    arrN = new int[N];
    result = new int[M + 1];    // 인덱스 0은 0넣고, 1부터 입력된 숫자들 누적 합 넣음
    
    result[0] = 0;
    for(int i = 0; i < N; i++) {
        cin >> arrN[i];
        result[i + 1] = arrN[i] + result[i];
    }
    for(int i = 0; i < M; i++) {
        int start, end;
        cin >> start >> end;
        // 누적 합 배열에서 마지막인덱스 값 - (시작인덱스-1 값) 하면 범위안의 합이 나온다
        cout << result[end] - result[start - 1] << '\n';
    }

    delete[] arrN;
    delete[] result;

    return 0;
}