// ���� �ڸ���
#include <iostream>
#include <algorithm>

using namespace std;

bool desc(int num1, int num2) {
    return num1 > num2;
}

int treeCutter(int treeHeight[], int treeLength, int treeNum) {
    int setHeight;
    int sum = 0;

    while(sum < treeLength) {
        setHeight = treeHeight[0];  // ���� �����ɷ� ����
        for(int i = 0; i < treeNum; i++) {
            if(treeHeight[i] > setHeight) {
                
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int treeNum, treeLength;
    int *treeHeight;

    cin >> treeNum >> treeLength;
    treeHeight = new int[treeNum];

    for(int i = 0; i < treeNum; i++) {
        cin >> treeHeight[i];
    }
    // ����
    // ����1: ��������(�迭�� ������)
    // ����2: ���������� + 1(�迭�� ������ + �迭�� ũ��)
    // ����3: ���� �����ϴ� ������ ���� bool�����ϴ� �񱳸޼ҵ�(���⼱ ��������)
    // ��ü�� ������ ��� x��ǥ ������ y��ǥ ū ������ �����ϴ� ������ Ȱ�� ����
    sort(treeHeight, treeHeight + treeNum, desc);

    cout << treeCutter(treeHeight, treeLength, treeNum);

    return 0;
}