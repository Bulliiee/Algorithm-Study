// 대칭 차집합
#include <iostream>
#include <map>

#define FASTIO ios_base::sync_with_stdio(false), cin.tie(NULL);

using namespace std;

int main() {
    FASTIO

    map<int, bool> m;
    int aNum, bNum;
    int count = 0;

    cin >> aNum >> bNum;

    for(int i = 0; i < aNum; i++) {
        int temp;
        cin >> temp;
        m[temp] = true;
    }

    for(int i = 0; i < bNum; i++) {
        int temp;
        cin >> temp;
        if(m[temp] == true) m[temp] = false;
        else m[temp] = true;
    }

    for(auto it : m) {
        if(it.second == true) count++;
    }
    cout << count;

    return 0;
}