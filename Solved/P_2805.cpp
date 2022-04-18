// ���� �ڸ���

// �̺�Ž��
// start, mid, end�� ������, ù mid(start + end) / 2�κ��� ���ϴ� ����
// mid���� Ŭ ���
// start�� mid + 1��,
// mid���� ���� ���
// end�� mid - 1�� ���� �� Ž�� Ƚ���� ���̴� ���
#include <iostream>
#include <algorithm>

using namespace std;

#define ll long long

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return;
}

// ���� ���� ���� �迭, ���ϴ� ���� ����, ���� ����
int getCutterHeight(int treeHeight[], int treeLength, int treeNum) {
    int cutterHeight = 0;
    int start = 0;
    int end = *max_element(treeHeight, treeHeight + treeNum);
    int mid;
    ll temp = 0;

    // ��ӵ� �̺�Ž������ start�� end���� ũ�ų� �������� ���� ����
    while(start <= end) {   
        temp = 0;

        // ���ϴ� ���� mid�������� ũ�ų� ������ ������ start�� end�� ��ȭ�ϸ�
        // mid���� ���� ���� �� �ش�.
        mid = (start + end) / 2;

        // �߶� ������ �� ���� temp�� ����
        for(int i = 0; i < treeNum; i++) {
            if(treeHeight[i] > mid) {
                temp += treeHeight[i] - mid;
            }
        }

        // �߶� ������ ���̰� ���ϴ� ���̺��� ���� ���
        // end �缳�� �ؼ� while�� ��ܿ��� mid�� ���� �� ���ܱ� ���̸� �����.
        if(temp < treeLength) {
            end = mid - 1;
        }
        // ũ�ų� ���� ��� ���ܱ� ���̷� mid�� ����
        // (�ּ��� treeLength��ŭ �������� �ϹǷ� Ŭ ��쿡�� cutterHeight�� ���� �� �ش�.)
        // ���� start�� �缳�� �ؼ� while�� ��ܿ��� mid�� ���� �� ���ܱ� ���̸� ���δ�.
        // ���� ��� �ٷ� ������ �ʴ� ������ ���ܱ� ���̰� �ִ��� ��츦 ���ؾ� �ϱ� �����̴�.
        else {
            cutterHeight = mid;
            start = mid + 1;
        }
    }

    return cutterHeight;
}

int main() {
    init();

    int treeNum, treeLength;
    int *treeHeight;

    cin >> treeNum >> treeLength;
    treeHeight = new int[treeNum];

    for(int i = 0; i < treeNum; i++) {
        cin >> treeHeight[i];
    }

    cout << getCutterHeight(treeHeight, treeLength, treeNum);

    return 0;
}