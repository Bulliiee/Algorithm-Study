// Z
#include <iostream>

using namespace std;

int n, r, c;        // 2^n 사이즈, 원하는 row, col
int count = 0;      // 방문한 횟수

// 몇번째로 방문했는지 리턴
// 사용하는 배열의 크기, row, col 입력
void zMove(int size) {
    int temp = (size / 2) * (size / 2); // 한 사분면당 size대비 전부 방문시 방문횟수
    // cout << "================================\n";
    // cout << "size: " << size << '\n';
    // cout << "temp: " << temp << '\n';
    // cout << "r: " << r << ", c: " << c << '\n';
    // cout << "count: " << count << '\n';

    // size가 1까지 줄었으면 탈출
    if(size == 1) { return; }

    // 사분면으로 잘라서 원하는 좌표가 사이즈 대비 몇사분면인지 체크
    // 1사분면 경우
    // cout << "사분면: ";
    if(r < (size / 2) && c >= (size / 2)) {
        count += temp;
        // cout << 1;
    }
    // 2사분면 경우
    else if(r < (size / 2) && c < (size / 2)) {
        // cout << 2;
    }
    // 3사분면 경우
    else if(r >= (size / 2) && c < (size / 2)) {
        count += (temp * 2);
        // cout << 3;
    }
    // 4사분면 경우
    else if(r >= (size / 2) && c >= (size / 2)) {
        count += (temp * 3);
        // cout << 4;
    }
    // cout << '\n';

    // 사이즈 줄인만큼 좌표 맞춰줘야 사분면도 맞춰짐
    r %= (size / 2);
    c %= (size / 2);

    zMove(size / 2);
}

// 사용하는 배열의 크기 구하기(2^n)
int getSize(int n) {
    int res = 1;

    for(int i = 0; i < n; i++) { 
        res *= 2; 
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> r >> c;
    
    zMove(getSize(n));

    cout << count;
    
    return 0;
}