// ������ ť
#include <iostream>
#include <list>

using namespace std;

class Document {
private:
    int documentNum;    // ���� ��ȣ
    int weight;         // �߿䵵
public:
    Document() {
        documentNum = 0;
        weight = 0;
    }


};

void printDoc(int printNum, list<int> weight) {
    list<int>::iterator iter1;
    list<int>::iterator iter2;

    int size = weight.size();
    int checkNum, temp;
    int count = 0;

    // 1���� ����� ��� �ٿ�� �Ѿ�� ����
    if(size == 1) {
        count = 1;
    }
    iter1 = weight.begin();
    for(int i = 0; i < printNum; i++) {
        iter1++;
    }
    checkNum = *iter1;
    cout << "checkNum: " << checkNum << '\n';

    for(int i = 0; i < size - 1; i++) {
        iter1 = iter2 = weight.begin();
        iter2++;

        if(*iter1 < *iter2) {
            temp = *iter1;
            weight.push_back(temp);
            count--;
        }
        weight.pop_front();
        count++;
    }
    
    cout << count << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;                  // �׽�Ʈ���̽� ��
    int docAmount, printNum;    // ���� ����, �ñ��� ���� 
    list<int> weight;         // �߿䵵

    int temp;

    cin >> input;
    while(input--) {
        cin >> docAmount >> printNum;

        weight.clear();
        while(docAmount--) {
            cin >> temp;
            weight.push_back(temp);
        }

        printDoc(printNum, weight);
    }

    return 0;
}