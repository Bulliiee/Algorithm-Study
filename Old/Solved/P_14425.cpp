// 문자열 집합
#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    map<string, bool> str_map;
    int n, m;
    int count = 0;
    cin >> n >> m;

    for(int i = 0; i < n; i++) {
        string temp;
        cin >> temp;
        str_map[temp] = true;
    }

    for(int i = 0; i < m; i++) {
        string temp;
        cin >> temp;
        if(str_map[temp])   // 내용물 없으면 false리턴?
            count++;
    }

    cout << count;

    return 0;
}