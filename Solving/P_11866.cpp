// �似Ǫ�� ���� 0
// c++ ����Ʈ Ȱ��
#include <iostream>
#include <list>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;

    list<int> num;
    for(int i = 1; i <= n; i++) {
        num.push_back(i);
    }

    // cout << "origin) ";
    // begin(): ù ��° ����� �ּ� ��ȯ
    // end(): ������ ��������� �ּ� ��ȯ
    // for(iter = num.begin(); iter != num.end(); iter++) {
    //     cout << *iter << " ";
    // }
    // for(int temp : num) {
        // cout << temp << " ";
    // }
    // cout << '\n';

    list<int> :: iterator iter;
    iter = num.begin();
    for(int i = 1; i < k; i++) {
        iter++;
    }

    cout << "<";
    while(n > 1) {
        n--;
        cout << *iter << ", ";
        iter = num.erase(iter);
        if(iter == num.end()) {
            iter = num.begin();
        }

        for(int i = 1; i < k; i++) {
            iter++;
            if(iter == num.end()) {
                iter = num.begin();
            }
        }
    }
    cout << *iter << ">";

    return 0;
}