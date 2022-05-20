// 테스트용
#include <iostream>
#include <math.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int num1, num2, num3;
    int temp;
    int result;
    int arr[10] = { 0 };

    cin >> num1 >> num2 >> num3;

    result = num1 * num2 * num3;

    for(int i = 0; i < 9; i++) {
        temp = result / (int)pow(10, (8 - i));
        // cout << i << " temp: " << temp << '\n';

        arr[temp]++;

        result = result % (int)pow(10, (8 - i));
        // cout << i << " result: " << result << '\n';
    }

    result = num1 * num2 * num3;

    // result가 몇자리인지 체크
    int count = 0;
    while(result > 0) {
        result /= 10;
        count++;
    }

    // arr[0]을 9 - 자릿수만큼 뺌
    arr[0] = arr[0] - (9 - count);

    for(int i = 0; i < 10; i++) {
        cout << arr[i] << '\n';
    }

    return 0;
}