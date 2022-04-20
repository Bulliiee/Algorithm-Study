// ����
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;
vector<int>::iterator iter;

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}

void command(string com) {
    int param;

    if(com == "add") {
        cin >> param;

        v.push_back(param);
    }
    else if(com == "remove") {
        cin >> param;

        v.erase(remove(v.begin(), v.end(), param), v.end());
    }
    else if(com == "check") {
        cin >> param;

        // #include <algorithm>, find�޼ҵ�
        iter = find(v.begin(), v.end(), param);
        if(iter != v.end()) {   // ã������
            cout << "1\n";
        }
        else {                  // ��ã������
            cout << "0\n";
        }
    }
    else if(com == "toggle") {
        cin >> param;

        iter = find(v.begin(), v.end(), param);
        if(iter != v.end()) {   // ã������ ����
            v.erase(remove(v.begin(), v.end(), param), v.end());
        }
        else {                  // ��ã������ ����
            v.push_back(param);
        }
    }
    else if(com == "all") {
        v.clear();
        for(int i = 1; i <= 20; i++) {
            v.push_back(i);
        }
    }
    else if(com == "empty") {
        v.clear();
    }
}

int main() {
    init();
    int input;
    string inputCommand;

    cin >> input;
    while(input--) {
        cin >> inputCommand;
        command(inputCommand);
    }

    return 0;
}