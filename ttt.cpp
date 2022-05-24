// 테스트용
#include <iostream>
#define MAX 101

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    bool self[MAX] = {0};

    for(int i = 1; i < MAX; i++) {
        int temp = i;
        int sum = i;

        while(temp > 0) {
            sum = sum + (temp % 10);
            temp /= 10;
        }

        if(sum < MAX && self[sum] == false) {
            self[sum] = true;
        }
    }
    
    for(int i = 1; i < MAX; i++) {
        if(self[i] == false) {
            cout << i << '\n';
        }
    }

    return 0;
}