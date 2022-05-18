// 단지번호붙이기
#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <queue>
#define MAX 25

using namespace std;

int n;  // 그래프 크기 input
int map[MAX][MAX];          // 그래프
bool visited[MAX][MAX];      // 방문여부
queue<pair<int, int>> q;    // 탐색할 좌표 담을 큐
queue<pair<int, int>> tq;   // 단지의 시작점 담을 큐

// 단지의 시작점을 큐에 담는 함수
// 0, 0부터 n, n까지 가로 우측으로, 세로 아래로 순으로 탐색함
// 만약 끝까지 탐색했는데도 못찾으면 false리턴(끝내기), 더 찾을 단지가 있으면 true리턴
bool getDanjiStart() {
    int Rindex = 0;
    int Cindex = 0;

    while(Rindex < n) {
        Cindex = 0;
        while(Cindex < n) {
            if(!visited[Rindex][Cindex] && map[Rindex][Cindex] == 1) {
                tq.push(make_pair(Rindex, Cindex));
                return true;
            }
            Cindex++;
        }
        Rindex++;
    }

    return false;
}

// 연결된 단지 넘버링하기
int numbering(int row, int col) {
    int xMove[] = {0, 0, -1, 1};
    int yMove[] = {-1, 1, 0, 0};
    int count = 0;

    visited[row][col] = true;
    q.push(make_pair(row, col));
    count++;

    while(!q.empty()) {
        int r = q.front().first;
        int c = q.front().second;

        q.pop();

        for(int i = 0; i < 4; i++) {
            int newR = r + yMove[i];
            int newC = c + xMove[i];

            if( (0 <= newR && newR <= n) && (0 <= newC && newC <= n) && map[newR][newC] == 1 && !visited[newR][newC]) {
                visited[newR][newC] = true;
                q.push(make_pair(newR, newC));
                count++;
            }
        }
    }

    return count;    
}

void printInput(int n) {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cout << map[i][j] << ' ';
        }
        cout << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> homeNumber; // 단지 내 집들의 갯수
    int danjiNumber = 0;

    cin >> n;

    for(int i = 0; i < n; i++) {
        string temp;
        cin >> temp;
        for(int j = 0; j < n; j++) {
            map[i][j] = temp[j] - '0';
        }
    }

    // printInput(n);

    while(getDanjiStart()) {
        homeNumber.push_back(numbering(tq.front().first, tq.front().second));
        tq.pop();
        danjiNumber++;
    }

    cout << danjiNumber << '\n';

    sort(homeNumber.begin(), homeNumber.end());
    for(auto loop : homeNumber) {
        cout << loop << '\n';
    }

    return 0;
}