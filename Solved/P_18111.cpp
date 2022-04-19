// ����ũ����Ʈ
#include <iostream>

using namespace std;

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}

int main() {
    init();
    int n, m, b;        // ���α���, ���α���, �κ��� �ִ� ��� ��
    int maxHeight = 0;  // ������ ���� ���� ����

    cin >> n >> m >> b;
    int ground[n][m];    // �� ���� �迭

    // �� �Է¹ޱ�
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> ground[i][j];

            // �ִ���� �ֱ�
            if(ground[i][j] > maxHeight) {
                maxHeight = ground[i][j];
            }
        }
    }

    int takeTime = 0x7f7f7f7f;   // �ɸ� �ð�
    int tempB = b;            // �κ��丮 �ӽ�
    int tempTime = 0;
    int tempMaxHeight = 257;    // 256���� 0���� ��� Ž���ؼ� ���� ������ �� �����
    while(tempMaxHeight--) {
        // cout << "tempMaxHeight: " <<  tempMaxHeight << '\n';
        tempB = b;
        tempTime = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int diff = tempMaxHeight - ground[i][j];
                
                // �� �ױ�
                if(diff > 0) {
                    tempB -= diff;
                    tempTime += diff;
                }
                // �� �ı�
                else if(diff < 0) {
                    tempB -= diff;
                    tempTime -= (diff * 2);
                }
            }
        }

        if(tempB < 0) { // �κ� ������
            continue;
        }
        else {
            if(tempTime < takeTime) {
                takeTime = tempTime;
                maxHeight = tempMaxHeight;
            }
            else if(tempTime == takeTime) {
                if(maxHeight < tempMaxHeight) {
                    maxHeight = tempMaxHeight;
                }
            }
        }
    }

    
    // cout << "tempTime: " << takeTime << '\n';
    // cout << "maxHeight: " << maxHeight << '\n';
    cout << takeTime << ' ' << maxHeight << '\n';


    return 0;
}