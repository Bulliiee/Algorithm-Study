// ��й�ȣ ã��
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
    int n, m;   // ����� ����Ʈ ��, ��й�ȣ ã������ ����Ʈ ��

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