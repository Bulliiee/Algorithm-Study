// ���� �켱���� ť
// �ߺ� key���� ���Ǵ� multiset�� �����
#include <iostream>
#include <set>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int caseNum;    // �׽�Ʈ���̽� ��
    char command;   // I: �� ����, D: �� ����
    int number;     // I: ������ ��, D: -1�ϰ�� �ּҰ� ����, 1�ϰ�� �ִ밪 ����
    cin >> caseNum;

    for(int i = 0; i < caseNum; i++) {
        multiset<int> set;
        int dataNum;
        cin >> dataNum;

        for(int i = 0; i < dataNum; i++) {
            cin >> command >> number;

            // �� ����(������������ ���ĵǾ� ���� ����.)
            if(command == 'I') {
                set.insert(number);
            }
            // �� ����
            else {
                if(!set.empty()) {
                    // �ִ밪 ����
                    if(number == 1) {
                        auto iter = set.end();  // end()�� ����������� ������ ����Ű�Ƿ�
                        iter--;                 // --�� ���ش�.
                        set.erase(iter);
                    }
                    // �ּҰ� ����
                    else {
                        set.erase(set.begin());
                    }
                }
            }
        }

        if(set.empty()) {
            cout << "EMPTY\n";
        }
        else {
            auto iter = set.end();
            iter--;
            cout << *iter << ' ' << *set.begin() << '\n';
        }
    }

    return 0;
}