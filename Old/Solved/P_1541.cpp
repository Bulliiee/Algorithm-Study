// 잃어버린 괄호
#include <iostream>
#include <queue>
#include <string>

using namespace std;

queue<int> nums;   // 숫자
queue<char> op;    // 연산자

// 정수, 연산자 파싱(nums와 op에 담음)
void inputParsing(string input) {
    for(int i = 0; i < input.length(); i++) {
        string str = "";

        // 해당 인덱스가 연산자가 아니고, 문자열의 끝이 아니라면
        // 정수인 것이므로, 그것들을 뭉텅이로 str에 붙여서 큐에 push한다.
        while(i < input.length() && input[i] != '+' && input[i] != '-') {
            str += input[i];
            i++;
        }

        nums.push(stoi(str));

        // 해당 인덱스가 연산자라면 알맞는 연산자를 큐에 push한다.
        op.push(input[i] == '+' ? '+' : '-');
    }
}

int calc() {
    // 먼저 첫 숫자를 result에 저장
    int result = nums.front();
    bool flag = false;  // false라면 +연산, true라면 -연산 진행
                        // op가 -가 나온 이전은 모두 더하고 이후로는 전부 빼기연산만 한다.
                        // 이유는 -이후로는 중간에 +껴있으면 그부분만 괄호치면
                        // 전부 -연산을 하는 것과 같기 때문이다.
                        // 예를들어 0-100+50-100+50-100이라면
                        // 0-(100+50)-(100+50)-100 과 같은 식이다.

    nums.pop();
    // 숫자들 전부 pop할때까지 연산해서 result에 값 저장한다.
    while(!nums.empty()) {
        if(!flag && op.front() == '+') {
            result += nums.front();
        }
        else {
            flag = true;
            result -= nums.front();
        }
        nums.pop();
        op.pop();
    }    

    return result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string input;
    cin >> input;

    inputParsing(input);
    cout << calc();

    return 0;
}