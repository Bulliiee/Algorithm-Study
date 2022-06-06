// ���ϻ���
#include <iostream>

#define MAX 100

using namespace std;

int imgsz;                              // �̹��� ũ��
int startR, startC;                     // �湮���� ���� ��ǥ�� ������
char colour;                            // ���� ��ǥ�� ���� �񱳿�
// char img[MAX][MAX];                     // �̹��� �迭
// bool visited[MAX][MAX] = { false };     // �湮���� �迭
char **img;
bool **visited;
bool flag = false;                      // f: ���� �ƴ� ���, t: ������ ���

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

// Ž�� �� ���� row column �湮���� ����(ť�� ������ ����)
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

// �湮�Ұ� �������� true
bool getStartPoints() {
    for(int i = 0; i < imgsz; i++) {
        for(int j = 0; j < imgsz; j++) {
            // ���ϾƴѰ��
            if(!flag) {
                if(!visited[i][j]) {
                    startR = i;
                    startC = j;
                    colour = img[i][j];
                    return true;
                }
            }
            // ���ϻ����� ��쿡�� �ƴѰ�쿡 ���� Ž���ؼ� 
            // visited�� ���� true�� �Ǿ��ִ�.
            // �׷��� true�� �湮 ���Ѱɷ� ġ�� ó���Ѵ�.
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

// dfs ���
void getArea(int r, int c) {
    int moveR[] = { 0, 0, -1, 1 };
    int moveC[] = { -1, 1, 0, 0 };

    // ���� �ƴ� ���
    if(!flag) { visited[r][c] = true; }
    // ������ ���
    else { visited[r][c] = false; }

    for(int i = 0; i < 4; i++) {
        int nextR = r + moveR[i];
        int nextC = c + moveC[i];

        if(isPossible(nextR, nextC)) {
            // ���� �ƴ� ���
            if(!flag) {
                if(img[nextR][nextC] == colour) {
                    getArea(nextR, nextC);
                }
            }
            // ������ ���
            else {
                // ���� Ȥ�� ����� ���
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

    int count1 = 0; // ���ϻ��� x
    int count2 = 0; // ���ϻ��� o

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