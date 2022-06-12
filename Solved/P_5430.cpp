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

// 연산 결과 리턴
string AC() {
    deque<int> dq;      // 숫자 담을 덱
    string command;     // 명령어 R,D
    string inputNum;    // 숫자 입력
    string result = "[";      // 결과
    int numAmount;      // 숫자 갯수
    bool flag = true;   // true: 앞에서 뒤로, false: 뒤에서 앞으로
    
    cin >> command;
    cin >> numAmount;
    cin >> inputNum;

    // 처음과 마지막 '[', ']' 지우기
    inputNum.erase(inputNum.length() - 1, 1);
    inputNum.erase(0, 1);

    // 입력된 string타입을 쪼개서 int형 배열에 넣기
    getNumber(inputNum, &dq);  // Call By Reference

    for(int i = 0; i < command.length(); i++) {
        // 뒤집는다고 하면 그냥 앞에서 뒤로일지, 뒤에서 앞으로일지만 바꿔줌
        if(command[i] == 'R') {
            flag = flag ? false : true;
        }
        // 방향에 맞게 제거
        else if(command[i] == 'D') {
            // 숫자 비었으면
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