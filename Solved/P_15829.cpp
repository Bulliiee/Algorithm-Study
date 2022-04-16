// Hashing
/* 모듈러 연산
(a + b) mod n = {(a mod n) + (b mod n)} mod n
(a - b) mod n = {(a mod n) - (b mod n)} mod n
(a * b) mod n = {(a mod n) * (b mod n)} mod n

그냥 연산하면 지수계산이라 숫자가 너무 커지니까
모듈러 연산의 특성을 이용해서 계산한다.
*/
#include <iostream>
#include <string>

using namespace std;

#define ull unsigned long long
#define r 31
#define M 1234567891

// mod연산을 포함한 지수 계산 함수
ull power(int num1, int num2) {
    ull res = 1;

    // res는 마지막에 mod M 하므로 M을 넘지 않고, num1도 M을 넘지 않으므로
    // 그냥 곱한 후에 한번에 mod연산 해도 결과가 같다.
    for(int i = 0; i < num2; i++) {
        res *= num1;
        res %= M;
    }

    return res;
}

int hashing(int length, string str) {
    ull res = 0;
    ull temp;

    for(int i = 0; i < length; i++) {
        // 알파벳을 mod M 하면 무조건 자기 자신이 나옴(M보다 항상 작으니까)
        // 그래서 str[i]는 mod M 안하고 적용함
        temp = power(r, i); // power는 mod M을 적용한 상태의 함수임
        res = (res + ((str[i] - 96) * temp) % M) % M;
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