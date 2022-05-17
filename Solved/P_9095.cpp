// 1, 2, 3 ¥ı«œ±‚
#include <iostream>
#include <vector>

using namespace std;

vector<int> dp;

int numCheck(int num) {
    int result = 0;

    if(dp[num] != 0) {
        return dp[num];
    }

    switch(num) {
        case 1:
            dp[1] = 1;
            return 1;
            break;
        case 2:
            dp[2] = 2;
            return 2;
            break;
        case 3:
            dp[3] = 4;
            return 4;
            break;
    }

    result = numCheck(num - 1) + numCheck(num - 2) + numCheck(num - 3);

    return result;
}

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    dp.resize(11);
    for(int i = 1; i < 11; i++) {
        dp[i] = 0;
    }
}

int main() {
    init();

    int testCase;
    vector<int> nums;

    cin >> testCase;
    for(int i = 0; i < testCase; i++) {
        int temp;
        cin >> temp;
        nums.push_back(temp);
    }

    for(int i = 0; i < testCase; i++) {
        cout << numCheck(nums[i]) << '\n';
    }

    return 0;
}