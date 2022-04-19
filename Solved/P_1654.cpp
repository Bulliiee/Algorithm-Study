// ���� �ڸ���
#include <iostream>
#include <algorithm>

using namespace std;

#define ll long long

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}

int cutLan(int curLan, int needLan, int *arrLan) {
    ll start = 0;
    ll end = *max_element(arrLan, arrLan + curLan);
    ll mid;    // �̰� �߶� ���̰� ��
    
    int tempAmount = 0; // ����
    ll tempLength = 0; // ����

    while(start <= end) {
        tempAmount = 0;

        mid = (start + end) / 2;
        if(mid == 0) {
            mid++;
        }

        // ������ ����(mid)�� �ڸ� ���� ����(tempAmount��)
        for(int i = 0; i < curLan; i++) {
            tempAmount += (arrLan[i] / mid);
        }
        // cout << "tempAmount: " << tempAmount << '\n';

        // ������ �ʿ��� �ͺ��� ���ٸ� ������ ���̰� �� ���̴� �� ����
        if(tempAmount < needLan) {
            end = mid - 1;
        }
        // ������ �ʿ��� �ͺ��� ���ٸ� ������ ���̰� ª�� ���̴� �� �ø�
        // ������ ���ٸ� �ڸ� ���̷� ���ؼ� ū ���̰��� ����
        else {
            if(tempLength < mid) {
                tempLength = mid;
            }
            start = mid + 1;
        }
        // else {
        //     start = mid + 1;
        // }
    }

    return tempLength;
}

int main() {
    init();
    
    int curLan, needLan;
    cin >> curLan >> needLan;

    int arrLan[curLan];
    for(int i = 0; i < curLan; i++) {
        cin >> arrLan[i];
    }

    cout << cutLan(curLan, needLan, arrLan);

    return 0;
}