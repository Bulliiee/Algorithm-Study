// ������ ť
#include <iostream>
#include <list> // vector���� �߰��� ������ ���� �۾�O(n) �ʿ���

using namespace std;

class Document {
private:
    int documentNum;    // ���� ��ȣ
    int weight;         // �߿䵵
public:
    Document(int docNum = 0, int weight = 0) {
        this->documentNum = docNum;
        this->weight = weight;
    }

    void printDoc() {
        cout << "docNum: " << documentNum << '\n';
        cout << "weight: " << weight << '\n';
    }

    int getDocNum() {
        return documentNum;
    }

    int getWeight() {
        return weight;
    }
};

void printerQueue(list<Document> docs, int printNum) {
    list<Document>::iterator iter;
    list<int> weightList;   // �񱳿�

    int count = 0;

    for(iter = docs.begin(); iter != docs.end(); iter++) {
        weightList.push_back(iter->getWeight());
    }
    weightList.sort(greater<int>());    // �������� ����(ū�� ������ ����)

    while(!docs.empty()) {
        if(docs.front().getWeight() == weightList.front()) {
            if(docs.front().getDocNum() == printNum) {
                cout << ++count << '\n';
                return;
            }

            weightList.pop_front();
            docs.pop_front();
            count++;
        }
        else {
            docs.push_back(docs.front());
            docs.pop_front();
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;                  // �׽�Ʈ���̽� ��
    int docAmount, printNum;    // ���� ����, �ñ��� ���� 
    list<Document> docs;         // ���� ����Ʈ

    int temp;

    cin >> input;
    while(input--) {
        cin >> docAmount >> printNum;

        for(int i = 0; i < docAmount; i++) {
            cin >> temp;
            docs.push_back(Document(i, temp));
        }

        printerQueue(docs, printNum);
        
        // Print Doc
        // for(Document temp : docs) {
        //     temp.printDoc();
        //     cout << '\n';
        // }

        docs.clear();
    }


    return 0;
}