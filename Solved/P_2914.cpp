// ���۱�
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
    melodyNum++;    // �����ϱ� 1�� �÷��൵ ��

    cout << melodyNum;
}