// �Ҿ���� ��ȣ
#include <iostream>
#include <queue>
#include <string>

using namespace std;

queue<int> nums;   // ����
queue<char> op;    // ������

// ����, ������ �Ľ�(nums�� op�� ����)
void inputParsing(string input) {
    for(int i = 0; i < input.length(); i++) {
        string str = "";

        // �ش� �ε����� �����ڰ� �ƴϰ�, ���ڿ��� ���� �ƴ϶��
        // ������ ���̹Ƿ�, �װ͵��� �����̷� str�� �ٿ��� ť�� push�Ѵ�.
        while(i < input.length() && input[i] != '+' && input[i] != '-') {
            str += input[i];
            i++;
        }

        nums.push(stoi(str));

        // �ش� �ε����� �����ڶ�� �˸´� �����ڸ� ť�� push�Ѵ�.
        op.push(input[i] == '+' ? '+' : '-');
    }
}

int calc() {
    // ���� ù ���ڸ� result�� ����
    int result = nums.front();
    bool flag = false;  // false��� +����, true��� -���� ����
                        // op�� -�� ���� ������ ��� ���ϰ� ���ķδ� ���� ���⿬�길 �Ѵ�.
                        // ������ -���ķδ� �߰��� +�������� �׺κи� ��ȣġ��
                        // ���� -������ �ϴ� �Ͱ� ���� �����̴�.
                        // ������� 0-100+50-100+50-100�̶��
                        // 0-(100+50)-(100+50)-100 �� ���� ���̴�.

    nums.pop();
    // ���ڵ� ���� pop�Ҷ����� �����ؼ� result�� �� �����Ѵ�.
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