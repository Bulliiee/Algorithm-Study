// 요세푸스 문제 0
// c++ 리스트 활용
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
    // begin(): 첫 번째 요소의 주소 반환
    // end(): 마지막 다음요소의 주소 반환
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