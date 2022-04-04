// ios_base :: sync_with_stdio(false);
// cin.tie(NULL);
// 테스트용
#include <iostream>

using namespace std;

int main() {
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    
    int rep;
    int a, b;

    cin >> rep;
    for(int i = 0; i < rep; i++) {
        cin >> a >> b;
        cout << a + b << '\n';
    }

    return 0;
}