// 비밀번호 찾기
#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return ;
}

int main() {
    init(); 

    unordered_map<string, string> map;
    int n, m;   // 저장된 사이트 수, 비밀번호 찾으려는 사이트 수

    cin >> n >> m;

    string site;
    string pw;
    for(int i = 0; i < n; i++) {
        cin >> site;
        cin >> pw;
        map.insert(make_pair(site, pw));
    }
    for(int i = 0; i < m; i++) {
        cin >> site;
        cout << map[site] << '\n';
    }

    return 0;
}