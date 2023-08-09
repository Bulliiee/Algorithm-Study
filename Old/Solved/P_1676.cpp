// 팩토리얼 0의 개수
#include <iostream>

using namespace std;

#define min(a, b) (a < b ? a : b)

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    return;
}

/*
    뒤에 0이 나오려면 2와 5의 곱이 되어야 하고,
    0의 갯수는 인수 2와 5의 갯수 중 적은 수가 된다.
    예를 들어 600의 인수는 2, 2, 2, 3, 5, 5로, 
    5의 갯수가 2개이므로 0의 갯수가 2개인 것이다.
    위의 성질을 이용해 인수 2와 5의 갯수를 구해서
    둘 중 적은 갯수를 구하면 0의 갯수를 구할 수 있다.
*/
int getZeroCount(int num) {
    int tCount = 0; // 2와 5의 갯수
    int fCount = 0; 
    int temp;

    // 팩토리얼이니까 1 ~ 입력숫자까지 하나하나 체크하면 됨
    // 예를들어 10 입력하면
    // 1: x
    // 2: 2
    // 3: x
    // 4: 2, 2
    // 5: 5
    // 6: 2
    // 7: x
    // 8: 2, 2, 2
    // 9: x
    // 10: 2
    // 10: 5
    // 해서 인수 2의 갯수는 8개, 5의 갯수는 2개로 0의 갯수는 2개
    for(int i = 1; i <= num; i++) {
        temp = i;
        while(temp) {
            if(temp % 2 == 0) {
                tCount++;
                temp /= 2;
                // cout << "tCount: " << tCount << '\n';
            }
            else {
                // 2로 안나눠지면 인수 없는거니까 break
                break;
            }
        }

        temp = i;
        while(temp) {
            if(temp % 5 == 0) {
                fCount++;
                temp /= 5;
                // cout << "fCount: " << fCount << '\n';
            }
            else {
                break;
            }
        }
    }

    return min(tCount, fCount);
}

int main() {
    init();

    int num;

    cin >> num;

    cout << getZeroCount(num) << '\n';

    return 0;
}