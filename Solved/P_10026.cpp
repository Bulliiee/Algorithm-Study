// 적록색약
#include <iostream>

#define MAX 100

using namespace std;

int imgsz;                              // 이미지 크기
int startR, startC;                     // 방문하지 않은 좌표의 시작점
char colour;                            // 현재 좌표의 색깔 비교용
// char img[MAX][MAX];                     // 이미지 배열
// bool visited[MAX][MAX] = { false };     // 방문여부 배열
char **img;
bool **visited;
bool flag = false;                      // f: 적록 아닌 경우, t: 적록인 경우

// initialize
void init() {
    // dynamic allocation
    img = new char*[imgsz];
    visited = new bool*[imgsz];
    for(int i = 0; i < imgsz; i++) {
        img[i] = new char[imgsz];
        visited[i] = new bool[imgsz];
    }

    // init
    for(int i = 0; i < imgsz; i++) {
        for(int j = 0; j < imgsz; j++) {
            img[i][j] = '0';
            visited[i][j] = false;
        }
    }

    // input
    for(int i = 0; i < imgsz; i++) {
        cin >> img[i];
    }
}

// free allocated memory
// program end
void pgmend() {
    for(int i = 0; i < imgsz; i++) {
        delete[] img[i];
        delete[] visited[i];
    }
    delete[] img;
    delete[] visited;
}

// 탐색 시 다음 row column 방문할지 말지(큐에 넣을지 여부)
bool isPossible(int nextR, int nextC) {
    if(!flag) {
        if((0 <= nextR && nextR < imgsz) && 
            (0 <= nextC && nextC < imgsz) && 
            !visited[nextR][nextC]) {
                return true;
        }
    }
    else {
        if((0 <= nextR && nextR < imgsz) && 
            (0 <= nextC && nextC < imgsz) && 
            visited[nextR][nextC]) {
                return true;
        }
    }

    return false;
}

// 방문할게 남았으면 true
bool getStartPoints() {
    for(int i = 0; i < imgsz; i++) {
        for(int j = 0; j < imgsz; j++) {
            // 적록아닌경우
            if(!flag) {
                if(!visited[i][j]) {
                    startR = i;
                    startC = j;
                    colour = img[i][j];
                    return true;
                }
            }
            // 적록색약인 경우에는 아닌경우에 전부 탐색해서 
            // visited가 전부 true로 되어있다.
            // 그래서 true를 방문 안한걸로 치고 처리한다.
            else {
                if(visited[i][j]) {
                    startR = i;
                    startC = j;
                    colour = img[i][j];
                    return true;
                }
            }
        }
    }

    return false;
}

// dfs 재귀
void getArea(int r, int c) {
    int moveR[] = { 0, 0, -1, 1 };
    int moveC[] = { -1, 1, 0, 0 };

    // 적록 아닌 경우
    if(!flag) { visited[r][c] = true; }
    // 적록인 경우
    else { visited[r][c] = false; }

    for(int i = 0; i < 4; i++) {
        int nextR = r + moveR[i];
        int nextC = c + moveC[i];

        if(isPossible(nextR, nextC)) {
            // 적록 아닌 경우
            if(!flag) {
                if(img[nextR][nextC] == colour) {
                    getArea(nextR, nextC);
                }
            }
            // 적록인 경우
            else {
                // 적색 혹은 녹색인 경우
                if(colour == 'R' || colour == 'G') {
                    if (img[nextR][nextC] == 'R' || img[nextR][nextC] == 'G') {
                        getArea(nextR, nextC);
                    }
                }
                else if(img[nextR][nextC] == colour) {
                    getArea(nextR, nextC);
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int count1 = 0; // 적록색약 x
    int count2 = 0; // 적록색약 o

    cin >> imgsz;

    init();

    // call func1
    while(getStartPoints()) {
        count1++;
        getArea(startR, startC);
    }
    
    // call func2
    flag = true;
    while(getStartPoints()) {
        count2++;
        getArea(startR, startC);
    }

    cout << count1 << ' ' << count2;

    pgmend();

    return 0;
}