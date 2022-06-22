// 리모컨
#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

// 고장난 버튼인지 체크
bool check(bool *malBtn, int curNum) {
    string s = to_string(curNum);

    for(int i = 0; i < s.length(); i++) {
        if(malBtn[s[i] - '0'] == true) {
            return false;
        }
    }

    return true;
}

// 자릿수 구하기
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

// // 배열로 들어온 숫자 합치기
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

// // 원하는 채널의 자릿수 하나 낮춘 최대채널과 자릿수 하나 올린 최소채널
// pair<int, int> getChannelBound(bool *malBtn, int channel) {
//     int start = 0, end = 0;
//     int digit = getDigit(channel);
//     int temp[digit + 1] = { 0 };
//     int t;  // 버튼 돌면서 가장 작은 버튼 혹은 가장 큰 버튼

//     // 자릿수 하나 내린 최대채널
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
    

//     // 자릿수 하나 올린 최소채널
//     // 0이 아닌 가장 작은 수가 첫자리가 됨
//     for(int i = 1; i <= 9; i++) {
//         if(check(malBtn, i)) {
//             t = i;
//             temp[0] = t;
//             break;
//         }
//     }
//     // 이후 뒷자리부터는 0포함 가장 작은수로 통일
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

    bool malBtn[10] = { false };  // true면 고장
    int n, c;
    cin >> n >> c;

    for(int i = 0; i < c; i++) {
        int temp;
        cin >> temp;
        malBtn[temp] = true;
    }

    int minimum = abs(n - 100);     // 시작이 100일 때 +,-로만 움직인 경우
    // pair<int, int> start_end = getChannelBound(malBtn, n);
    // 자릿수 - 1의 최대값부터 자릿수 넘어간 최소값까지 반복
    // for(int i = start_end.first; i <= start_end.second; i++) {  // bruteforce
    for(int i = 0; i <= 1000000; i++) {  // bruteforce
        if(minimum == 0) break;

        if(check(malBtn, i)) {
            // 원하는 채널에서 고장안난 버튼 누르고 해당 버튼 누른거 더함(버튼 누른 총 횟수)
            int temp = abs(n - i) + getDigit(i);
            minimum = min(minimum, temp);
        }
    }

    cout << minimum;

    return 0;
}