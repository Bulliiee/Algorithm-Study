// 심부름 가는 길
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int res = 0;
    int temp;

    for(int i = 0; i < 4; i++) {
        cin >> temp;
        res += temp;
    }

    cout << res / 60 << '\n' << res % 60;

    return 0;
}