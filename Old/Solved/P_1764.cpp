// 듣보잡
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return ;
}

// 벡터 안에 있는지 이분탐색으로 확인
// bool haveInsede(vector<string> v, string str) {
//     int start = 0;
//     int end = v.size() - 1;
//     int mid;

//     while(end - start >= 0) {
//         mid = (start + end) / 2;

//         if(v[mid] > str) {
//             start = mid + 1;
//         }   
//         else if(v[mid] < str) {
//             end = mid - 1;
//         }     
//         else {
//             return true;
//         }
//     }

//     return false;
// }

int main() {
    init();

    vector<string> tempVector;
    vector<string> dbName;  // 듣도보도 못한 사람들
    string temp;
    int n, m;   // 듣도못한, 보도못한 사람 수
    cin >> n >> m;

    /*
    vector 사용 시 push_back 하면 2^n으로 메모리를 잡음
    하지만 vector.resize(int capacity)로 잡으면
    미리 메모리 할당해 속도를 줄일 수 있음

    push_back이 아닌 cin >> vector[]를 사용해 배열처럼 받으면 더 빠름
    */
    tempVector.resize(n);
    for(int i = 0; i < n; i++) {
        cin >> tempVector[i];
    }
    sort(tempVector.begin(), tempVector.end());
    for(int i = 0; i < m; i++) {
        cin >> temp;
        
        // find()로 찾지 말고 binary_search로 탐색 시간을 줄인다.
        if(binary_search(tempVector.begin(), tempVector.end(), temp)) {
            dbName.push_back(temp);
        }

        // if(haveInsede(tempVector, temp)) {
        //     dbName.push_back(temp);
        // }
    }

    sort(dbName.begin(), dbName.end());

    cout << dbName.size() << '\n';
    for(string t : dbName) {
        cout << t << '\n';
    }

    return 0;
}