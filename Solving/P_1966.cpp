// 프린터 큐
#include <iostream>
#include <list>

using namespace std;

class Document {
private:
    int documentNum;    // 문서 번호
    int weight;         // 중요도
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

    // 1개만 출력할 경우 바운드 넘어가니 제외
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

    int input;                  // 테스트케이스 수
    int docAmount, printNum;    // 문서 갯수, 궁금한 문서 
    list<int> weight;         // 중요도

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