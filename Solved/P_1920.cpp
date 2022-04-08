// ¼ö Ã£±â
#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    unordered_map<int, int> map;
    int n, m;
    int key;

    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> key;
        map[key] = 1;
    }

    cin >> m;
    for(int i = 0; i < m; i++) {
        cin >> key;
        cout << map[key] << ' ';
    }

    return 0;
}