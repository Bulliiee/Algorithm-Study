// 요세푸스 문제
#include <iostream>
#include <string>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    queue<int> q;
    int n, k;
    bool flag = false;

    cin >> n >> k;

    for(int i = 1; i <= n; i++) {
        q.push(i);
    }

    cout << '<';
    while(!q.empty()) {
        if(flag) { cout << ", "; }

        int temp;
        for (int i = 0; i < k - 1; i++) {
            q.push(q.front());
            q.pop();
        }
        cout << q.front();
        q.pop();

        if(!flag) { flag = true; }
    }
    cout << '>';

    return 0;
}