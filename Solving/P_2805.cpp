// 나무 자르기
#include <iostream>
#include <algorithm>

using namespace std;

#define ll long long

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return;
}

bool desc(int num1, int num2) {
    return num1 > num2;
}

// isOver는 원하는 길이보다 클 경우 t, 작을 경우 f
int setHeight(int curHeight, int treeHeight, bool isOver) {
    int height = curHeight;

    if(isOver) {    // 원하는 나무 길이보다 클 경우 높이를 늘려서 나무 길이를 줄임
        height += ((treeHeight - height) / 2);
    }
    else {          // 원하는 나무 길이보다 작을 경우 높이 줄여서 나무 길이 늘림
        height -= ((treeHeight - height) / 2);
    }
    
    if(height < 0) {
        height = 0;
    }
    else if(height > 1000000000) {
        height = 1000000000;
    }

    return height;
}

int treeCutter(int treeHeight[], int treeLength, int treeNum) {
    int setCutterHeight;
    ll sum = 0;
    ll temp = 0;

    while(true) {
        if(sum == 0) {
            setCutterHeight = treeHeight[0] / 2;    // 제일 높은거 1/2로 설정
        }
        else if(sum > treeLength) {  // 원하는 나무 길이보다 클 경우
            setCutterHeight = setHeight(setCutterHeight, treeHeight[0], true);
        }
        else if(sum < treeLength) { // 원하는 나무 길이보다 작을 경우
            setCutterHeight = setHeight(setCutterHeight, treeHeight[0], false);
        }
        else {  // 원하는 나무 길이일 경우
            return setCutterHeight;
        }
        // cout << "setCutterHeight: " << setCutterHeight << '\n';
        sum = 0;

        // 절단기 높이만큼 자르기
        for(int i = 0; i < treeNum; i++) {
            if(treeHeight[i] > setCutterHeight) {
                temp = treeHeight[i] - setCutterHeight;
                sum += temp;
            }
            else {  // 어차피 정렬 되어있기에 설정 길이보다 작으면 더이상 돌지않게 함
                break;
            }
        }
    }
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
    // 정렬(#include <algorithm> 필요)
    // 인자1: 시작지점(배열의 포인터)
    // 인자2: 끝나는지점 + 1(배열의 포인터 + 배열의 크기)
    // 인자3: 값을 정렬하는 조건을 담은 bool리턴하는 비교메소드(여기선 내림차순)
    // 객체를 정렬할 경우 x좌표 같으면 y좌표 큰 순으로 정렬하는 등으로 활용 가능
    sort(treeHeight, treeHeight + treeNum, desc);

    cout << treeCutter(treeHeight, treeLength, treeNum);

    return 0;
}