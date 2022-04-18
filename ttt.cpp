// 테스트용
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    char a[10];

    cin.get(a, 10, '.');    

    cout << a << '\n';

    return 0;
}