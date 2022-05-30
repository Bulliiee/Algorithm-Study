// 시험 점수
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int res1 = 0;
    int res2 = 0;

    for (int j = 0; j < 4; j++) {
        int temp;
        cin >> temp;
        res1 += temp;
    }
    for (int j = 0; j < 4; j++) {
        int temp;
        cin >> temp;
        res2 += temp;
    }

    int t;
    if(res1 >= res2) {
        t = res1;
    }
    else {
        t = res2;
    }
    cout << t;

    return 0;
}