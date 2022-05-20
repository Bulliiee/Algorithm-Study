// ���� ī��
#include <iostream>
#include <vector>   // ���� ���� �ð��ʰ�
#include <algorithm>

using namespace std;

// �̺�Ž��
// ã������, ã�� ��
bool cardCheck(int *card, int size, int target) {
    // �ε����� �̺�Ž�� ��
    int left = 0;
    int right = size - 1;

    while(left <= right) {
        int mid = (left + right) / 2;

        if(card[mid] == target) {
            return true;
        }
        else if(card[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    return false;
}

// input
void input(int *arr, int size) {
    for(int i = 0; i < size; i++) {
        cin >> arr[i];
    }

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int *card1, *card2;
    int n, m;

    cin >> n;
    card1 = new int[n];
    input(card1, n);
    // for(int i = 0; i < n; i++) {
    //     int temp;
    //     cin >> temp;
    //     card1[i] = temp;
    // }

    cin >> m;
    card2 = new int[m];
    input(card2, m);
    // for(int i = 0; i < m; i++) {
    //     int temp;
    //     cin >> temp;
    //     card2[i] = temp;
    // }

    // ����(�̺�Ž�� ����)
    sort(card1, card1 + n);

    for(int i = 0; i < m; i++) {
        cout << cardCheck(card1, n, card2[i]) ? 1 : 0;
        cout << ' ';
    }

    return 0;
}