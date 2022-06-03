// 쿼드트리
#include <iostream>
#include <string>

using namespace std;

char arr[64][64];

void getCompression(int size, int row, int col) {
    char curPoint = arr[row][col];

    for(int i = row; i < row + size; i++) {
        for(int j = col; j < col + size; j++) {
            // 현재 size만큼 돌면서 서로 다른애가 나타나면 size 반으로 쪼개서 사분면들 재귀호출
            if(curPoint != arr[i][j]) {
                cout << '(';
                getCompression(size / 2, row, col);
                getCompression(size / 2, row, col + size / 2);
                getCompression(size / 2, row + size / 2, col);
                getCompression(size / 2, row + size / 2, col + size / 2);
                cout << ')';
                return;
            }
        }
    }

    // 한 사분면당 size만큼 다 확인해서 같은 경우 curPoint출력
    cout << curPoint;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int imgsz;
    cin >> imgsz;
    for(int i = 0; i < imgsz; i++) {
        string points;
        cin >> points;
        for(int j = 0; j < imgsz; j++) {
            arr[i][j] = points[j];
        }
    }

    getCompression(imgsz, 0, 0);

    return 0;
}