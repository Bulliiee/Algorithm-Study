// 집합
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool nums[20];  // 0~20까지만 있으니까

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}

void command(string com) {
    int param;

    if(com == "add") {
        cin >> param;
        nums[param - 1] = true;
    }
    else if(com == "remove") {
        cin >> param;
        nums[param - 1] = false;
    }
    else if(com == "check") {
        cin >> param;
        cout << nums[param - 1] << '\n';
    }
    else if(com == "toggle") {
        cin >> param;
        nums[param - 1] = nums[param - 1] ? false : true;
    }
    else if(com == "all") {
        for(int i = 0; i < 20; i++) {
            nums[i] = true;
        }
    }
    else if(com == "empty") {
        for(int i = 0; i < 20; i++) {
            nums[i] = false;
        }
    }
}

int main() {
    init();
    int input;
    string inputCommand;

    cin >> input;
    while(input--) {
        cin >> inputCommand;
        command(inputCommand);
    }

    return 0;
}