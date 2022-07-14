// 연세대학교
#include <iostream>

int main() {
    int input;
    std::string output;

    std::cin >> input;

    switch(input) {
        case 0:
            output = "YONSEI";
            break;
        case 1:
            output = "Leading the Way to the Future";
            break;
    }

    std::cout << output;

    return 0;
}