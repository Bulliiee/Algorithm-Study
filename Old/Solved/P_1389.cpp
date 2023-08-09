// �ɺ� �������� 6�ܰ� ��Ģ
#include <iostream>

#define MAX 101 // ������ ��
#define INF 0x7f7f7f7f

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int users[MAX][MAX];
    int userNum, relNum;
    cin >> userNum >> relNum;

    // �Ÿ�(�ɺ�������) ū ���� �ʱ�ȭ
    for(int l = 1; l <= userNum ; l++) 
        for(int m = 1; m <= userNum; m++) 
            users[l][m] = INF;

    // �Է�
    for(int i = 0; i < relNum; i++) {
        int user1, user2;
        cin >> user1 >> user2;
        users[user1][user2] = 1;
        users[user2][user1] = 1;
    }

    // �÷��̵� ����
    for(int k = 1; k <= userNum; k++) {
        for(int i = 1; i <= userNum; i++) {
            for(int j = 1; j <= userNum; j++) {
                if(i == j) { users[i][j] = 0; continue; }

                // ik, kj�� INF��� �������� ������ �Ǿ �Ʒ� if���� �����ع���
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
    // ������ ���ϸ� �׻���� �ɺ����� �� ���� �� ����
    for(int l = 1; l <= userNum ; l++) {
        int res = 0;
        for(int m = 1; m <= userNum; m++) {
            res += users[l][m];
        }
       
        // ������ ������������ ���ϱ� ���� ��� ���絵 ��
        if(res < minNum) {
            minNum = res;
            minUser = l;
        }
    }

    cout << minUser;

    return 0;
}