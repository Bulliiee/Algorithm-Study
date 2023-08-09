// 케빈 베이컨의 6단계 법칙
#include <iostream>

#define MAX 101 // 유저의 수
#define INF 0x7f7f7f7f

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int users[MAX][MAX];
    int userNum, relNum;
    cin >> userNum >> relNum;

    // 거리(케빈베이컨수) 큰 수로 초기화
    for(int l = 1; l <= userNum ; l++) 
        for(int m = 1; m <= userNum; m++) 
            users[l][m] = INF;

    // 입력
    for(int i = 0; i < relNum; i++) {
        int user1, user2;
        cin >> user1 >> user2;
        users[user1][user2] = 1;
        users[user2][user1] = 1;
    }

    // 플로이드 워셜
    for(int k = 1; k <= userNum; k++) {
        for(int i = 1; i <= userNum; i++) {
            for(int j = 1; j <= userNum; j++) {
                if(i == j) { users[i][j] = 0; continue; }

                // ik, kj가 INF라면 더했을때 음수가 되어서 아래 if문을 만족해버림
                if(users[i][k] != INF && users[k][j] != INF) {
                    if(users[i][j] > (users[i][k] + users[k][j])) {
                        users[i][j] = (users[i][k] + users[k][j]);
                    }
                }
            }
        }
    }

    int minUser = MAX;
    int minNum = INF;
    // 가로줄 더하면 그사람의 케빈베이컨 수 얻을 수 있음
    for(int l = 1; l <= userNum ; l++) {
        int res = 0;
        for(int m = 1; m <= userNum; m++) {
            res += users[l][m];
        }
       
        // 어차피 오름차순으로 보니까 같은 경우 안재도 됨
        if(res < minNum) {
            minNum = res;
            minUser = l;
        }
    }

    cout << minUser;

    return 0;
}