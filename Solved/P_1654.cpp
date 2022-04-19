// 랜선 자르기
#include <iostream>
#include <algorithm>

using namespace std;

#define ll long long

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}

int cutLan(int curLan, int needLan, int *arrLan) {
    ll start = 0;
    ll end = *max_element(arrLan, arrLan + curLan);
    ll mid;    // 이게 잘라낼 길이가 됨
    
    int tempAmount = 0; // 갯수
    ll tempLength = 0; // 길이

    while(start <= end) {
        tempAmount = 0;

        mid = (start + end) / 2;
        if(mid == 0) {
            mid++;
        }

        // 설정한 길이(mid)로 자른 갯수 저장(tempAmount에)
        for(int i = 0; i < curLan; i++) {
            tempAmount += (arrLan[i] / mid);
        }
        // cout << "tempAmount: " << tempAmount << '\n';

        // 갯수가 필요한 것보다 적다면 설정한 길이가 긴 것이니 더 줄임
        if(tempAmount < needLan) {
            end = mid - 1;
        }
        // 갯수가 필요한 것보다 많다면 설정한 길이가 짧은 것이니 더 늘림
        // 갯수가 같다면 자른 길이로 비교해서 큰 길이값을 넣음
        else {
            if(tempLength < mid) {
                tempLength = mid;
            }
            start = mid + 1;
        }
        // else {
        //     start = mid + 1;
        // }
    }

    return tempLength;
}

int main() {
    init();
    
    int curLan, needLan;
    cin >> curLan >> needLan;

    int arrLan[curLan];
    for(int i = 0; i < curLan; i++) {
        cin >> arrLan[i];
    }

    cout << cutLan(curLan, needLan, arrLan);

    return 0;
}