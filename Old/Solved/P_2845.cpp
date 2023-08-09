// 파티가 끝나고 난 뒤
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> v(5);
    int l, p;
    int temp;

    cin >> l >> p;
    temp = l * p;

    for(int i = 0; i < 5; i++) {
        cin >> v[i];
    }

    for(int i = 0; i < 5; i++) {
        cout << v[i] - temp << ' ';
    }

    return 0;
}