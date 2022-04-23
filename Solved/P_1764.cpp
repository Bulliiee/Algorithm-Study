// �躸��
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

// ���� �ȿ� �ִ��� �̺�Ž������ Ȯ��
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
    vector<string> dbName;  // �赵���� ���� �����
    string temp;
    int n, m;   // �赵����, �������� ��� ��
    cin >> n >> m;

    /*
    vector ��� �� push_back �ϸ� 2^n���� �޸𸮸� ����
    ������ vector.resize(int capacity)�� ������
    �̸� �޸� �Ҵ��� �ӵ��� ���� �� ����

    push_back�� �ƴ� cin >> vector[]�� ����� �迭ó�� ������ �� ����
    */
    tempVector.resize(n);
    for(int i = 0; i < n; i++) {
        cin >> tempVector[i];
    }
    sort(tempVector.begin(), tempVector.end());
    for(int i = 0; i < m; i++) {
        cin >> temp;
        
        // find()�� ã�� ���� binary_search�� Ž�� �ð��� ���δ�.
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