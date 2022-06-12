// AC
#include <iostream>
#include <string>
#include <sstream>
#include <deque>

using namespace std;

void getNumber(string str, deque<int> *dq) {
    string strBuffer;
    istringstream ss(str);

    while(getline(ss, strBuffer, ',')) {
        dq->push_back(stoi(strBuffer));
    }
}

// ���� ��� ����
string AC() {
    deque<int> dq;      // ���� ���� ��
    string command;     // ��ɾ� R,D
    string inputNum;    // ���� �Է�
    string result = "[";      // ���
    int numAmount;      // ���� ����
    bool flag = true;   // true: �տ��� �ڷ�, false: �ڿ��� ������
    
    cin >> command;
    cin >> numAmount;
    cin >> inputNum;

    // ó���� ������ '[', ']' �����
    inputNum.erase(inputNum.length() - 1, 1);
    inputNum.erase(0, 1);

    // �Էµ� stringŸ���� �ɰ��� int�� �迭�� �ֱ�
    getNumber(inputNum, &dq);  // Call By Reference

    for(int i = 0; i < command.length(); i++) {
        // �����´ٰ� �ϸ� �׳� �տ��� �ڷ�����, �ڿ��� ������������ �ٲ���
        if(command[i] == 'R') {
            flag = flag ? false : true;
        }
        // ���⿡ �°� ����
        else if(command[i] == 'D') {
            // ���� �������
            if(dq.empty()) {
                return "error";
            }
    
            if(flag) {
                dq.pop_front();
            }
            else {
                dq.pop_back();
            }
        }
    }

    if(!dq.empty() && flag) {
        while(!dq.empty()) {
            result.append(to_string(dq.front()) + ",");
            dq.pop_front();
        }
        result.erase(result.size() - 1, 1);
    }
    else if(!dq.empty() && !flag) {
        while(!dq.empty()) {
            result.append(to_string(dq.back()) + ",");
            dq.pop_back();
        }
        result.erase(result.size() - 1, 1);
    }

    result.append("]");

    return result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while(T--) {
        cout << AC() << '\n';
    }

    return 0;
}