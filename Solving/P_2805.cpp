// ���� �ڸ���
#include <iostream>
#include <algorithm>

using namespace std;

#define ll long long

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return;
}

bool desc(int num1, int num2) {
    return num1 > num2;
}

// isOver�� ���ϴ� ���̺��� Ŭ ��� t, ���� ��� f
int setHeight(int curHeight, int treeHeight, bool isOver) {
    int height = curHeight;

    if(isOver) {    // ���ϴ� ���� ���̺��� Ŭ ��� ���̸� �÷��� ���� ���̸� ����
        height += ((treeHeight - height) / 2);
    }
    else {          // ���ϴ� ���� ���̺��� ���� ��� ���� �ٿ��� ���� ���� �ø�
        height -= ((treeHeight - height) / 2);
    }
    
    if(height < 0) {
        height = 0;
    }
    else if(height > 1000000000) {
        height = 1000000000;
    }

    return height;
}

int treeCutter(int treeHeight[], int treeLength, int treeNum) {
    int setCutterHeight;
    ll sum = 0;
    ll temp = 0;

    while(true) {
        if(sum == 0) {
            setCutterHeight = treeHeight[0] / 2;    // ���� ������ 1/2�� ����
        }
        else if(sum > treeLength) {  // ���ϴ� ���� ���̺��� Ŭ ���
            setCutterHeight = setHeight(setCutterHeight, treeHeight[0], true);
        }
        else if(sum < treeLength) { // ���ϴ� ���� ���̺��� ���� ���
            setCutterHeight = setHeight(setCutterHeight, treeHeight[0], false);
        }
        else {  // ���ϴ� ���� ������ ���
            return setCutterHeight;
        }
        // cout << "setCutterHeight: " << setCutterHeight << '\n';
        sum = 0;

        // ���ܱ� ���̸�ŭ �ڸ���
        for(int i = 0; i < treeNum; i++) {
            if(treeHeight[i] > setCutterHeight) {
                temp = treeHeight[i] - setCutterHeight;
                sum += temp;
            }
            else {  // ������ ���� �Ǿ��ֱ⿡ ���� ���̺��� ������ ���̻� �����ʰ� ��
                break;
            }
        }
    }
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
    // ����(#include <algorithm> �ʿ�)
    // ����1: ��������(�迭�� ������)
    // ����2: ���������� + 1(�迭�� ������ + �迭�� ũ��)
    // ����3: ���� �����ϴ� ������ ���� bool�����ϴ� �񱳸޼ҵ�(���⼱ ��������)
    // ��ü�� ������ ��� x��ǥ ������ y��ǥ ū ������ �����ϴ� ������ Ȱ�� ����
    sort(treeHeight, treeHeight + treeNum, desc);

    cout << treeCutter(treeHeight, treeLength, treeNum);

    return 0;
}