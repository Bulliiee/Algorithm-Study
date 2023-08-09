// ������
#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

// ���峭 ��ư���� üũ
bool check(bool *malBtn, int curNum) {
    string s = to_string(curNum);

    for(int i = 0; i < s.length(); i++) {
        if(malBtn[s[i] - '0'] == true) {
            return false;
        }
    }

    return true;
}

// �ڸ��� ���ϱ�
int getDigit(int num) {
    int count = 0;
    if(num == 0) {
        return 1;
    }
    while(num > 0) {
        num /= 10;
        count++;
    }

    return count;
}

// // �迭�� ���� ���� ��ġ��
// int mergeArr(int *arr, int size) {
//     int res = 0;
//     int temp = 1;

//     for(int i = 1; i < size; i++) {
//         temp *= 10;
//     }

//     for(int i = 0; i < size; i++) {
//         int t = arr[i] * temp;
//         res += t;
//         temp /= 10;
//     }

//     return res;
// }

// // ���ϴ� ä���� �ڸ��� �ϳ� ���� �ִ�ä�ΰ� �ڸ��� �ϳ� �ø� �ּ�ä��
// pair<int, int> getChannelBound(bool *malBtn, int channel) {
//     int start = 0, end = 0;
//     int digit = getDigit(channel);
//     int temp[digit + 1] = { 0 };
//     int t;  // ��ư ���鼭 ���� ���� ��ư Ȥ�� ���� ū ��ư

//     // �ڸ��� �ϳ� ���� �ִ�ä��
//     for(int i = 9; i >= 0; i--) {
//         if(check(malBtn, i)) {
//             t = i;
//             break;
//         }
//     }
//     for(int i = 0; i < digit - 1; i++) {
//         temp[i] = t;
//     }
//     start = mergeArr(temp, digit - 1);
    

//     // �ڸ��� �ϳ� �ø� �ּ�ä��
//     // 0�� �ƴ� ���� ���� ���� ù�ڸ��� ��
//     for(int i = 1; i <= 9; i++) {
//         if(check(malBtn, i)) {
//             t = i;
//             temp[0] = t;
//             break;
//         }
//     }
//     // ���� ���ڸ����ʹ� 0���� ���� �������� ����
//     if(check(malBtn, 0)) {
//         t = 0;
//     }
//     for(int i = 1; i < digit + 1; i++) {
//         temp[i] = t;
//     }
//     end = mergeArr(temp, digit + 1);

//     return make_pair(start, end);
// }

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    bool malBtn[10] = { false };  // true�� ����
    int n, c;
    cin >> n >> c;

    for(int i = 0; i < c; i++) {
        int temp;
        cin >> temp;
        malBtn[temp] = true;
    }

    int minimum = abs(n - 100);     // ������ 100�� �� +,-�θ� ������ ���
    // pair<int, int> start_end = getChannelBound(malBtn, n);
    // �ڸ��� - 1�� �ִ밪���� �ڸ��� �Ѿ �ּҰ����� �ݺ�
    // for(int i = start_end.first; i <= start_end.second; i++) {  // bruteforce
    for(int i = 0; i <= 1000000; i++) {  // bruteforce
        if(minimum == 0) break;

        if(check(malBtn, i)) {
            // ���ϴ� ä�ο��� ����ȳ� ��ư ������ �ش� ��ư ������ ����(��ư ���� �� Ƚ��)
            int temp = abs(n - i) + getDigit(i);
            minimum = min(minimum, temp);
        }
    }

    cout << minimum;

    return 0;
}