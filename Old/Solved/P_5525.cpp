// IOIOI
#include <iostream>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;                  // Pn에서 n
    int strLen;             // 입력 문자열 길이
    int res = 0;            // 갯수
    string strInput;        // 입력 문자열

    // 입력
    cin >> n >> strLen;
    cin >> strInput;

    for(int i = 0; i < strLen; i++) {
        if(strInput[i] == 'I') {
            int count = 0;
            bool flag = true;

            while(flag) {
                i++;
                // 입력 문자열 안에서 한 범위 내의 Pn에서의 n을 구함(count)
                // 즉, 연속으로 나타나는 Pn의 n을 구하는 것.
                if(strInput[i] == 'O' && strInput[i + 1] == 'I') {
                    i++;
                    count++;
                }
                // 몇 군데 포함되었는지 계산한다.
                // 답을 구하기 위해 위의 if문에서 계산한 n(입력 문자열에서 연속으로 나타난 Pn)
                // 을 바탕으로 해당 Pn에 입력으로 주어진 n이 몇 개 있는지 계산한 후
                // 결과를 구한다.
                else {
                    int temp = count - n + 1;
                    if(temp > 0) {
                        res += temp;
                    }
                    flag = false;
                    i--;
                }
            }
        }
    }

    cout << res << '\n';

    return 0;
}