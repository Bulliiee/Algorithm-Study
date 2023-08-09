// 종이의 개수
#include <iostream>

using namespace std;

int count1 = 0, count2 = 0, count3 = 0; // -1, 0, 1 갯수

void cutPaper(int **paper, int papersz, int startX, int startY) {
    int temp = paper[startY][startX];
    int tempSize = papersz / 3;
    int nextX, nextY;
    bool flag = true;   // papersz만큼 모두 같은 종이면 true

    for(int i = startY; i < startY + papersz; i++) {
        for(int j = startX; j < startX + papersz; j++) {
            if(paper[i][j] != temp) {
                nextX = j - (j % papersz);
                nextY = i - (i % papersz);
                flag = false;
                break;
            }
        }
        if(!flag) {
            break;
        }
    }

    if(!flag)
        for(int i = 0; i < 3; i++) 
            for(int j = 0; j < 3; j++) 
                cutPaper(paper, tempSize, nextX + (tempSize * j), nextY + (tempSize * i));
    else
        if(temp == -1) count1++; 
        else if(temp == 0) count2++;
        else count3++;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int papersz;    // 종이 사이즈
    int **paper;    // 입력 종이

    cin >> papersz;
    // 2차원 배열 동적 할당
    paper = new int*[papersz];
    for(int i = 0; i < papersz; i++) 
        paper[i] = new int[papersz];

    // 입력
    for(int i = 0; i < papersz; i++)
        for(int j = 0; j < papersz; j++)
            cin >> paper[i][j];

    cutPaper(paper, papersz, 0, 0);

    cout << count1 << '\n';
    cout << count2 << '\n';
    cout << count3;

    // 2차원 배열 할당 해제
    for(int i = 0; i < papersz; i++) 
        delete[] paper[i];
    delete[] paper;

    return 0;
}