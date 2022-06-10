// 종이의 개수
#include <iostream>

#define MAX 2187    // 3^7

using namespace std;

int count1 = 0, count2 = 0, count3 = 0; // -1, 0, 1 갯수

void cutPaper(int **paper, int papersz, int startX, int startY) {
    int temp = paper[startY][startX];
    int tempSize = papersz / 3;

    for(int i = startY; i < startY + papersz; i++) {
        for(int j = startX; j < startX + papersz; j++) {
            if(paper[i][j] != temp) {
                int nextX = j - (j % papersz);
                int nextY = i - (i % papersz);
                cutPaper(paper, tempSize, nextX, nextY);
                cutPaper(paper, tempSize, nextX + tempSize, nextY);
                cutPaper(paper, tempSize, nextX + tempSize * 2, nextY);
                cutPaper(paper, tempSize, nextX, nextY + tempSize);
                cutPaper(paper, tempSize, nextX + tempSize, nextY + tempSize);
                cutPaper(paper, tempSize, nextX + tempSize * 2, nextY + tempSize);
                cutPaper(paper, tempSize, nextX, nextY + tempSize * 2);
                cutPaper(paper, tempSize, nextX + tempSize, nextY + tempSize * 2);
                cutPaper(paper, tempSize, nextX + tempSize * 2, nextY + tempSize * 2);
                return ;
            }
        }
    }

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