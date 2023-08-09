// Å·, Äý, ·è, ºñ¼ó, ³ªÀÌÆ®, Æù
#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int king, queen, l, b, k, p;

    cin >> king >> queen >> l >> b >> k >> p;

    cout << 1-king << ' ' << 1-queen << ' ' << 2-l << ' ' << 2-b << ' ' << 2-k << ' ' << 8-p;

    return 0;
}