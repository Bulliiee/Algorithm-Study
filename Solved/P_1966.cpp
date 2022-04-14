// 프린터 큐
#include <iostream>
#include <list> // vector쓰면 추가로 앞으로 당기는 작업O(n) 필요함

using namespace std;

class Document {
private:
    int documentNum;    // 문서 번호
    int weight;         // 중요도
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
    list<int> weightList;   // 비교용

    int count = 0;

    for(iter = docs.begin(); iter != docs.end(); iter++) {
        weightList.push_back(iter->getWeight());
    }
    weightList.sort(greater<int>());    // 내림차순 정렬(큰게 앞으로 오게)

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

    int input;                  // 테스트케이스 수
    int docAmount, printNum;    // 문서 갯수, 궁금한 문서 
    list<Document> docs;         // 문서 리스트

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