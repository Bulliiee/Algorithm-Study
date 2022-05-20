// 색종이 만들기
#include <iostream>
#define MAX 128

using namespace std;

int inputNum;  // 사각형 한 변의 길이
int white = 0;
int blue = 0;
int paper[MAX][MAX];

void input() {
    int temp;
    cin >> inputNum;

    for(int i = 0; i < inputNum; i++) {
        for(int j = 0; j < inputNum; j++) {
            cin >> paper[i][j];
            // cin >> temp;
            // if(temp == 0) white++; 
            // else blue++;
            // paper[i][j] = temp;
        }
    }
}

// 자를 색종이 사이즈, 시작할 x, y좌표
void getPaper(int size, int x, int y) {
    int temp = 0;

    // size만큼 체크
    for(int i = y; i < y + size; i++) {
        for(int j = x; j < x + size; j++) {
            // 확인한 좌표가 1인경우 temp증가(이걸로 white랑 blue 구분)
            if(paper[i][j] == 1) {
                temp++;
            }
        }
    }

    // 한 사이즈만큼 체크했는데, temp가 0이라는 말은 그 사이즈만큼은 전부 하양색 종이라는 뜻이므로
    // white++해준다.
    if(temp == 0) {
        white++;
    }
    // 한 사이즈만큼 체크했는데, temp가 size*size만큼 증가되었다면, 그 사이즈만큼 전부 파랑종이
    // 그래서 blue++
    else if(temp == size * size) {
        blue++;
    }
    // 모두 아닌 경우(해당 사이즈에 모두 하양또는 파랑 아닌 경우) 그 사이즈에서 더 줄여서 체크한다.
    // 위에서부터 차례대로 왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래 부분이다.
    else {
        getPaper(size / 2, x, y);
        getPaper(size / 2, x + size / 2, y);
        getPaper(size / 2, x, y + size / 2);
        getPaper(size / 2, x + size / 2, y + size / 2);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    // 처음에는 사분면 전부 안해도 되는 이유가 사이즈가 종이 전체이기 때문
    getPaper(inputNum, 0, 0);
    cout << white << '\n' << blue;

    return 0;
}