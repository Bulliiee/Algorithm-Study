// 이중 우선순위 큐
// 중복 key값이 허용되는 multiset을 사용함
#include <iostream>
#include <set>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int caseNum;    // 테스트케이스 수
    char command;   // I: 값 삽입, D: 값 삭제
    int number;     // I: 삽입할 값, D: -1일경우 최소값 삭제, 1일경우 최대값 삭제
    cin >> caseNum;

    for(int i = 0; i < caseNum; i++) {
        multiset<int> set;
        int dataNum;
        cin >> dataNum;

        for(int i = 0; i < dataNum; i++) {
            cin >> command >> number;

            // 값 삽입(오름차순으로 정렬되어 값이 들어간다.)
            if(command == 'I') {
                set.insert(number);
            }
            // 값 삭제
            else {
                if(!set.empty()) {
                    // 최대값 삭제
                    if(number == 1) {
                        auto iter = set.end();  // end()는 마지막요소의 다음을 가리키므로
                        iter--;                 // --를 해준다.
                        set.erase(iter);
                    }
                    // 최소값 삭제
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