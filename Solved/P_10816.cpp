// 숫자 카드 2
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    unordered_map<int, int> m;
    int inputN, inputM;
    int key;
    
    cin >> inputN;
    for(int i = 0; i < inputN; i++) {
        cin >> key;
        m[key]++;
    }

    cin >> inputM;
    for(int i = 0; i < inputM; i++) {
        cin >> key;
        cout << m[key] << ' ';
    }

    return 0;
}