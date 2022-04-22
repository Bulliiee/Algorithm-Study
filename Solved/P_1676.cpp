// ���丮�� 0�� ����
#include <iostream>

using namespace std;

#define min(a, b) (a < b ? a : b)

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return;
}

/*
    �ڿ� 0�� �������� 2�� 5�� ���� �Ǿ�� �ϰ�,
    0�� ������ �μ� 2�� 5�� ���� �� ���� ���� �ȴ�.
    ���� ��� 600�� �μ��� 2, 2, 2, 3, 5, 5��, 
    5�� ������ 2���̹Ƿ� 0�� ������ 2���� ���̴�.
    ���� ������ �̿��� �μ� 2�� 5�� ������ ���ؼ�
    �� �� ���� ������ ���ϸ� 0�� ������ ���� �� �ִ�.
*/
int getZeroCount(int num) {
    int tCount = 0; // 2�� 5�� ����
    int fCount = 0; 
    int temp;

    // ���丮���̴ϱ� 1 ~ �Է¼��ڱ��� �ϳ��ϳ� üũ�ϸ� ��
    // ������� 10 �Է��ϸ�
    // 1: x
    // 2: 2
    // 3: x
    // 4: 2, 2
    // 5: 5
    // 6: 2
    // 7: x
    // 8: 2, 2, 2
    // 9: x
    // 10: 2
    // 10: 5
    // �ؼ� �μ� 2�� ������ 8��, 5�� ������ 2���� 0�� ������ 2��
    for(int i = 1; i <= num; i++) {
        temp = i;
        while(temp) {
            if(temp % 2 == 0) {
                tCount++;
                temp /= 2;
                // cout << "tCount: " << tCount << '\n';
            }
            else {
                // 2�� �ȳ������� �μ� ���°Ŵϱ� break
                break;
            }
        }

        temp = i;
        while(temp) {
            if(temp % 5 == 0) {
                fCount++;
                temp /= 5;
                // cout << "fCount: " << fCount << '\n';
            }
            else {
                break;
            }
        }
    }

    return min(tCount, fCount);
}

int main() {
    init();

    int num;

    cin >> num;

    cout << getZeroCount(num) << '\n';

    return 0;
}