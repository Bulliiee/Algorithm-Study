// Hashing
#include <iostream>
#include <string>

using namespace std;

#define ull unsigned long long
#define M 1234567891
#define R 31

int hashing(int length, string str) {
    ull res = 1;
    int arr[length];

    // 알파벳을 숫자로 변환
    for(int i = 0; i < length; i++) {
        arr[i] = str[i] - 96;
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int length;
    string str;

    cin >> length >> str;

    cout << hashing(length, str);

    return 0;
}