// Z
#include <iostream>

using namespace std;

int n, r, c;        // 2^n ������, ���ϴ� row, col
int count = 0;      // �湮�� Ƚ��

// ���°�� �湮�ߴ��� ����
// ����ϴ� �迭�� ũ��, row, col �Է�
void zMove(int size) {
    int temp = (size / 2) * (size / 2); // �� ��и�� size��� ���� �湮�� �湮Ƚ��
    // cout << "================================\n";
    // cout << "size: " << size << '\n';
    // cout << "temp: " << temp << '\n';
    // cout << "r: " << r << ", c: " << c << '\n';
    // cout << "count: " << count << '\n';

    // size�� 1���� �پ����� Ż��
    if(size == 1) { return; }

    // ��и����� �߶� ���ϴ� ��ǥ�� ������ ��� ���и����� üũ
    // 1��и� ���
    // cout << "��и�: ";
    if(r < (size / 2) && c >= (size / 2)) {
        count += temp;
        // cout << 1;
    }
    // 2��и� ���
    else if(r < (size / 2) && c < (size / 2)) {
        // cout << 2;
    }
    // 3��и� ���
    else if(r >= (size / 2) && c < (size / 2)) {
        count += (temp * 2);
        // cout << 3;
    }
    // 4��и� ���
    else if(r >= (size / 2) && c >= (size / 2)) {
        count += (temp * 3);
        // cout << 4;
    }
    // cout << '\n';

    // ������ ���θ�ŭ ��ǥ ������� ��и鵵 ������
    r %= (size / 2);
    c %= (size / 2);

    zMove(size / 2);
}

// ����ϴ� �迭�� ũ�� ���ϱ�(2^n)
int getSize(int n) {
    int res = 1;

    for(int i = 0; i < n; i++) { 
        res *= 2; 
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> r >> c;
    
    zMove(getSize(n));

    cout << count;
    
    return 0;
}