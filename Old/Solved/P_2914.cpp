// 저작권
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int songNum;
    int melodyNum;
    int avg;

    cin >> songNum >> avg;

    melodyNum = songNum * (avg - 1);
    melodyNum++;    // 정수니까 1만 올려줘도 됨

    cout << melodyNum;
}