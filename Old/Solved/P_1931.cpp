// 회의실 배정
#include <iostream>
#include <vector>
#include <algorithm>
// #define MAX 100000

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<pair<int, int>> v;
    int input;
    cin >> input;
    v.resize(input);

    for(int i = 0; i < input; i++) {
        int t1, t2;
        cin >> t1 >> t2;
        // v[i] = { t1, t2 };
        v[i] = { t2, t1 };
    }

    sort(v.begin(), v.end());

    // for(int i = 0; i < input; i++) {
    //     cout << v[i].first << ", " << v[i].second << '\n';
    // }

    // 그리디
    int temp = v[0].first;
    int count = 1;
    for(int i = 1; i < input; i++) {
        if(temp <= v[i].second) {
            temp = v[i].first;
            count++;
        }
    }
    cout << count;
    // 시간초과
    // int max = 0;
    // for(int j = 0; j < input - 1; j++) {
    //     int temp = v[j].second;
    //     int count = 1;
    //     for(int i = 1; i < input; i++) {
    //         if(temp <= v[i].first) {
    //             count++;
    //             temp = v[i].second;
    //         }
    //     }
    //     if(count > max) {
    //         max = count;
    //     }
    // }
    // 
    // cout << max;

    return 0;
}