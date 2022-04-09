// Á¦·Î
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> v;
    int k, temp;
    cin >> k;

    for(int i = 0; i < k; i++) {
        cin >> temp;

        if(temp == 0) {
            v.pop_back();
        }
        else {
            v.push_back(temp);
        }
    }

    temp = 0;
    for(int i = 0; i < v.size(); i++) {
        temp += v[i];
    }

    cout << temp;

    return 0;
}