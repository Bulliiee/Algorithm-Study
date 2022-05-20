// ������ �����
#include <iostream>
#define MAX 128

using namespace std;

int inputNum;  // �簢�� �� ���� ����
int white = 0;
int blue = 0;
int paper[MAX][MAX];

void input() {
    int temp;
    cin >> inputNum;

    for(int i = 0; i < inputNum; i++) {
        for(int j = 0; j < inputNum; j++) {
            cin >> paper[i][j];
            // cin >> temp;
            // if(temp == 0) white++; 
            // else blue++;
            // paper[i][j] = temp;
        }
    }
}

// �ڸ� ������ ������, ������ x, y��ǥ
void getPaper(int size, int x, int y) {
    int temp = 0;

    // size��ŭ üũ
    for(int i = y; i < y + size; i++) {
        for(int j = x; j < x + size; j++) {
            // Ȯ���� ��ǥ�� 1�ΰ�� temp����(�̰ɷ� white�� blue ����)
            if(paper[i][j] == 1) {
                temp++;
            }
        }
    }

    // �� �����ŭ üũ�ߴµ�, temp�� 0�̶�� ���� �� �����ŭ�� ���� �Ͼ�� ���̶�� ���̹Ƿ�
    // white++���ش�.
    if(temp == 0) {
        white++;
    }
    // �� �����ŭ üũ�ߴµ�, temp�� size*size��ŭ �����Ǿ��ٸ�, �� �����ŭ ���� �Ķ�����
    // �׷��� blue++
    else if(temp == size * size) {
        blue++;
    }
    // ��� �ƴ� ���(�ش� ����� ��� �Ͼ�Ǵ� �Ķ� �ƴ� ���) �� ������� �� �ٿ��� üũ�Ѵ�.
    // ���������� ���ʴ�� ������, ��������, ���ʾƷ�, �����ʾƷ� �κ��̴�.
    else {
        getPaper(size / 2, x, y);
        getPaper(size / 2, x + size / 2, y);
        getPaper(size / 2, x, y + size / 2);
        getPaper(size / 2, x + size / 2, y + size / 2);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    // ó������ ��и� ���� ���ص� �Ǵ� ������ ����� ���� ��ü�̱� ����
    getPaper(inputNum, 0, 0);
    cout << white << '\n' << blue;

    return 0;
}