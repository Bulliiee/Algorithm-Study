// 숫자 카드
#include <iostream>
#include <vector>   // 벡터 쓰면 시간초과
#include <algorithm>

using namespace std;

// 이분탐색
// 찾을벡터, 찾을 값
bool cardCheck(int *card, int size, int target) {
    // 인덱스로 이분탐색 함
    int left = 0;
    int right = size - 1;

    while(left <= right) {
        int mid = (left + right) / 2;

        if(card[mid] == target) {
            return true;
        }
        else if(card[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    return false;
}

// input
void input(int *arr, int size) {
    for(int i = 0; i < size; i++) {
        cin >> arr[i];
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int *card1, *card2;
    int n, m;

    cin >> n;
    card1 = new int[n];
    input(card1, n);
    // for(int i = 0; i < n; i++) {
    //     int temp;
    //     cin >> temp;
    //     card1[i] = temp;
    // }

    cin >> m;
    card2 = new int[m];
    input(card2, m);
    // for(int i = 0; i < m; i++) {
    //     int temp;
    //     cin >> temp;
    //     card2[i] = temp;
    // }

    // 정렬(이분탐색 위함)
    sort(card1, card1 + n);

    for(int i = 0; i < m; i++) {
        cout << cardCheck(card1, n, card2[i]) ? 1 : 0;
        cout << ' ';
    }

    return 0;
}