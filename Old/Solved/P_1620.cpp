// ���¾� ���ϸ� ������ �̴ټ�
// unordered_map ���
#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

unordered_map<int, string> isPokemon;
unordered_map<string, int> siPokemon;

bool isNum(string str) {
    for(char c : str) {
        if(isdigit(c) == 0) {   // ���ڰ� �ƴϸ�
            return false;
        }
    }
    // ���ڸ�
    return true;
}

void getAnswer(string question) {
    if(isNum(question)) {
        cout << isPokemon[stoi(question)] << '\n';
    }
    else {
        cout << siPokemon[question] << '\n';
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;   // ���ϸ� ����, ���� ����
    int index = 1;

    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        string name;
        cin >> name;
        isPokemon.insert(make_pair(index, name));
        siPokemon.insert(make_pair(name, index));
        index++;
    }

    for(int i = 0; i < m; i++) {
        string question;
        cin >> question;

        getAnswer(question);
    }

    return 0;
}