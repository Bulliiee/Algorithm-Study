// 나무 자르기
#include <iostream>
#include <algorithm>

using namespace std;

bool desc(int num1, int num2) {
    return num1 > num2;
}

int treeCutter(int treeHeight[], int treeLength, int treeNum) {
    int setHeight;
    int sum = 0;

    while(sum < treeLength) {
        setHeight = treeHeight[0];  // 제일 높은걸로 설정
        for(int i = 0; i < treeNum; i++) {
            if(treeHeight[i] > setHeight) {
                
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int treeNum, treeLength;
    int *treeHeight;

    cin >> treeNum >> treeLength;
    treeHeight = new int[treeNum];

    for(int i = 0; i < treeNum; i++) {
        cin >> treeHeight[i];
    }
    // 정렬
    // 인자1: 시작지점(배열의 포인터)
    // 인자2: 끝나는지점 + 1(배열의 포인터 + 배열의 크기)
    // 인자3: 값을 정렬하는 조건을 담은 bool리턴하는 비교메소드(여기선 내림차순)
    // 객체를 정렬할 경우 x좌표 같으면 y좌표 큰 순으로 정렬하는 등으로 활용 가능
    sort(treeHeight, treeHeight + treeNum, desc);

    cout << treeCutter(treeHeight, treeLength, treeNum);

    return 0;
}