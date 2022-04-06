// 카드2
#include <iostream>
#include <list>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    list<int> cards;

    int input;
    cin >> input;

    for(int i = 1; i <= input; i++) {
        cards.push_back(i);
    }

    // 재귀함수 메모리초과 나서 여기에 넣음 그냥
    while(!cards.empty()) {
        if(cards.size() == 1) {
            cout << cards.back();
            break;
        }

        cards.erase(cards.begin());
        cards.push_back(cards.front());
        cards.erase(cards.begin());
    }

    return 0;
}