// IOIOI
#include <iostream>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;                  // Pn���� n
    int strLen;             // �Է� ���ڿ� ����
    int res = 0;            // ����
    string strInput;        // �Է� ���ڿ�

    // �Է�
    cin >> n >> strLen;
    cin >> strInput;

    for(int i = 0; i < strLen; i++) {
        if(strInput[i] == 'I') {
            int count = 0;
            bool flag = true;

            while(flag) {
                i++;
                // �Է� ���ڿ� �ȿ��� �� ���� ���� Pn������ n�� ����(count)
                // ��, �������� ��Ÿ���� Pn�� n�� ���ϴ� ��.
                if(strInput[i] == 'O' && strInput[i + 1] == 'I') {
                    i++;
                    count++;
                }
                // �� ���� ���ԵǾ����� ����Ѵ�.
                // ���� ���ϱ� ���� ���� if������ ����� n(�Է� ���ڿ����� �������� ��Ÿ�� Pn)
                // �� �������� �ش� Pn�� �Է����� �־��� n�� �� �� �ִ��� ����� ��
                // ����� ���Ѵ�.
                else {
                    int temp = count - n + 1;
                    if(temp > 0) {
                        res += temp;
                    }
                    flag = false;
                    i--;
                }
            }
        }
    }

    cout << res << '\n';

    return 0;
}