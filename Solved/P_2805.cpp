// 나무 자르기

// 이분탐색
// start, mid, end로 나누어, 첫 mid(start + end) / 2로부터 원하는 값이
// mid보다 클 경우
// start를 mid + 1로,
// mid보다 작을 경우
// end를 mid - 1로 설정 해 탐색 횟수를 줄이는 방법
#include <iostream>
#include <algorithm>

using namespace std;

#define ll long long

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return;
}

// 나무 길이 담은 배열, 원하는 나무 길이, 나무 갯수
int getCutterHeight(int treeHeight[], int treeLength, int treeNum) {
    int cutterHeight = 0;
    int start = 0;
    int end = *max_element(treeHeight, treeHeight + treeNum);
    int mid;
    ll temp = 0;

    // 계속된 이분탐색으로 start가 end보다 크거나 같아지는 순간 종료
    while(start <= end) {   
        temp = 0;

        // 원하는 값이 mid기준으로 크거나 같아질 때마다 start와 end가 변화하며
        // mid값을 새로 설정 해 준다.
        mid = (start + end) / 2;

        // 잘라낸 나무의 총 길이 temp에 저장
        for(int i = 0; i < treeNum; i++) {
            if(treeHeight[i] > mid) {
                temp += treeHeight[i] - mid;
            }
        }

        // 잘라낸 나무의 길이가 원하는 길이보다 작을 경우
        // end 재설정 해서 while문 상단에서 mid를 조정 해 절단기 높이를 낮춘다.
        if(temp < treeLength) {
            end = mid - 1;
        }
        // 크거나 같을 경우 절단기 높이로 mid를 설정
        // (최소한 treeLength만큼 가져가야 하므로 클 경우에도 cutterHeight에 설정 해 준다.)
        // 이후 start를 재설정 해서 while문 상단에서 mid를 조정 해 절단기 높이를 높인다.
        // 같을 경우 바로 끝내지 않는 이유는 절단기 높이가 최대일 경우를 구해야 하기 때문이다.
        else {
            cutterHeight = mid;
            start = mid + 1;
        }
    }

    return cutterHeight;
}

int main() {
    init();

    int treeNum, treeLength;
    int *treeHeight;

    cin >> treeNum >> treeLength;
    treeHeight = new int[treeNum];

    for(int i = 0; i < treeNum; i++) {
        cin >> treeHeight[i];
    }

    cout << getCutterHeight(treeHeight, treeLength, treeNum);

    return 0;
}