// Hashing
/* ��ⷯ ����
(a + b) mod n = {(a mod n) + (b mod n)} mod n
(a - b) mod n = {(a mod n) - (b mod n)} mod n
(a * b) mod n = {(a mod n) * (b mod n)} mod n

�׳� �����ϸ� ��������̶� ���ڰ� �ʹ� Ŀ���ϱ�
��ⷯ ������ Ư���� �̿��ؼ� ����Ѵ�.
*/
#include <iostream>
#include <string>

using namespace std;

#define ull unsigned long long
#define r 31
#define M 1234567891

// mod������ ������ ���� ��� �Լ�
ull power(int num1, int num2) {
    ull res = 1;

    // res�� �������� mod M �ϹǷ� M�� ���� �ʰ�, num1�� M�� ���� �����Ƿ�
    // �׳� ���� �Ŀ� �ѹ��� mod���� �ص� ����� ����.
    for(int i = 0; i < num2; i++) {
        res *= num1;
        res %= M;
    }

    return res;
}

int hashing(int length, string str) {
    ull res = 0;
    ull temp;

    for(int i = 0; i < length; i++) {
        // ���ĺ��� mod M �ϸ� ������ �ڱ� �ڽ��� ����(M���� �׻� �����ϱ�)
        // �׷��� str[i]�� mod M ���ϰ� ������
        temp = power(r, i); // power�� mod M�� ������ ������ �Լ���
        res = (res + ((str[i] - 96) * temp) % M) % M;
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int length;
    string str;

    cin >> length >> str;

    cout << hashing(length, str);

    return 0;
}